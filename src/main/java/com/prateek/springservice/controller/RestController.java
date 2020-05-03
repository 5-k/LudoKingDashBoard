package com.prateek.springservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prateek.springservice.dto.MatchScheduleAndResultDTO;
import com.prateek.springservice.service.Service;
import com.prateek.springservice.utility.JsonResponse;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private Service service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/leaderBoard", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  getLeaderBoard() {
		return new ResponseEntity(service.getLeaderBoard(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/refresh", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  refresh() {
		service.initAndLoad();
		return new ResponseEntity("ok", HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET, value = "/api/previousMatches", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  getPreviousMatches() {
		return new ResponseEntity(service.getPreviousMatches(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/upcommingMatches", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  getUpcomingMatches() {
		return new ResponseEntity(service.getUpcomingMatches(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/createMatch", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  createNewMatch(@RequestBody MatchScheduleAndResultDTO dto) throws Exception {
		service.createNewMatch(dto);
		return new ResponseEntity(new JsonResponse("Created New Match"), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/createResult", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  createNewMatchResult(@RequestBody MatchScheduleAndResultDTO dto) throws Exception {
		service.createNewMatchResult(dto);
		return new ResponseEntity(new JsonResponse("Result Added"), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/Schedule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  deleteSchedule(@PathVariable("id")Integer id) throws Exception {
		service.deleteSchedule(id);
		return new ResponseEntity(new JsonResponse("Deleted Match"), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/Result/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  deleteMatchResult(@PathVariable("id")Integer id) throws Exception {
		service.deleteMatchRecord(id);
		return new ResponseEntity(new JsonResponse("Result Deleted"), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/semifinals", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  semifinals() {
		return new ResponseEntity(service.getSemiFinalsData(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/finals", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  finals() {
		return new ResponseEntity(service.getFinalsData(), HttpStatus.OK);
	}
	
	
}
