package site.interview.cars24;

public class ctest5 {
    int getValue(){
        int returnValue = 10;
        try{
            String[] Languages = {"Java","Ruby"};
            System.out.println(Languages[5]);
        }
        catch(Exception e){
            System.out.println("Catch Block : "  + returnValue);
            return returnValue;
        }
        finally {
            returnValue += 10;
            System.out.println("Finalyy bolck: " + returnValue);
        }
        return returnValue;
    }
    public static void main(String[] args) {
        ctest5 ctest5 = new ctest5();
        System.out.println("Main : " + ctest5.getValue());
    }
}
