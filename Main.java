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
                System.out.println("Notasi infix valid.");
            } else {
                System.out.println("Notasi infix TIDAK valid.");
            }
        }
    }
}
