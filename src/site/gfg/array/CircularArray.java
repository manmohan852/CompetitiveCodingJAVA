package site.gfg.array;

//https://www.geeksforgeeks.org/circular-array/
public class CircularArray {

//    O(n) time and O(n) extra space.
    public static void print1(char a[], int n, int index) {
        char[] b = new char[(2 * n)];
        for (int i = 0; i < n; i++)
            b[i] = b[n + i] = a[i];
        for (int i = index; i < n + index; i++)
            System.out.print(b[i] + " ");
    }

    //O(n) time and O(1) extra space.
    public static void print2(char a[], int n, int index){
        for (int i = index; i < n + index; i++)
            System.out.print(a[(i % n)] + " ");
    }

    public static void main(String argc[]) {
        char[] a = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        int n = 6;
        int index = 3;
        print2(a, n, index);
    }
}

