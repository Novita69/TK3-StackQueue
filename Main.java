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

                String prefix = Axel_InfixtoPrefix.toPrefix(input);
                System.out.println("Prefix: " + prefix);
            } else {
                System.out.println("Notasi infix TIDAK valid.");
            }
        }
    }
}
