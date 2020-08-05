package site.leetcode.Math;


public class AngleBetweenHandsOfAClock {

    public static double angleClock(double hour, double minutes) {
        double hourDegrees = 0;
        hourDegrees += (hour % 12) * 30;
        hourDegrees += minutes / 2;
        double minDegrees = 0;
        minDegrees += (minutes % 60) * 6;
        double res = Math.abs(hourDegrees - minDegrees);
        if(res > 180){
            return 360- res;
        }
        return res;
    }

    public static void main(String[] args) {
        double hour = 1;
        double min = 57;
        angleClock(hour, min);
    }


}
