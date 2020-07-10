package site.leetcode.string;

public class StringToIntegerATOI {

    public int myAtoi2(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        double result = 0;
        boolean isNegative = false;
        int startIndex = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            if (str.charAt(0) == '-') {
                isNegative = true;
            }
            startIndex++;
        }
        for (int i = startIndex; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            int digitValue = str.charAt(i) - '0';
            result = result * 10 + digitValue;
        }
        if (isNegative) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public int myAtoi(String str) {
        int n = str.length();
        //Check if string is empty
        if (n == 0) return 0;
        //Check if string has white spaces
        int i = 0;
        for (; i < n && str.charAt(i) == ' '; i++) ;
        //After encountering the white spaces check if full string is traversed
        if (i == n) return 0;
        //check if the string has positive or negative integers
        int sign = 1;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        //convert the string into long while checking if it is within the range and if it is a digit
        long num = 0;
        while (i < n && num < Integer.MAX_VALUE && Character.isDigit(str.charAt(i))) {
            num = num * 10 + str.charAt(i) - '0';
            i++;
        }
        // If the number is greater than max value check with the sign...If it is negative, return min value and
        // if it is positive return max value
        if (num > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        //for the number within the integer range
        return (int) num * sign;
    }
}
