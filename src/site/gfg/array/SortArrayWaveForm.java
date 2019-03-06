package site.gfg.array;

import java.util.Arrays;

public class SortArrayWaveForm {

    public static void main(String[] args) {
        int arr[] = {10,90,49,2,1,5,23};
        ArrayClass arrayClass = new ArrayClass();
        arrayClass.arr = arr;
        int n = arr.length;
        //sortInWave(arrayClass,n);
        sortInWave(arrayClass);
        System.out.println();
        for (int i = 0;i<n;i++){
            System.out.print(arrayClass.arr[i]);
            System.out.print("  ");
        }

    }

    static class ArrayClass{
        int[] arr;
    }

    public static void sortInWave(ArrayClass arrayClass, int n){
        Arrays.sort(arrayClass.arr);
        for (int i = 0;i<n;i++){
            System.out.print(arrayClass.arr[i]);
            System.out.print("  ");
        }
        for(int i= 0;i<n-1;i=i+2){
            swapInt(arrayClass,i,i+1);
        }

    }

    public static void sortInWave(ArrayClass arrayClass){
        int n = arrayClass.arr.length;
        for (int i=0;i<n;i+=2){
            if(i>0 && arrayClass.arr[i-1] > arrayClass.arr[i]){
                swapInt(arrayClass,i-1,i);
            }
            if(i<n-1 && arrayClass.arr[i] < arrayClass.arr[i+1]){
                swapInt(arrayClass,i,i+1);
            }
        }
    }

    public static void swapInt(ArrayClass arrayClass, int a ,int b){
        int temp = arrayClass.arr[a];
        arrayClass.arr[a] = arrayClass.arr[b];
        arrayClass.arr[b] = temp;
    }

}
