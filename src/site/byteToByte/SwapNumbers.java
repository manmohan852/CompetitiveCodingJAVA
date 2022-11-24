package site.byteToByte;

public class SwapNumbers {

    public void swap(int x, int y) {
        x = x + y;
        y = x - y;
        x = x - y;
    }

    public void swap2(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }
}
