package site.ibit.Strings;

import java.lang.reflect.Constructor;

public class CompareVersion {

    public static int compareVersion(String A, String B) {
        String[] a = A.split("\\.");
        String[] b = B.split("\\.");
        int m = a.length;
        int n = b.length;
        int minLen = m > n ? n : m;
        System.out.println(minLen);
        for(int i=0;i<minLen;i++){
            int x = Integer.valueOf(a[i]);
            int y = Integer.valueOf(b[i]);
            if(x>y) return 1;
            else if(x<y)return -1;
        }
        if(m!=n){
            if(m > n ) return m;
            else return n;
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersion("01","1");
    }
}

