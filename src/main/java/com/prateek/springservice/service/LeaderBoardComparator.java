package com.prateek.springservice.service;

import java.util.Comparator;

import com.prateek.springservice.dto.LeaderBoardDTO;

public class LeaderBoardComparator implements Comparator<LeaderBoardDTO> {

    @Override
    public int compare(LeaderBoardDTO o1, LeaderBoardDTO o2) {
        if( o2.getPoints() == o1.getPoints()) {
            if(o2.getWon() == o1.getWon()) {
                if(o2.getLost() == o1.getLost()) {
                  return o1.getName().compareTo(o2.getName());  
                } else {
                    return o1.getLost() - o2.getLost();
                }
            } else {
                return o2.getWon() - o1.getWon();
            }
        } else {
            return o2.getPoints() - o1.getPoints();
        }
    }

}