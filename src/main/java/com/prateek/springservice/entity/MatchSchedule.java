package com.prateek.springservice.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MatchSchedule")
public class MatchSchedule {

    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

	@Column(name="user1",nullable=false)
    private String user1;
    
	@Column(name="user2",nullable=false)
    private String user2;
    
	@Column(name="user3",nullable=false)
    private String user3;
    
	@Column(name="user4",nullable=false)
    private String user4;

    @Column(name="version")
    private int version;

    @Column(name="matchDateAndTime",nullable=false)
    private Date matchDateAndTime; //yyyy-MM-dd HH:MM:ss
	

    public MatchSchedule() {
    }

    public MatchSchedule(int id, String user1, String user2, String user3, String user4, int version, Date matchDateAndTime) {
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.user3 = user3;
        this.user4 = user4;
        this.version = version;
        this.matchDateAndTime = matchDateAndTime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getMatchDateAndTime() {
        return this.matchDateAndTime;
    }

    public void setMatchDateAndTime(Date matchDateAndTime) {
        this.matchDateAndTime = matchDateAndTime;
    }

    public MatchSchedule id(int id) {
        this.id = id;
        return this;
    }

    public MatchSchedule user1(String user1) {
        this.user1 = user1;
        return this;
    }

    public MatchSchedule user2(String user2) {
        this.user2 = user2;
        return this;
    }

    public MatchSchedule user3(String user3) {
        this.user3 = user3;
        return this;
    }

    public MatchSchedule user4(String user4) {
        this.user4 = user4;
        return this;
    }

    public MatchSchedule version(int version) {
        this.version = version;
        return this;
    }

    public MatchSchedule matchDateAndTime(Date matchDateAndTime) {
        this.matchDateAndTime = matchDateAndTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MatchSchedule)) {
            return false;
        }
        MatchSchedule matchSchedule = (MatchSchedule) o;
        return id == matchSchedule.id && Objects.equals(user1, matchSchedule.user1) && Objects.equals(user2, matchSchedule.user2) && Objects.equals(user3, matchSchedule.user3) && Objects.equals(user4, matchSchedule.user4) && version == matchSchedule.version && Objects.equals(matchDateAndTime, matchSchedule.matchDateAndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user1, user2, user3, user4, version, matchDateAndTime);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user1='" + getUser1() + "'" +
            ", user2='" + getUser2() + "'" +
            ", user3='" + getUser3() + "'" +
            ", user4='" + getUser4() + "'" +
            ", version='" + getVersion() + "'" +
            ", matchDateAndTime='" + getMatchDateAndTime() + "'" +
            "}";
    }

    
}