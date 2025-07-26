import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan notasi infix (ketik 'exit' untuk keluar): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if (Novita_ValidasiInfix.isValidInfix(input)) {
                System.out.println("Notasi infix valid. " + input);
                
                String postfix = Ratson_InfixtoPostfix.toPostfix(input);
                System.out.println("Postfix: " + postfix);
                double hasilPostfix = Ratson_EvaluasiPostfix.evaluatePostfix(postfix);
                System.out.println("Hasil Postfix: " + hasilPostfix);

                String prefix = Axel_InfixtoPrefix.toPrefix(input);
                System.out.println("Prefix: " + prefix);
                double hasilPrefix = Axel_EvaluasiPrefix.evaluatePrefix(prefix);
                System.out.println("Hasil Prefix: " + hasilPrefix);
            } else {
                System.out.println("Notasi infix TIDAK valid.");
            }
        }
    }
}
