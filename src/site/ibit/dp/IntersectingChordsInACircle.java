package site.ibit.dp;

public class IntersectingChordsInACircle {

    public static int chordCnt(int A){
        int[] ways = new int[A+1];
        ways[0] = 1;//ways[0] : no of ways to draw 0 chords
        ways[1] = 1; // ways[1] : no of ways to draw 1 chords : 2 points
        ways[2] = 2; // 2 chords :  4 points
        for(int i =3;i<=A;i++){
            ways[i]=0;
            for(int k=0;k<i;k++) {
                ways[i] =(ways[i] + (ways[k] * ways[i - 1 - k]) %  1000000007) % 1000000007;
            }
        }
        return ways[A]  % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(chordCnt(6000));
    }
}
