package com.prateek.springservice.dto;

import java.util.Objects;

public class SemiAndFinalsDTO {

    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    
    //specific for semifinals
    private String winner;
    private String second;
    
    //specific for finals
    private String winnerPic;
    private String winnerName;

    public SemiAndFinalsDTO() {
    }

    public SemiAndFinalsDTO(String photo1, String photo2, String photo3, String photo4, String winner, String second, String winnerPic, String winnerName) {
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.photo4 = photo4;
        this.winner = winner;
        this.second = second;
        this.winnerPic = winnerPic;
        this.winnerName = winnerName;
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

    public String getWinner() {
        return this.winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getSecond() {
        return this.second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getWinnerPic() {
        return this.winnerPic;
    }

    public void setWinnerPic(String winnerPic) {
        this.winnerPic = winnerPic;
    }

    public String getWinnerName() {
        return this.winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public SemiAndFinalsDTO photo1(String photo1) {
        this.photo1 = photo1;
        return this;
    }

    public SemiAndFinalsDTO photo2(String photo2) {
        this.photo2 = photo2;
        return this;
    }

    public SemiAndFinalsDTO photo3(String photo3) {
        this.photo3 = photo3;
        return this;
    }

    public SemiAndFinalsDTO photo4(String photo4) {
        this.photo4 = photo4;
        return this;
    }

    public SemiAndFinalsDTO winner(String winner) {
        this.winner = winner;
        return this;
    }

    public SemiAndFinalsDTO second(String second) {
        this.second = second;
        return this;
    }

    public SemiAndFinalsDTO winnerPic(String winnerPic) {
        this.winnerPic = winnerPic;
        return this;
    }

    public SemiAndFinalsDTO winnerName(String winnerName) {
        this.winnerName = winnerName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SemiAndFinalsDTO)) {
            return false;
        }
        SemiAndFinalsDTO semiAndFinalsDTO = (SemiAndFinalsDTO) o;
        return Objects.equals(photo1, semiAndFinalsDTO.photo1) && Objects.equals(photo2, semiAndFinalsDTO.photo2) && Objects.equals(photo3, semiAndFinalsDTO.photo3) && Objects.equals(photo4, semiAndFinalsDTO.photo4) && Objects.equals(winner, semiAndFinalsDTO.winner) && Objects.equals(second, semiAndFinalsDTO.second) && Objects.equals(winnerPic, semiAndFinalsDTO.winnerPic) && Objects.equals(winnerName, semiAndFinalsDTO.winnerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photo1, photo2, photo3, photo4, winner, second, winnerPic, winnerName);
    }

    @Override
    public String toString() {
        return "{" +
            " photo1='" + getPhoto1() + "'" +
            ", photo2='" + getPhoto2() + "'" +
            ", photo3='" + getPhoto3() + "'" +
            ", photo4='" + getPhoto4() + "'" +
            ", winner='" + getWinner() + "'" +
            ", second='" + getSecond() + "'" +
            ", winnerPic='" + getWinnerPic() + "'" +
            ", winnerName='" + getWinnerName() + "'" +
            "}";
    }



}