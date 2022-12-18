import java.util.Stack;

class inputCheck{
    public static void main(String[] args) {
        String s = "(){}[)]";
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        if(stack.pop() != 'a') {
            System.out.print("dfsdf");
        }
        System.out.println(stack.pop());
        return ;

    }
    }
}