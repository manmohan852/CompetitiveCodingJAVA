public class inputCheck {
    public static void main(String[] args) {
        String str = "1,2,3,4,5,6";
        String[] arr = str.split(",");
        for(int i = 0; i < arr.length; i++){
            System.out.print(" " + arr[i]);
        }

    }
}
