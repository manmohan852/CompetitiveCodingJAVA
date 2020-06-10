package site.gfg.dp;

//https://www.geeksforgeeks.org/number-of-handshakes-such-that-a-person-shakes-hands-only-once/
public class TotalNumberOfHandshakes {

    static int handshake(int n) {
        if (n == 0)
            return 0;
        else
            return (n - 1) + handshake(n - 1);
    }

    static int handshake2(int n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.print(handshake(n));
    }
}
