import java.util.Scanner;

public class SimpleQueue {
    // Deklarasi variabel queue
    private static final int MAX = 100;
    private static String[] queue = new String[MAX];
    private static int front = 0;
    private static int rear = 0;

    // Method untuk menambahkan item ke antrian
    public static void enqueue(String item) {
        if (rear == MAX) {
            System.out.println("Antrian penuh.");
            return;
        }
        queue[rear++] = item;
        System.out.println("Item berhasil ditambahkan: " + item);
    }

    // Method untuk menghapus item dari antrian
    public static void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Item yang dihapus: " + queue[front]);
        front++;
    }

    // Method untuk menghitung jumlah item dalam antrian
    public static int countItems() {
        return rear - front;
    }

    // Method untuk mengecek apakah antrian kosong
    public static boolean isEmpty() {
        return front == rear;
    }

    // Method untuk menampilkan seluruh item dalam antrian
    public static void displayQueue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Isi antrian:");
        for (int i = front; i < rear; i++) {
            System.out.println((i - front + 1) + ". " + queue[i]);
        }
    }

    // Program utama
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        // Loop utama untuk interaksi dengan pengguna
        do {
            System.out.println("\n==== PROGRAM ANTRIAN SEDERHANA ====");
            System.out.println("1. Tambah item ke antrian");
            System.out.println("2. Hapus item dari antrian");
            System.out.println("3. Hitung jumlah item");
            System.out.println("4. Tampilkan isi antrian");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan item yang ingin ditambahkan: ");
                    String item = scanner.nextLine();
                    enqueue(item);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    System.out.println("Jumlah item dalam antrian: " + countItems());
                    break;
                case 4:
                    displayQueue();
                    break;
                case 5:
                    System.out.println("Program selesai. Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
