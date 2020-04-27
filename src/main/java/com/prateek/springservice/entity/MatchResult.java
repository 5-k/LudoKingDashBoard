package com.prateek.springservice.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Match_Result")
public class MatchResult {

    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="match_id",nullable=false,unique = true)
    private int matchid;
    
	@Column(name="winner1",nullable=false)
    private String winner1;
    
	@Column(name="winner2",nullable=false)
    private String winner2;
    
	@Column(name="winner3",nullable=false)
    private String winner3;
    
	@Column(name="winner4",nullable=false)
    private String winner4;

    public MatchResult() {
    }

    public MatchResult(int id, int matchid, String winner1, String winner2, String winner3, String winner4) {
        this.id = id;
        this.matchid = matchid;
        this.winner1 = winner1;
        this.winner2 = winner2;
        this.winner3 = winner3;
        this.winner4 = winner4;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatchid() {
        return this.matchid;
    }

    public void setMatchid(int matchid) {
        this.matchid = matchid;
    }

    public String getWinner1() {
        return this.winner1;
    }

    public void setWinner1(String winner1) {
        this.winner1 = winner1;
    }

    public String getWinner2() {
        return this.winner2;
    }

    public void setWinner2(String winner2) {
        this.winner2 = winner2;
    }

    public String getWinner3() {
        return this.winner3;
    }

    public void setWinner3(String winner3) {
        this.winner3 = winner3;
    }

    public String getWinner4() {
        return this.winner4;
    }

    public void setWinner4(String winner4) {
        this.winner4 = winner4;
    }

    public MatchResult id(int id) {
        this.id = id;
        return this;
    }

    public MatchResult matchid(int matchid) {
        this.matchid = matchid;
        return this;
    }

    public MatchResult winner1(String winner1) {
        this.winner1 = winner1;
        return this;
    }

    public MatchResult winner2(String winner2) {
        this.winner2 = winner2;
        return this;
    }

    public MatchResult winner3(String winner3) {
        this.winner3 = winner3;
        return this;
    }

    public MatchResult winner4(String winner4) {
        this.winner4 = winner4;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MatchResult)) {
            return false;
        }
        MatchResult matchResult = (MatchResult) o;
        return id == matchResult.id && matchid == matchResult.matchid && Objects.equals(winner1, matchResult.winner1) && Objects.equals(winner2, matchResult.winner2) && Objects.equals(winner3, matchResult.winner3) && Objects.equals(winner4, matchResult.winner4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matchid, winner1, winner2, winner3, winner4);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", matchid='" + getMatchid() + "'" +
            ", winner1='" + getWinner1() + "'" +
            ", winner2='" + getWinner2() + "'" +
            ", winner3='" + getWinner3() + "'" +
            ", winner4='" + getWinner4() + "'" +
            "}";
    }

}