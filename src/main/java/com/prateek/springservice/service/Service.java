package com.prateek.springservice.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.prateek.springservice.dto.LeaderBoardDTO;
import com.prateek.springservice.dto.MatchScheduleAndResultDTO;
import com.prateek.springservice.dto.SemiAndFinalsDTO;
import com.prateek.springservice.dto.UserDto;
import com.prateek.springservice.entity.MatchResult;
import com.prateek.springservice.entity.MatchSchedule;
import com.prateek.springservice.entity.SemiAndFinals;
import com.prateek.springservice.entity.User;
import com.prateek.springservice.exception.ApplicationRuntimeException;
import com.prateek.springservice.repo.MatchResultRepository;
import com.prateek.springservice.repo.MatchScheduleRepository;
import com.prateek.springservice.repo.SemifinalsAndFinalsRepo;
import com.prateek.springservice.repo.UserRepository;
import com.prateek.springservice.utility.ApplicationUtility;

/**
 * @author prateek.mishra Service class performaing actual CRUD operations
 */
@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private MatchScheduleRepository matchScheduleRepository;

	@Autowired
	private MatchResultRepository matchResultRepository;

	@Autowired
	private SemifinalsAndFinalsRepo semifinalsAndFinalsRepo;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
	SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MMM-dd");
	SimpleDateFormat timeParser = new SimpleDateFormat("HH:mm");
	LeaderBoardComparator leaderBoardComparator = new LeaderBoardComparator();

	private List<User> userList = new ArrayList<>();
	private List<SemiAndFinals> semiAndFinals = new ArrayList<>();
	private List<MatchResult> matchResults = new ArrayList<>();
	private List<MatchSchedule> matchSchedules = new ArrayList<>();
	private Map<String, String> mapOfUserAndPics = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

	public void initAndLoad() {
		userList = userRepo.findAll();
		matchSchedules = matchScheduleRepository.findAll();
		matchResults = matchResultRepository.findAll();
		semiAndFinals = semifinalsAndFinalsRepo.findAll();
		
		mapOfUserAndPics.put("Aditya", "assets\\img\\Photos1\\player_eddy.jpg");
		mapOfUserAndPics.put("Nishant", "assets\\img\\Photos1\\Player1_Nishant.jpg");
		mapOfUserAndPics.put("Arpit", "assets\\img\\Photos1\\Player2_Puchi.jpg");
		mapOfUserAndPics.put("Meenakshi", "assets\\img\\Photos1\\meenakshi.jpg");
		mapOfUserAndPics.put("Prateek", "assets\\img\\Photos1\\player5_prateek.jpg");
		mapOfUserAndPics.put("Hrishi", "assets\\img\\Photos1\\player6_hrishi.jpg");
		mapOfUserAndPics.put("Sonal", "assets\\img\\Photos1\\player7_Sonal.jpg");
		mapOfUserAndPics.put("Shubham", "assets\\img\\Photos1\\Player8_Shubham.jpg");
		mapOfUserAndPics.put("Anita", "assets\\img\\Photos1\\Player9_Annie.jpg");
		mapOfUserAndPics.put("Pranjal", "assets\\img\\Photos1\\player10_pranjal.jpg");
		mapOfUserAndPics.put("TBA", "assets\\img\\Photos1\\unknown.jpg");
	}

	public List<UserDto> getAllUsers() {
		final List<UserDto> users = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			UserDto user = new UserDto();
			BeanUtils.copyProperties(userList.get(i), user);
			users.add(user);
		}
		return users;
	}

	public void createNewMatch(MatchScheduleAndResultDTO dto, int version) throws Exception {
		initAndLoad();
		if (!(mapOfUserAndPics.containsKey(dto.getUser1()) && mapOfUserAndPics.containsKey(dto.getUser2())
				&& mapOfUserAndPics.containsKey(dto.getUser3()) && mapOfUserAndPics.containsKey(dto.getUser4()))) {
			throw new RuntimeException("Not Found");
		}

		MatchSchedule matchSchedule = new MatchSchedule();
		matchSchedule.setUser1(dto.getUser1());
		matchSchedule.setUser2(dto.getUser2());
		matchSchedule.setUser3(dto.getUser3());
		matchSchedule.setUser4(dto.getUser4());
		matchSchedule.setVersion(version);
		Date date = sdf.parse(dto.getMatchDate());
		matchSchedule.setMatchDateAndTime(date);
		matchScheduleRepository.save(matchSchedule);
	}

	public void createNewMatchResult(MatchScheduleAndResultDTO dto, int version) throws Exception {
		initAndLoad();

		if (!(mapOfUserAndPics.containsKey(dto.getWinner()) && mapOfUserAndPics.containsKey(dto.getFirstrunnerunnerup())
				&& mapOfUserAndPics.containsKey(dto.getSecondrunnerup())
				&& mapOfUserAndPics.containsKey(dto.getLost()))) {
			throw new RuntimeException("User Not Found");
		}

		MatchSchedule schedule = null;

		for (MatchSchedule currrSchedule : matchSchedules) {
			if (dto.getMatchId() == currrSchedule.getId()) {
				schedule = currrSchedule;
			}
		}
		if (schedule == null) {
			throw new RuntimeException("Schedule not found");
		}

		MatchResult result = null;
		for (MatchResult currResult : matchResults) {
			if (currResult.getMatchid() == schedule.getId()) {
				throw new RuntimeException("Result Already added");
			}
		}

		result = new MatchResult();
		result.setWinner1(dto.getWinner());
		result.setWinner2(dto.getFirstrunnerunnerup());
		result.setWinner3(dto.getSecondrunnerup());
		result.setWinner4(dto.getLost());
		result.setMatchid(schedule.getId());
		result.setVersion(version);
		matchResultRepository.save(result);
	}

	public List<LeaderBoardDTO> getLeaderBoard(int version) {
		List<LeaderBoardDTO> leaderBoardDTOs = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			LeaderBoardDTO leaderBoardDTO = new LeaderBoardDTO();
			User currentUser = userList.get(i);
			if (currentUser.getName().trim().equalsIgnoreCase("TBA")) {
				continue;
			}

			int points = 0;
			int win = 0, lost = 0, notplayed = 0,totalMatches=0;
			for (int j = 0; j < matchResults.size(); j++) {
				MatchResult currentResult = matchResults.get(j);
				if (version != currentResult.getVersion()) {
					continue;
				}

				if (currentResult.getWinner1().trim().equalsIgnoreCase(currentUser.getName().trim())) {
					points = points + 40;
					win = win + 1;
				} else if (currentResult.getWinner2().trim().equalsIgnoreCase(currentUser.getName().trim())) {
					points = points + 20;
				} else if (currentResult.getWinner3().trim().equalsIgnoreCase(currentUser.getName().trim())) {
					points = points + 10;
				} else if (currentResult.getWinner4().trim().equalsIgnoreCase(currentUser.getName().trim())) {
					lost = lost + 1;
				} else {
					notplayed = notplayed + 1;
				}
				totalMatches= totalMatches+1;
			}

			leaderBoardDTO.setId(currentUser.getId());
			leaderBoardDTO.setLost(lost);
			leaderBoardDTO.setPoints(points);
			leaderBoardDTO.setName(currentUser.getName());
			leaderBoardDTO.setWon(win);
			leaderBoardDTO.setPlayed(totalMatches - notplayed);
			leaderBoardDTO.setPhoto(mapOfUserAndPics.get(currentUser.getName()));
			leaderBoardDTOs.add(leaderBoardDTO);
		}
		Collections.sort(leaderBoardDTOs, leaderBoardComparator);
		return leaderBoardDTOs;
	}

	public List<MatchScheduleAndResultDTO> getUpcomingMatches(int version) {
		List<MatchScheduleAndResultDTO> dtos = new ArrayList<>();

		for (int j = 0; j < matchSchedules.size(); j++) {
			MatchSchedule schedule = matchSchedules.get(j);
			if (schedule.getVersion() != version) {
				continue;
			}
			MatchResult result = null;

			for (int i = 0; i < matchResults.size(); i++) {
				MatchResult currResult = matchResults.get(i);
				if (currResult.getVersion() != version) {
					continue;
				}
				if (currResult.getMatchid() == schedule.getId()) {
					result = currResult;
					break;
				}
			}
			if (result == null) {
				// match done not upcomming
				dtos.add(populateDTO(true, (dtos.size() + 1), null, schedule));
			}

		}
		return dtos;
	}

	public List<MatchScheduleAndResultDTO> getPreviousMatches(int version) {
		List<MatchScheduleAndResultDTO> dtos = new ArrayList<>();

		for (int j = 0; j < matchSchedules.size(); j++) {
			MatchSchedule schedule = matchSchedules.get(j);
			if (schedule.getVersion() != version) {
				continue;
			}
			MatchResult result = null;

			for (int i = 0; i < matchResults.size(); i++) {
				MatchResult currResult = matchResults.get(i);
				if (currResult.getVersion() != version) {
					continue;
				}
				if (currResult.getMatchid() == schedule.getId()) {
					result = currResult;
					break;
				}
			}
			if (result != null) {
				dtos.add(populateDTO(false, (dtos.size() + 1), result, schedule));
				continue;
			}
		}
		return dtos;
	}

	private MatchScheduleAndResultDTO populateDTO(boolean isUpcomming, int id, MatchResult result,
			MatchSchedule schedule) {
		MatchScheduleAndResultDTO dto = new MatchScheduleAndResultDTO();
		if (isUpcomming) {
			dto.matchName("Upcomming Match " + id);
		} else {
			dto.matchName("Match " + id);
		}

		dto.setMatchDate(dateParser.format(schedule.getMatchDateAndTime()));
		dto.setMatchTime(timeParser.format(schedule.getMatchDateAndTime()));
		dto.setUser1(schedule.getUser1());
		dto.setUser2(schedule.getUser2());
		dto.setUser3(schedule.getUser3());
		dto.setUser4(schedule.getUser4());
		dto.setPhoto1(mapOfUserAndPics.get(schedule.getUser1().trim()));
		dto.setPhoto2(mapOfUserAndPics.get(schedule.getUser2().trim()));
		dto.setPhoto3(mapOfUserAndPics.get(schedule.getUser3().trim()));
		dto.setPhoto4(mapOfUserAndPics.get(schedule.getUser4().trim()));
		dto.setMatchId(schedule.getId());

		if (null != result) {
			dto.setWinner(result.getWinner1());
			dto.setFirstrunnerunnerup(result.getWinner2());
			dto.setSecondrunnerup(result.getWinner3());
			dto.setLost(result.getWinner4());
			dto.setMatchResultId(result.getId());
		}
		return dto;
	}

	public void deleteSchedule(Integer id) {
		initAndLoad();
		MatchSchedule schedule = null;
		for (int i = 0; i < matchSchedules.size(); i++) {

			MatchSchedule currSchedule = matchSchedules.get(i);
			if (currSchedule.getId() == id) {
				schedule = currSchedule;
				break;
			}
		}
		if (null != schedule) {
			matchScheduleRepository.delete(schedule);
			initAndLoad();
		} else {
			throw new RuntimeException("Not found");
		}
	}

	public void deleteMatchRecord(Integer id) {
		initAndLoad();
		MatchResult result = null;
		for (int i = 0; i < matchResults.size(); i++) {

			MatchResult currResult = matchResults.get(i);
			if (currResult.getId() == id) {
				result = currResult;
				break;
			}
		}
		if (null != result) {
			matchResultRepository.delete(result);
			initAndLoad();
		} else {
			throw new RuntimeException("Not found");
		}
	}

	public List<SemiAndFinalsDTO> getSemiFinalsData(int version) {

		/*
		 * 1 {0,1}
		 *  2 {3 4}
		 * 3 {6 7}
		 *  4 {9 10}
		 */
		SemiAndFinals semi1 = null, semi2 = null;
		List<SemiAndFinalsDTO> list = new ArrayList<>();
		try {

			if (version == 1) {
				semi1 = semiAndFinals.get(0);
				semi2 = semiAndFinals.get(1);
			} else if (version == 2) {
				semi1 = semiAndFinals.get(3);
				semi2 = semiAndFinals.get(4);
			} else if (version == 3) {
				semi1 = semiAndFinals.get(6);
				semi2 = semiAndFinals.get(7);
			} else if (version == 4) {
				semi1 = semiAndFinals.get(9);
				semi2 = semiAndFinals.get(10);
			}
		} catch (Exception e) {
			return list;
		}

		

		SemiAndFinalsDTO semi1Data = new SemiAndFinalsDTO();
		semi1Data.setPhoto1(mapOfUserAndPics.get(semi1.getPlayer1()));
		semi1Data.setPhoto2(mapOfUserAndPics.get(semi1.getPlayer2()));
		semi1Data.setPhoto3(mapOfUserAndPics.get(semi1.getPlayer3()));
		semi1Data.setPhoto4(mapOfUserAndPics.get(semi1.getPlayer4()));
		semi1Data.setWinner(semi1.getWinner1());
		semi1Data.setSecond(semi1.getWinner2());

		SemiAndFinalsDTO semi2Data = new SemiAndFinalsDTO();
		semi2Data.setPhoto1(mapOfUserAndPics.get(semi2.getPlayer1()));
		semi2Data.setPhoto2(mapOfUserAndPics.get(semi2.getPlayer2()));
		semi2Data.setPhoto3(mapOfUserAndPics.get(semi2.getPlayer3()));
		semi2Data.setPhoto4(mapOfUserAndPics.get(semi2.getPlayer4()));
		semi2Data.setWinner(semi2.getWinner1());
		semi2Data.setSecond(semi2.getWinner2());

		list.add(semi1Data);
		list.add(semi2Data);
		return list;
	}

	public SemiAndFinalsDTO getFinalsData(int version) {

		SemiAndFinalsDTO finals = new SemiAndFinalsDTO();
		SemiAndFinals finalsFromDB = semiAndFinals.get(2);
		try {

			if (version == 1) {
				finalsFromDB = semiAndFinals.get(2);
			} else if (version == 2) {
				finalsFromDB = semiAndFinals.get(5);
			} else if (version == 3) {
				finalsFromDB = semiAndFinals.get(8);
			} else if (version == 4) {
				finalsFromDB = semiAndFinals.get(11);
			}
		} catch (Exception e) {
			return finals;
		}		

		finals.setPhoto1(mapOfUserAndPics.get(finalsFromDB.getPlayer1()));
		finals.setPhoto2(mapOfUserAndPics.get(finalsFromDB.getPlayer2()));
		finals.setPhoto3(mapOfUserAndPics.get(finalsFromDB.getPlayer3()));
		finals.setPhoto4(mapOfUserAndPics.get(finalsFromDB.getPlayer4()));
		finals.setWinnerName(finalsFromDB.getWinner1());
		finals.setWinnerPic(mapOfUserAndPics.get(finalsFromDB.getWinner1()));
		return finals;
	};
}
