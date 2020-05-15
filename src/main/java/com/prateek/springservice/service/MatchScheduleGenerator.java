package com.prateek.springservice.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import antlr.collections.impl.BitSet;

import java.util.List;

public class MatchScheduleGenerator {

    public static void main(String ar[]) {
        
        Map<String, Integer> mapOfUserAndKeys = new HashMap<>();
        mapOfUserAndKeys.put("Aditya", 0);
        mapOfUserAndKeys.put("Nishant", 1);
        mapOfUserAndKeys.put("Arpit", 2);
        mapOfUserAndKeys.put("Meenakshi", 3);
        mapOfUserAndKeys.put("Prateek", 4);
        mapOfUserAndKeys.put("Hrishi", 5);
        mapOfUserAndKeys.put("Sonal", 6);
        mapOfUserAndKeys.put("Shubham", 7);
        mapOfUserAndKeys.put("Anita", 8);
        mapOfUserAndKeys.put("Pranjal", 9);

        
        Map<String, Integer> mapOfUserAndMatchCount = new HashMap<>();
        mapOfUserAndMatchCount.put("Aditya", 0);
        mapOfUserAndMatchCount.put("Nishant", 0);
        mapOfUserAndMatchCount.put("Arpit", 0);
        mapOfUserAndMatchCount.put("Meenakshi", 0);
        mapOfUserAndMatchCount.put("Prateek", 0);
        mapOfUserAndMatchCount.put("Hrishi", 0);
        mapOfUserAndMatchCount.put("Sonal", 0);
        mapOfUserAndMatchCount.put("Shubham", 0);
        mapOfUserAndMatchCount.put("Anita", 0);
        mapOfUserAndMatchCount.put("Pranjal", 0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 5, 16);
        
        Date date = new Date();
        date.setHours(14);
        date.setMinutes(0);
        date.setSeconds(0);
        calendar.setTime(date);


        List<List<String>> matches = getMatches(mapOfUserAndKeys,mapOfUserAndMatchCount);
        for(List<String> list: matches) {
            Map<String,Object> map = new HashMap<>();
            map.put("user1", list.get(0));
            map.put("user2", list.get(1));
            map.put("user3", list.get(2));
            map.put("user4", list.get(3));
            map.put("version", 2);
        }
       
    }

    private static List<List<String>> getMatches(Map<String, Integer> mapOfUserAndKeys,
        Map<String, Integer> mapOfUserAndMatchCount) {

            List<List<String>> matches = new ArrayList<>();
            int count = 0;
        while (true) {
            Map<String, Integer> sortedMap = sortByValue(mapOfUserAndMatchCount);
            int c = 0;
            String player1 = null;
            String player2 = null;
            String player3 = null;
            String player4 = null;

            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                c++;
                if (c == 1) {
                    player1 = entry.getKey();
                } else if (c == 2) {
                    player2 = entry.getKey();
                } else if (c == 3) {
                    player3 = entry.getKey();
                } else if (c == 4) {
                    player4 = entry.getKey();
                }
                if (c > 4) {
                    break;
                }
            }
            int count1 = mapOfUserAndMatchCount.get(player1);
            int count2 = mapOfUserAndMatchCount.get(player2);
            int count3 = mapOfUserAndMatchCount.get(player3);
            int count4 = mapOfUserAndMatchCount.get(player4);

           

            mapOfUserAndMatchCount.put(player1, count1 + 1);
            mapOfUserAndMatchCount.put(player2, count2 + 1);
            mapOfUserAndMatchCount.put(player3, count3 + 1);
            mapOfUserAndMatchCount.put(player4, count4 + 1);

            System.out.println(player1);
            System.out.println(player2);
            System.out.println(player3);
            System.out.println(player4);

            matches.add(Arrays.asList(player1, player2, player3, player4));
            System.out.println("\n");
            count++;
            if (count > 19) {
                for (Map.Entry<String, Integer> map : mapOfUserAndMatchCount.entrySet()) {
                    System.out.println(map.getKey() + " - " + map.getValue());
                }
                break;
            }
        }
        return matches;
    }

    private static List<Integer> getUniqueUserIds() {
        List<Integer> ids = new ArrayList<>();
        java.util.BitSet bitset = new java.util.BitSet();
        int count = 0;
        while (true) {
            int number = getRandomNumberInRange(0, 8);
            if (bitset.get(number)) {
                continue;
            }
            bitset.set(number);
            ids.add(number);
            count++;
            if (count >= 4) {
                break;
            }
        }
        return ids;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        int next = r.nextInt((max - min) + 1) + min;
        return Math.abs(next - 5);
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        LinkedHashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}