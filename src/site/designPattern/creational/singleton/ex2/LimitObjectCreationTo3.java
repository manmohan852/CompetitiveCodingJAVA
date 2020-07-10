package site.designPattern.creational.singleton.ex2;
//https://stackoverflow.com/questions/2361863/how-do-i-restrict-object-creation-not-more-than-3-in-java-class
public class LimitObjectCreationTo3 {

        public static void main(String[] args) {

            LimitClass obj1 = LimitClass.getLimInstance();
            LimitClass obj2 = LimitClass.getLimInstance();
            LimitClass obj3 = LimitClass.getLimInstance();
            LimitClass obj4 = LimitClass.getLimInstance();
            LimitClass obj5 = LimitClass.getLimInstance();
            LimitClass obj6 = LimitClass.getLimInstance();

            System.out.println(obj1);
            System.out.println(obj2);
            System.out.println(obj3);
            System.out.println(obj4);
            System.out.println(obj5);
            System.out.println(obj6);


            LimitClass2 obj7 = LimitClass2.getLimInstance();
            LimitClass2 obj8 = LimitClass2.getLimInstance();
            LimitClass2 obj9 = LimitClass2.getLimInstance();
            LimitClass2 obj10 = LimitClass2.getLimInstance();
            LimitClass2 obj11 = LimitClass2.getLimInstance();
            LimitClass2 obj12 = LimitClass2.getLimInstance();

            System.out.println(obj7);
            System.out.println(obj8);
            System.out.println(obj9);
            System.out.println(obj10);
            System.out.println(obj11);
            System.out.println(obj12);
        }
}
