package site.byteToByte;

public class MergeArrays {
    public static int[] mergeArrays(int[] a, int[] b, int aLength, int bLength) {
        int[] mArr = new int[aLength+bLength];
        for(int i=0;i<aLength;i++){
            mArr[i] = a[i];
        }
        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        int mergeIndex = aLength + bLength - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            if (a[aIndex] > b[bIndex]) {
                mArr[mergeIndex] = a[aIndex];
                aIndex--;
            } else {
                mArr[mergeIndex] = b[bIndex];
                bIndex--;
            }

            mergeIndex--;
        }

        while (bIndex >= 0) {
            mArr[mergeIndex] = b[bIndex];
            bIndex--;
            mergeIndex--;
        }
        return mArr;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 9, 14, 543};
        int[] b = {0, 53, 103, 125, 1000, 1200};
        int [] c = mergeArrays(a,b,6,6);
        for(int i=0;i<10;i++){
            System.out.println(c[i]);
        }
        System.out.println("Hello world!");
    }
}
