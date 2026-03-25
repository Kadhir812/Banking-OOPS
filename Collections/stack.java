package Collections;


    
import java.util.*;

public class stack {
    public static void main(String[] args) {

        String exp = "23*54*+9-";
        Stack<Integer> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); 
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        System.out.println("Result: " + stack.pop());
    }
}

