package com.prateek.springservice.service;

import java.util.Comparator;

import com.prateek.springservice.dto.LeaderBoardDTO;

public class LeaderBoardComparator implements Comparator<LeaderBoardDTO> {

    @Override
    public int compare(LeaderBoardDTO o1, LeaderBoardDTO o2) {
        return o2.getPoints()-o1.getPoints();
    }

}