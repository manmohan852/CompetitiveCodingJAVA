package site.gfg.bits;

//https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/
public class GenerateAllPossibleBinaryStringsWithoutConseqtiveOnes {
    static void generateAllStrings(int K) {
        if (K <= 0)
            return;
        char str[] = new char[K];
        str[0] = '0';
        generateAllStringsUtil(K, str, 1);
        str[0] = '1';
        generateAllStringsUtil(K, str, 1);
    }

    static void generateAllStringsUtil(int K, char str[], int n) {
        if (n == K) {
            System.out.println(str);
            return;
        }
        if (str[n - 1] == '1') {
            str[n] = '0';
            generateAllStringsUtil(K, str, n + 1);
        }
        if (str[n - 1] == '0') {
            str[n] = '0';
            generateAllStringsUtil(K, str, n + 1);
            str[n] = '1';
            generateAllStringsUtil(K, str, n + 1);
        }
    }

    public static void main(String[] args) {
        int K = 3;
        generateAllStrings(K);
    }
}
