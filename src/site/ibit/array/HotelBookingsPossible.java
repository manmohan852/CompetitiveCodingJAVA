package site.ibit.array;

import site.leetcode.MeetingRooms2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.interviewbit.com/problems/hotel-bookings-possible/
public class HotelBookingsPossible {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int roomsRequired = 0, i = 0, j = 0;
        while (i < arrive.size() && j < arrive.size() && roomsRequired <= K) {
            if (arrive.get(i) < depart.get(j)) {
                i++;
                roomsRequired++;
            } else {
                j++;
                roomsRequired--;
            }
        }
        if (roomsRequired <= K) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hotel2(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        if (arrive == null || depart == null)
            return false;
        Collections.sort(arrive);
        Collections.sort(depart);
        for (int i = 0; i < arrive.size(); i++) {
            if (arrive.get(i) >= depart.get(0))
                depart.remove(0);
        }
        return depart.size() <= K ? true : false;
    }

    public boolean hotel3(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int n = arrive.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = arrive.get(i);
            end[i] = depart.get(i);
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0, res = 0;
        while (i < n) {
            if (start[i] < end[j]) i++;
            else if (start[i] > end[j]) j++;
            else {
                i++;
                j++;
            }
            res = Math.max(res, i - j);
        }
        return res < K ? true : false;
    }


}
