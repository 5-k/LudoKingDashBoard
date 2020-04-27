package com.prateek.springservice.dto;

import java.util.Objects;

public class MatchScheduleAndResultDTO {

         private int matchId;
         private int matchResultId;
		 private String user1;   
		 private String user2;  
		 private String user3;   
		 private String user4;  
		 private String winner;   
		 private String firstrunnerunnerup; 
		 private String secondrunnerup;   
		 private String lost;  
		 private String matchName;   
		 private String matchDate;   
		 private String matchTime;  
		 private String photo1;   
		 private String photo2;   
		 private String photo3;   //assets/img/Photos1/player2_Puchi.jpg 
		 private String photo4;

    public MatchScheduleAndResultDTO() {
    }

    public MatchScheduleAndResultDTO(int matchId, int matchResultId, String user1, String user2, String user3, String user4, String winner, String firstrunnerunnerup, String secondrunnerup, String lost, String matchName, String matchDate, String matchTime, String photo1, String photo2, String photo3, String photo4) {
        this.matchId = matchId;
        this.matchResultId = matchResultId;
        this.user1 = user1;
        this.user2 = user2;
        this.user3 = user3;
        this.user4 = user4;
        this.winner = winner;
        this.firstrunnerunnerup = firstrunnerunnerup;
        this.secondrunnerup = secondrunnerup;
        this.lost = lost;
        this.matchName = matchName;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.photo4 = photo4;
    }

    public int getMatchId() {
        return this.matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getMatchResultId() {
        return this.matchResultId;
    }

    public void setMatchResultId(int matchResultId) {
        this.matchResultId = matchResultId;
    }

    public String getUser1() {
        return this.user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return this.user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getUser3() {
        return this.user3;
    }

    public void setUser3(String user3) {
        this.user3 = user3;
    }

    public String getUser4() {
        return this.user4;
    }

    public void setUser4(String user4) {
        this.user4 = user4;
    }

    public String getWinner() {
        return this.winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getFirstrunnerunnerup() {
        return this.firstrunnerunnerup;
    }

    public void setFirstrunnerunnerup(String firstrunnerunnerup) {
        this.firstrunnerunnerup = firstrunnerunnerup;
    }

    public String getSecondrunnerup() {
        return this.secondrunnerup;
    }

    public void setSecondrunnerup(String secondrunnerup) {
        this.secondrunnerup = secondrunnerup;
    }

    public String getLost() {
        return this.lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getMatchName() {
        return this.matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getMatchDate() {
        return this.matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchTime() {
        return this.matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getPhoto1() {
        return this.photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return this.photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return this.photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getPhoto4() {
        return this.photo4;
    }

    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
    }

    public MatchScheduleAndResultDTO matchId(int matchId) {
        this.matchId = matchId;
        return this;
    }

    public MatchScheduleAndResultDTO matchResultId(int matchResultId) {
        this.matchResultId = matchResultId;
        return this;
    }

    public MatchScheduleAndResultDTO user1(String user1) {
        this.user1 = user1;
        return this;
    }

    public MatchScheduleAndResultDTO user2(String user2) {
        this.user2 = user2;
        return this;
    }

    public MatchScheduleAndResultDTO user3(String user3) {
        this.user3 = user3;
        return this;
    }

    public MatchScheduleAndResultDTO user4(String user4) {
        this.user4 = user4;
        return this;
    }

    public MatchScheduleAndResultDTO winner(String winner) {
        this.winner = winner;
        return this;
    }

    public MatchScheduleAndResultDTO firstrunnerunnerup(String firstrunnerunnerup) {
        this.firstrunnerunnerup = firstrunnerunnerup;
        return this;
    }

    public MatchScheduleAndResultDTO secondrunnerup(String secondrunnerup) {
        this.secondrunnerup = secondrunnerup;
        return this;
    }

    public MatchScheduleAndResultDTO lost(String lost) {
        this.lost = lost;
        return this;
    }

    public MatchScheduleAndResultDTO matchName(String matchName) {
        this.matchName = matchName;
        return this;
    }

    public MatchScheduleAndResultDTO matchDate(String matchDate) {
        this.matchDate = matchDate;
        return this;
    }

    public MatchScheduleAndResultDTO matchTime(String matchTime) {
        this.matchTime = matchTime;
        return this;
    }

    public MatchScheduleAndResultDTO photo1(String photo1) {
        this.photo1 = photo1;
        return this;
    }

    public MatchScheduleAndResultDTO photo2(String photo2) {
        this.photo2 = photo2;
        return this;
    }

    public MatchScheduleAndResultDTO photo3(String photo3) {
        this.photo3 = photo3;
        return this;
    }

    public MatchScheduleAndResultDTO photo4(String photo4) {
        this.photo4 = photo4;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MatchScheduleAndResultDTO)) {
            return false;
        }
        MatchScheduleAndResultDTO matchScheduleAndResultDTO = (MatchScheduleAndResultDTO) o;
        return matchId == matchScheduleAndResultDTO.matchId && matchResultId == matchScheduleAndResultDTO.matchResultId && Objects.equals(user1, matchScheduleAndResultDTO.user1) && Objects.equals(user2, matchScheduleAndResultDTO.user2) && Objects.equals(user3, matchScheduleAndResultDTO.user3) && Objects.equals(user4, matchScheduleAndResultDTO.user4) && Objects.equals(winner, matchScheduleAndResultDTO.winner) && Objects.equals(firstrunnerunnerup, matchScheduleAndResultDTO.firstrunnerunnerup) && Objects.equals(secondrunnerup, matchScheduleAndResultDTO.secondrunnerup) && Objects.equals(lost, matchScheduleAndResultDTO.lost) && Objects.equals(matchName, matchScheduleAndResultDTO.matchName) && Objects.equals(matchDate, matchScheduleAndResultDTO.matchDate) && Objects.equals(matchTime, matchScheduleAndResultDTO.matchTime) && Objects.equals(photo1, matchScheduleAndResultDTO.photo1) && Objects.equals(photo2, matchScheduleAndResultDTO.photo2) && Objects.equals(photo3, matchScheduleAndResultDTO.photo3) && Objects.equals(photo4, matchScheduleAndResultDTO.photo4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, matchResultId, user1, user2, user3, user4, winner, firstrunnerunnerup, secondrunnerup, lost, matchName, matchDate, matchTime, photo1, photo2, photo3, photo4);
    }

    @Override
    public String toString() {
        return "{" +
            " matchId='" + getMatchId() + "'" +
            ", matchResultId='" + getMatchResultId() + "'" +
            ", user1='" + getUser1() + "'" +
            ", user2='" + getUser2() + "'" +
            ", user3='" + getUser3() + "'" +
            ", user4='" + getUser4() + "'" +
            ", winner='" + getWinner() + "'" +
            ", firstrunnerunnerup='" + getFirstrunnerunnerup() + "'" +
            ", secondrunnerup='" + getSecondrunnerup() + "'" +
            ", lost='" + getLost() + "'" +
            ", matchName='" + getMatchName() + "'" +
            ", matchDate='" + getMatchDate() + "'" +
            ", matchTime='" + getMatchTime() + "'" +
            ", photo1='" + getPhoto1() + "'" +
            ", photo2='" + getPhoto2() + "'" +
            ", photo3='" + getPhoto3() + "'" +
            ", photo4='" + getPhoto4() + "'" +
            "}";
    }
    
         
}