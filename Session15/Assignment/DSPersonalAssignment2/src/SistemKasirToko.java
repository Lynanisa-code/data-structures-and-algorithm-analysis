import java.util.Scanner;

// Class Node untuk menyimpan data pelanggan (dipakai bersama untuk Stack dan Queue)
class NodePelanggan {
    String nomorAntrian;
    String namaPelanggan;
    double totalBelanja;
    NodePelanggan next;

    public NodePelanggan(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}

// Class Queue untuk Antrian Pelanggan (FIFO)
class Queue {
    NodePelanggan depan, belakang;

    public Queue() {
        this.depan = this.belakang = null;
    }

    // Tambah pelanggan ke antrian (Enqueue)
    public void enqueue(String nomor, String nama, double total) {
        NodePelanggan nodeBaru = new NodePelanggan(nomor, nama, total);
        if (belakang == null) {
            depan = belakang = nodeBaru;
        } else {
            belakang.next = nodeBaru;
            belakang = nodeBaru;
        }
        System.out.println("Data pelanggan ditambahkan ke antrian!\n");
    }

    // Layani pelanggan (Dequeue) --> mengembalikan node yang dilayani
    public NodePelanggan dequeue() {
        if (depan == null) {
            return null;
        }
        NodePelanggan temp = depan;
        depan = depan.next;
        if (depan == null) {
            belakang = null;
        }
        return temp;
    }

    // Tampilkan isi antrian saat ini
    public void display() {
        if (depan == null) {
            System.out.println("Antrian kosong.\n");
            return;
        }
        NodePelanggan temp = depan;
        System.out.println("Antrian Saat Ini:");
        while (temp != null) {
            System.out.println("[" + temp.nomorAntrian + "] " + temp.namaPelanggan + " - Rp" + temp.totalBelanja);
            temp = temp.next;
        }
        System.out.println();
    }
}

// Class Stack untuk Riwayat Transaksi (LIFO)
class Stack {
    NodePelanggan atas;

    public Stack() {
        this.atas = null;
    }

    // Masukkan transaksi ke riwayat (Push)
    public void push(NodePelanggan transaksi) {
        NodePelanggan nodeBaru = new NodePelanggan(transaksi.nomorAntrian, transaksi.namaPelanggan, transaksi.totalBelanja);
        nodeBaru.next = atas;
        atas = nodeBaru;
    }

    // Tampilkan riwayat dari yang paling baru
    public void display() {
        if (atas == null) {
            System.out.println("Belum ada riwayat transaksi.\n");
            return;
        }
        NodePelanggan temp = atas;
        System.out.println("Riwayat Transaksi (Terbaru ke Lama):");
        while (temp != null) {
            System.out.println("Diselesaikan: [" + temp.nomorAntrian + "] " + temp.namaPelanggan + " - Rp" + temp.totalBelanja);
            temp = temp.next;
        }
        System.out.println();
    }
}

// Class Main untuk Sistem Kasir
public class SistemKasirToko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan;

        do {
            System.out.println("=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    String nomor = scanner.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Total Belanja: ");
                    double total = scanner.nextDouble();
                    antrian.enqueue(nomor, nama, total);
                    break;
                case 2:
                    NodePelanggan dilayani = antrian.dequeue();
                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan " + dilayani.nomorAntrian + " (" + dilayani.namaPelanggan + ")");
                        riwayat.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.\n");
                    } else {
                        System.out.println("Tidak ada antrian untuk dilayani.\n");
                    }
                    break;
                case 3:
                    antrian.display();
                    break;
                case 4:
                    riwayat.display();
                    break;
                case 5:
                    System.out.println("Keluar program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.\n");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}