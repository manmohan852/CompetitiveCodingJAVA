import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class  TheBlacklist {

    public static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
        boolean compareTo(Pair p){
            if(this.x  != p.x) return false;
            if(this.x== p.x){
                if(this.y != p.y) return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static int n,m,ret;
    static Pair source;
    static Pair target;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static List<Pair> dads;
    static List<Pair> walked;
    static List<String> v;

    // Complete the countLuck function below.
    static String countLuck(String[] matrix, int k) {
        v = new ArrayList();
        dads = new ArrayList();
        walked = new ArrayList();
        for(int i=0;i<n;i++){
            v.add(matrix[i]);
            for(int j=0;j<m;j++){
                if(v.get(i).charAt(j)=='M'){
                    source = new Pair(i,j);
                    String s = v.get(i);
                    StringBuilder myName = new StringBuilder(s);
                    myName.setCharAt(j, '.');
                    v.set(i,myName.toString());
                }
                if(v.get(i).charAt(j)=='*'){
                    target = new Pair(i,j);
                    String s = v.get(i);
                    StringBuilder myName = new StringBuilder(s);
                    myName.setCharAt(j, '.');
                    v.set(i,myName.toString());
                }
            }
        }
        ret = 0;
        dfs(new Pair(-1,-1),source);
        System.out.println("ret" + ret);
        if(ret == k){
            return "Impressed";
        }
        return "Oops!";
    }

    public static void dfs(Pair dad,Pair source){
        if(target.compareTo(source)){
            for(int i=0;i<walked.size();i++){
                int count = 0;
                for(int j=0;j<4;j++){
                    int mx = walked.get(i).x + dx[j];
                    int my = walked.get(i).y + dy[j];
                    if(mx >=0 && mx < n && my >= 0 && my < m
                            && v.get(mx).charAt(my) == '.' && !new Pair(mx,my).compareTo(dads.get(i)))
                        count++;
                }
                if(count >=2){
                    System.out.println(walked.get(i));
                    System.out.println(count);
                    ret++;
                }
            }
            return;
        }else{
            walked.add(source);
            dads.add(dad);
            for(int i=0;i<4;i++){
                Pair u = new Pair(source.x+dx[i],source.y+dy[i]);
                if(u.x >=0 && u.x < n && u.y >=0  && u.y < m
                        && v.get(u.x).charAt(u.y) == '.' && !u.compareTo(dad)){
                    dfs(source,u);
                    int len = walked.size();
                    walked = walked.subList(0,len-1);
                    int len2 = dads.size();
                    dads = dads.subList(0,len2-1);
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        n = 4;
        m = 11;
        String[] matrix = new String[n];
       int  k = 3;
       matrix[0] = ".X.X......X";
       matrix[1] = ".X*.X.XXX.X";
       matrix[2] = ".XX.X.XM...";
       matrix[3] = "......XXXX.";
       String result = countLuck(matrix,k);

    }

    public static void main2(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            n = Integer.parseInt(nm[0]);

            m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
