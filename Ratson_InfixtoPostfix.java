import java.util.*;

public class Ratson_InfixtoPostfix {

    public static String toPostfix(String expr) {
        String[] tokens = tokenize(expr);
        StringBuilder output = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                output.append(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && !stack.peek().equals("(") &&
                        precedence(token) <= precedence(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.peek().equals("(")) {
                output.append(stack.pop());
            } else {
                stack.pop();
            }
        }

        return output.toString();
    }

    private static String[] tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (char c : expr.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }
                if (!Character.isWhitespace(c) && "+-*/^()".indexOf(c) != -1) {
                    tokens.add(String.valueOf(c));
                }
            }
        }
        if (number.length() > 0) {
            tokens.add(number.toString());
        }
        return tokens.toArray(new String[0]);
    }

    private static int precedence(String op) {
        return switch (op) {
            case "^" -> 3;
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            default -> 0;
        };
    }

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isOperator(String s) {
        return "+-*/^".contains(s);
    }
}