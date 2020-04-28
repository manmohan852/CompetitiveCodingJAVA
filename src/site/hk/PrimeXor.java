package site.hk;
import java.io.*;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrimeXor {

    static boolean prime[];
    static int freq[];
    static List<Integer> v;
    static int[][] mem;
    static int mod = (int) 1e9 + 7;

    public static void sieve() {
        prime = new boolean[9025];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 4; i <= 9000; i += 2) {
            prime[i] = false;
        }
        for (int i = 3; i * i <= 9000; i += 2) {
            if (prime[i] ) {
                for (int j = i * i; j <= 9000; j += 2 * i) {
                    prime[j] = false;
                }
            }
        }
    }

    static long init(int[] arr) {
        sieve();
        freq = new int[5025];
        int len = arr.length;
        Arrays.fill(freq, 0);
        for (int i = 0; i < len; i++) {
            freq[arr[i]] += 1;
        }

        v = new ArrayList<>();
        for (int i = 3500; i <= 4525; i++) {
            if (freq[i] >= 1)
                v.add(i);
        }
        mem = new int[2][8192];
        for (int i = 0; i < 8192; i++) {
            mem[0][i] = 0;
            mem[1][i] = 0;
        }
        mem[0][0] = 1;
        int flag = 1;
        int k = v.size();
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 8192; j++) {
                mem[flag][j] = (mem[flag ^ 1][j] * (1 + (freq[v.get(i - 1)]) / 2)) % mod + (mem[flag ^ 1][j ^ v.get(i - 1)] * (1 + freq[v.get(i - 1)]) / 2) % mod;
                if (mem[flag][j] >= mod) {
                    mem[flag][j] %= mod;
                }
            }
            flag ^= 1;
        }

        int res = 0;
        for (int i = 1; i < 8192; i++) {
            if (prime[i]) {
                res += mem[flag ^ 1][i];
                res %= mod;
            }
        }
        return res;
    }


    // Complete the primeXor function below.
    static long primeXor(int[] a) {
        return init(a);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] a = new int[4];
        a[0] = 3511;
        a[1] = 3511;
        a[2] = 3511;
        a[3] = 3511;

        long result = primeXor(a);
        System.out.println(result);
    }
}
