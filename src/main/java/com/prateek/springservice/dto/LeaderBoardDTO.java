package com.prateek.springservice.dto;

import java.util.Objects;

public class LeaderBoardDTO {

    private int id;
    private String name;
    private int played;
    private int won;
    private int lost;
    private int points;
    private String photo;
    


    public LeaderBoardDTO() {
    }

    public LeaderBoardDTO(int id, String name, int played, int won, int lost, int points, String photo) {
        this.id = id;
        this.name = name;
        this.played = played;
        this.won = won;
        this.lost = lost;
        this.points = points;
        this.photo = photo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayed() {
        return this.played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return this.won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLost() {
        return this.lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LeaderBoardDTO id(int id) {
        this.id = id;
        return this;
    }

    public LeaderBoardDTO name(String name) {
        this.name = name;
        return this;
    }

    public LeaderBoardDTO played(int played) {
        this.played = played;
        return this;
    }

    public LeaderBoardDTO won(int won) {
        this.won = won;
        return this;
    }

    public LeaderBoardDTO lost(int lost) {
        this.lost = lost;
        return this;
    }

    public LeaderBoardDTO points(int points) {
        this.points = points;
        return this;
    }

    public LeaderBoardDTO photo(String photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LeaderBoardDTO)) {
            return false;
        }
        LeaderBoardDTO leaderBoardDTO = (LeaderBoardDTO) o;
        return id == leaderBoardDTO.id && Objects.equals(name, leaderBoardDTO.name) && played == leaderBoardDTO.played && won == leaderBoardDTO.won && lost == leaderBoardDTO.lost && points == leaderBoardDTO.points && Objects.equals(photo, leaderBoardDTO.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, played, won, lost, points, photo);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", played='" + getPlayed() + "'" +
            ", won='" + getWon() + "'" +
            ", lost='" + getLost() + "'" +
            ", points='" + getPoints() + "'" +
            ", photo='" + getPhoto() + "'" +
            "}";
    }


}