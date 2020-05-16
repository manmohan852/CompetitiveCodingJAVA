package site.byteToByte;
//https://www.youtube.com/watch?v=c0OMPDLef08
//https://www.byte-by-byte.com/fizzbuzz/
public class FizzBuzz {

    public void FizzBuzz(int x) {
        for (int i = 1; i <= x; i++) {
            if (i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }

}
