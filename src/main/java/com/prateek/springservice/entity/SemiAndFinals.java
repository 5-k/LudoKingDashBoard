package com.prateek.springservice.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Semi_and_finals")
public class SemiAndFinals {
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="player1")
    private String player1;

    @Column(name="player2")
    private String player2;

    @Column(name="player3")
    private String player3;

    @Column(name="player4")
    private String player4;

    @Column(name="winner1")
    private String winner1;

    @Column(name="winner2")
    private String winner2;

    @Column(name="version")
    private int version;


    public SemiAndFinals() {
    }

    public SemiAndFinals(int id, String name, String player1, String player2, String player3, String player4, String winner1, String winner2, int version) {
        this.id = id;
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.winner1 = winner1;
        this.winner2 = winner2;
        this.version = version;
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

    public String getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return this.player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return this.player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
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

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public SemiAndFinals id(int id) {
        this.id = id;
        return this;
    }

    public SemiAndFinals name(String name) {
        this.name = name;
        return this;
    }

    public SemiAndFinals player1(String player1) {
        this.player1 = player1;
        return this;
    }

    public SemiAndFinals player2(String player2) {
        this.player2 = player2;
        return this;
    }

    public SemiAndFinals player3(String player3) {
        this.player3 = player3;
        return this;
    }

    public SemiAndFinals player4(String player4) {
        this.player4 = player4;
        return this;
    }

    public SemiAndFinals winner1(String winner1) {
        this.winner1 = winner1;
        return this;
    }

    public SemiAndFinals winner2(String winner2) {
        this.winner2 = winner2;
        return this;
    }

    public SemiAndFinals version(int version) {
        this.version = version;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SemiAndFinals)) {
            return false;
        }
        SemiAndFinals semiAndFinals = (SemiAndFinals) o;
        return id == semiAndFinals.id && Objects.equals(name, semiAndFinals.name) && Objects.equals(player1, semiAndFinals.player1) && Objects.equals(player2, semiAndFinals.player2) && Objects.equals(player3, semiAndFinals.player3) && Objects.equals(player4, semiAndFinals.player4) && Objects.equals(winner1, semiAndFinals.winner1) && Objects.equals(winner2, semiAndFinals.winner2) && version == semiAndFinals.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, player1, player2, player3, player4, winner1, winner2, version);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", player1='" + getPlayer1() + "'" +
            ", player2='" + getPlayer2() + "'" +
            ", player3='" + getPlayer3() + "'" +
            ", player4='" + getPlayer4() + "'" +
            ", winner1='" + getWinner1() + "'" +
            ", winner2='" + getWinner2() + "'" +
            ", version='" + getVersion() + "'" +
            "}";
    }


}