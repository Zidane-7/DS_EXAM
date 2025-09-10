import java.util.Scanner;
import java.util.Stack;

public class infixtopostfix {
    public static void main(String[] args) {
        System.out.print("Enter the expression: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        Itp converter = new Itp();
        System.out.println("Postfix expression: " + converter.infix(input));
    }
}

class Itp {
    public String infix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Handle numbers (multi-digit)
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num.append(expression.charAt(i));
                    i++;
                }
                i--;
                result.append(num.toString()).append(" ");
            }
            // Left parenthesis
            else if (c == '(') {
                stack.push(c);
            }
            // Right parenthesis
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop(); // Remove '('
            }
            // Operator
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
}
