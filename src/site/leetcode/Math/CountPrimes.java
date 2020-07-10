package site.leetcode.Math;
//https://leetcode.com/problems/count-primes/
public class CountPrimes {
    public static int countPrimes(int n) {
        boolean notPrime[] = new boolean[n]; //defult value is false
        for (int i = 2; i * i < n; i++) {
            if (!notPrime[i]) {
                for (int j = i; j * i < n; j++) {
                    notPrime[i * j] = true;  //setting to true i.e not prime as they are multiple of i and j which is not 1 or the number itself
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        countPrimes(35);
    }
}
