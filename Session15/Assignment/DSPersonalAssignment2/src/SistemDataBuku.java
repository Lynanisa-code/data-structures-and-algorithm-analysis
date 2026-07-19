import java.util.Scanner;

// Class Node untuk menyimpan data buku
class NodeBuku {
    String kodeBuku;
    String judul;
    String penulis;
    NodeBuku next;

    public NodeBuku(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}

// Class LinkedList untuk mengelola daftar buku 
class LinkedListBuku {
    NodeBuku head;
    int jumlahBuku;

    public LinkedListBuku() {
        this.head = null;
        this.jumlahBuku = 0;
    }

    // Tambah Buku di akhir daftar (push ke Tail)
    public void tambahBuku(String kodeBuku, String judul, String penulis) {
        NodeBuku nodeBaru = new NodeBuku(kodeBuku, judul, penulis);
        if (head == null) {
            head = nodeBaru;
        } else {
            NodeBuku temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nodeBaru;
        }
        jumlahBuku++;
        System.out.println("Data berhasil ditambahkan!\n");
    }

    // Hapus Buku terakhir (pop dari Tail)
    public void hapusBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.\n");
            return;
        }
        
        if (head.next == null) {
            head = null; 
        } else {
            NodeBuku temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        jumlahBuku--;
        System.out.println("Buku terakhir berhasil dihapus!\n");
    }

    // Cari Buku berdasarkan Kode Buku
    public void cariBuku(String kodeBuku) {
        if (head == null) {
            System.out.println("Buku tidak ditemukan.\n");
            return;
        }
        NodeBuku temp = head;
        boolean ditemukan = false;
        while (temp != null) {
            if (temp.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("Detail Buku:");
                System.out.println("Kode: " + temp.kodeBuku + " | Judul: " + temp.judul + " | Penulis: " + temp.penulis + "\n");
                ditemukan = true;
                break;
            }
            temp = temp.next;
        }
        if (!ditemukan) {
            System.out.println("Buku tidak ditemukan.\n");
        }
    }

    // Tampilkan semua Buku
    public void tampilkanSemuaBuku() {
        if (head == null) {
            System.out.println("Daftar buku kosong.\n");
            return;
        }
        NodeBuku temp = head;
        System.out.println("Daftar Buku:");
        while (temp != null) {
            System.out.println("Kode: " + temp.kodeBuku + " | Judul: " + temp.judul + " | Penulis: " + temp.penulis);
            temp = temp.next;
        }
        System.out.println("Total Buku: " + jumlahBuku + "\n");
    }
}

// Class Main untuk menjalankan program
public class SistemDataBuku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListBuku listBuku = new LinkedListBuku();
        int pilihan;

        do {
            System.out.println("===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    String kodeBuku;
                    while (true) {
                        System.out.print("Masukkan Kode Buku (Maks 5 Karakter): ");
                        kodeBuku = scanner.nextLine();
                        if (kodeBuku.length() <= 5) break;
                        System.out.println("Error: Kode buku maksimal 5 karakter!");
                    }
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();
                    listBuku.tambahBuku(kodeBuku, judul, penulis);
                    break;
                case 2:
                    listBuku.hapusBuku();
                    break;
                case 3:
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    String cariKode = scanner.nextLine();
                    listBuku.cariBuku(cariKode);
                    break;
                case 4:
                    listBuku.tampilkanSemuaBuku();
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!\n");
            }
        } while (pilihan != 5);
        
        scanner.close();
    }
}