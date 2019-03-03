package site.hk.dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HackerCity {

    /*
     * Complete the hackerrankCity function below.
     */
    static long hackerrankCity(int[] A) {
        long x=0;
        long ans = 0;
        long y = 1;
        long z = 0;
        long P = (int) (Math.pow(10,9) + 7);

        for (int i=0;i<A.length;i++){

            ans=ans*4+ (y*12+8)%P*x%P + (y*12+8)%P*y%P*A[i]+  (y*2+1)%P*(y*2+1)%P*A[i];

            x=  x*4 + (z+A[i]*2)%P*y%P + (z+A[i]*3)%P*y%P*2 + z*2+A[i]*3;
            y= y * 4 + 2;
            z = z * 2 + A[i] * 3;

            ans%=P;
            x%=P;
            y%=P;
            z%=P;
        }


        return ans;

    }

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 2;
        A[1] = 9;
        A[2] = 9;
        A[3] = 7;
        A[4] = 7;
        A[5] = 9;
        System.out.println(hackerrankCity(A));

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int ACount = Integer.parseInt(scanner.nextLine().trim());

        int[] A = new int[ACount];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < ACount; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        long result = hackerrankCity(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
