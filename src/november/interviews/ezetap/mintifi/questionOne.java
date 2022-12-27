package november.interviews.ezetap.mintifi;

public class questionOne {
    public static void main(String[] args) {
        String s = "my name is manmohan";
        String[] str= s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length - 1 ; i >= 0; i--){
            sb.append(str[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());

//        for(int i = str.length - 1; i >= 0; i--){
//            System.out.print(str[i] + " ");
//        }
    }
}
