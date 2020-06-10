package site.gfg.matrix;
//https://www.geeksforgeeks.org/minimum-initial-energy-required-to-cross-street/
//Time Complexity : O(n)
public class MiminumInitailEnergyToCrossStreet {
    static int minInitialEnergy(int arr[], int n) {
        int initMinEnergy = 0;
        int currEnergy = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            currEnergy += arr[i];
            if (currEnergy <= 0) {
                initMinEnergy += Math.abs(currEnergy) + 1;
                currEnergy = 1;
                flag = true;
            }
        }
        return (flag == false) ? 1 : initMinEnergy;
    }

    public static void main(String[] args) {
        int arr[] = {4, -10, 4, 4, 4};
        int n = arr.length;
        System.out.print(minInitialEnergy(arr, n));
    }
}

