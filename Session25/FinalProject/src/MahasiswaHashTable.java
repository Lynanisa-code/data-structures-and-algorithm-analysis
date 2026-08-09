import java.util.HashMap;
import java.util.Map;

/**
 * Group-5 (PVCA - LAB) 
 * Members 
 *  1. Ahmad Andi Nugroho – 2902792355 
 *  2. Lynatu Khoirinnisa – 2902785980 
 *  3. Naura Zulwinda Putri – 2902783602 
 *  4. Indah Tri Praesti – 2902795395 
 *
 * Class MahasiswaHashTable
 * ------------------------
 * Menggunakan HashMap<String, Mahasiswa> sebagai penyimpanan utama.
 */
public class MahasiswaHashTable {

    // HashMap sebagai penyimpanan utama (Key: NIM, Value: Objektif Mahasiswa)
    private HashMap<String, Mahasiswa> dataMahasiswa;

    // Constructor
    public MahasiswaHashTable() {
        dataMahasiswa = new HashMap<>();
    }

    /**
     * Menambahkan data mahasiswa ke dalam Hash Table.
     * Jika NIM sudah ada, data akan diperbarui.
     */
    public void tambahMahasiswa(Mahasiswa m) {
        if (m == null || m.getNim() == null) {
            System.out.println("Gagal menambahkan: Data mahasiswa atau NIM tidak valid.");
            return;
        }
        dataMahasiswa.put(m.getNim(), m);
        System.out.println("Mahasiswa dengan NIM " + m.getNim() + " berhasil ditambahkan.");
    }

    /**
     * Overload method untuk menambahkan data mahasiswa langsung dengan parameter.
     */
    public void tambahMahasiswa(String nim, String nama, String jurusan, double ipk) {
        Mahasiswa m = new Mahasiswa(nim, nama, jurusan, ipk);
        tambahMahasiswa(m);
    }

    /**
     * Mencari data mahasiswa berdasarkan NIM.
     * @return objek Mahasiswa jika ditemukan, null jika tidak ditemukan.
     */
    public Mahasiswa cariMahasiswa(String nim) {
        if (dataMahasiswa.containsKey(nim)) {
            Mahasiswa m = dataMahasiswa.get(nim);
            System.out.println("\n--- Data Mahasiswa Ditemukan ---");
            System.out.println(m);
            return m;
        } else {
            System.out.println("\nMahasiswa dengan NIM '" + nim + "' tidak ditemukan.");
            return null;
        }
    }

    /**
     * Menghapus data mahasiswa berdasarkan NIM.
     * @return true jika berhasil dihapus, false jika data tidak ditemukan.
     */
    public boolean hapusMahasiswa(String nim) {
        if (dataMahasiswa.containsKey(nim)) {
            dataMahasiswa.remove(nim);
            System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
            return true;
        } else {
            System.out.println("Gagal menghapus: Mahasiswa dengan NIM '" + nim + "' tidak ditemukan.");
            return false;
        }
    }

    /**
     * Menampilkan semua data mahasiswa yang ada di dalam Hash Table.
     */
    public void tampilkanSemua() {
        System.out.println("\n=================================");
        System.out.println("    DAFTAR SELURUH MAHASISWA    ");
        System.out.println("=================================");
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Data mahasiswa masih kosong.");
        } else {
            for (Map.Entry<String, Mahasiswa> entry : dataMahasiswa.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    // ===== Main Method untuk Pengujian =====
    public static void main(String[] args) {
        MahasiswaHashTable hashTable = new MahasiswaHashTable();

        System.out.println("=== 1. UJI COBA TAMBAH MAHASISWA ===");
        hashTable.tambahMahasiswa("2201001", "Andi Saputra", "Teknik Informatika", 3.75);
        hashTable.tambahMahasiswa("2201002", "Siti Aminah", "Sistem Informasi", 3.90);
        hashTable.tambahMahasiswa(new Mahasiswa("2201003", "Budi Santoso", "Teknik Elektro", 3.50));

        System.out.println("\n=== 2. TAMPILKAN SEMUA MAHASISWA ===");
        hashTable.tampilkanSemua();

        System.out.println("\n=== 3. UJI COBA CARI MAHASISWA ===");
        hashTable.cariMahasiswa("2201002");
        hashTable.cariMahasiswa("9999999"); // NIM yang tidak ada

        System.out.println("\n=== 4. UJI COBA HAPUS MAHASISWA ===");
        hashTable.hapusMahasiswa("2201001");
        
        System.out.println("\n=== 5. TAMPILKAN SEMUA MAHASISWA (SETELAH DIHAPUS) ===");
        hashTable.tampilkanSemua();
    }
}
