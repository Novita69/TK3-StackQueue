
import java.util.*;

public class Novita_ValidasiInfix {

    private static String[] tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (char c : expr.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }
                if ("+-*/^()".indexOf(c) != -1) {
                    tokens.add(String.valueOf(c));
                }
            }
        }
        if (number.length() > 0) {
            tokens.add(number.toString());
        }
        return tokens.toArray(new String[0]);
    }

    public static boolean isValidInfix(String expr) {
        if (expr == null || expr.isEmpty()) {
            return false;
        }

        String[] tokens = tokenize(expr);
        if (tokens.length == 0) {
            return false;
        }

        int bracketCount = 0;
        boolean expectOperand = true;

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (expectOperand) {
                // token harus angka atau '('
                if (isOperator(token) && !token.equals("-")) {
                    return false;
                }
                if (!isNumber(token) && !token.equals("(") && !token.equals("-")) {
                    return false;
                }
                if (token.equals("(")) {
                    bracketCount++;
                }
                expectOperand = false;
            } else {
                if (isOperator(token)) {
                    expectOperand = true;
                } else if (token.equals(")")) {
                    bracketCount--;
                    if (bracketCount < 0) {
                        return false;
                    }
                } else {
                    return false; // dua angka berturut-turut tanpa operator
                }
            }
        }
        return !expectOperand && bracketCount == 0;
    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan notasi infix (ketik 'exit' untuk keluar): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if (isValidInfix(input)) {
                System.out.println("Notasi infix valid.");
            } else {
                System.out.println("Notasi infix TIDAK valid.");
            }
        }
    }
}
