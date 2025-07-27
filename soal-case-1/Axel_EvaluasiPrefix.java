import java.util.Stack;

public class Axel_EvaluasiPrefix {

    public static double evaluatePrefix(String prefix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = prefix.split("");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "^":
                        stack.push(Math.pow(operand1, operand2));
                        break;
                }
            }
        }

        return stack.pop();
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