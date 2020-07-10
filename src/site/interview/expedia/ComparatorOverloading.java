package site.interview.expedia;

public class ComparatorOverloading {

    public boolean compare(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (m == n) {
            for (int i = 0; i < m; i++) {
                if(a[i] != b[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean compare(String a, String b) {
        if (a.equals(b)) return true;
        return false;
    }

    public boolean compare(int a, int b) {
        if (a == b) return true;
        return false;
    }

    public static void main(String[] args)  {
        ComparatorOverloading comparatorOverloading = new ComparatorOverloading();
        comparatorOverloading.compare(5,6);
        comparatorOverloading.compare(7,7);
        comparatorOverloading.compare("wert","wert");
        comparatorOverloading.compare("wert","wurt");
        int[] a = {1,2,3,4,9};
        int[] b = {1,2,3,4,9};
        int[] c = {1,2,3,8,80};
        comparatorOverloading.compare(a,b);
        comparatorOverloading.compare(a,c);
    }

}
