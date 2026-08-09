import java.util.Scanner;

/**
 * Group-5 (PVCA - LAB) 
 * Members 
 *  1. Ahmad Andi Nugroho – 2902792355 
 *  2. Lynatu Khoirinnisa – 2902785980 
 *  3. Naura Zulwinda Putri – 2902783602 
 *  4. Indah Tri Praesti – 2902795395 
 *
 * Class Main
 * ----------
 * Menggabungkan Mahasiswa.java, MahasiswaHashTable.java, dan BST.java.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MahasiswaHashTable hashTable = new MahasiswaHashTable();
        BST bst = new BST();
        boolean isRunning = true;

        System.out.println("=================================================");
        System.out.println("   SISTEM MANAJEMEN DATA MAHASISWA TERINTEGRASI  ");

        while (isRunning) {
            System.out.println("=================================================");
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Cari Data Mahasiswa (berdasarkan NIM)");
            System.out.println("3. Hapus Data Mahasiswa");
            System.out.println("4. Tampilkan Semua Data (Hash Table - Tidak Terurut)");
            System.out.println("5. Tampilkan Semua Data (BST - Terurut Inorder)");
            System.out.println("6. Generate 15 Data Dummy (Untuk Pengujian)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-6): ");
            
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM     : ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama    : ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jurusan : ");
                    String jurusan = scanner.nextLine();
                    System.out.print("Masukkan IPK     : ");
                    double ipk;
                    try {
                        ipk = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("IPK tidak valid. Gagal menambahkan data.");
                        break;
                    }

                    Mahasiswa mhsBaru = new Mahasiswa(nim, nama, jurusan, ipk);
                    
                    // Simpan ke Hash Table dan BST secara bersamaan
                    hashTable.tambahMahasiswa(mhsBaru);
                    bst.insert(mhsBaru);
                    System.out.println("Data berhasil diintegrasikan ke Hash Table dan BST.");
                    break;

                case 2:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String searchNim = scanner.nextLine();
                    System.out.println("\n--- Hasil Pencarian via Hash Table ---");
                    hashTable.cariMahasiswa(searchNim);
                    
                    System.out.println("\n--- Hasil Pencarian via BST ---");
                    bst.search(searchNim);
                    break;

                case 3:
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String deleteNim = scanner.nextLine();
                    // Menghapus dari Hash Table
                    hashTable.hapusMahasiswa(deleteNim);
                    // Menghapus dari BST
                    bst.delete(deleteNim);
                    break;

                case 4:
                    hashTable.tampilkanSemua();
                    break;

                case 5:
                    bst.inorder();
                    break;

                case 6:
                    generateDummyData(hashTable, bst);
                    break;

                case 0:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia. Silakan coba lagi.");
            }
        }
        scanner.close();
    }

    /**
     * Method bantuan untuk mengisi 15 data pengujian secara otomatis.
     */
    private static void generateDummyData(MahasiswaHashTable ht, BST bst) {
        Mahasiswa[] dummies = {
            new Mahasiswa("2501015", "Budi Mulyana", "Teknik Informatika", 3.85),
            new Mahasiswa("2501003", "Siti Aisyah", "Sistem Informasi", 3.92),
            new Mahasiswa("2501009", "Agus Supriyadi", "Teknik Informatika", 3.65),
            new Mahasiswa("2501001", "Diana Lestari", "Manajemen Informatika", 3.70),
            new Mahasiswa("2501012", "Eko Prasetyo", "Teknik Komputer", 3.45),
            new Mahasiswa("2501006", "Fina Rahmawati", "Sistem Informasi", 3.88),
            new Mahasiswa("2501004", "Galih Purnama", "Teknik Informatika", 3.55),
            new Mahasiswa("2501011", "Hana Pertiwi", "Sains Data", 3.95),
            new Mahasiswa("2501008", "Iqbal Ramadhan", "Manajemen Informatika", 3.60),
            new Mahasiswa("2501002", "Joko Widodo", "Teknik Elektro", 3.50),
            new Mahasiswa("2501014", "Kartika Putri", "Sistem Informasi", 3.75),
            new Mahasiswa("2501005", "Lukman Hakim", "Teknik Informatika", 3.80),
            new Mahasiswa("2501010", "Mega Utami", "Sains Data", 3.90),
            new Mahasiswa("2501007", "Nadia Vega", "Teknik Komputer", 3.68),
            new Mahasiswa("2501013", "Oky Saputra", "Manajemen Informatika", 3.58)
        };

        for (Mahasiswa m : dummies) {
            ht.tambahMahasiswa(m);
            bst.insert(m);
        }
        System.out.println("\n15 Data dummy berhasil di-generate dan dimasukkan ke Hash Table & BST.");
    }
}