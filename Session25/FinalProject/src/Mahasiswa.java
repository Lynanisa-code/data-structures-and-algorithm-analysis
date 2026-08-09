/**
 * Group-5 (PVCA - LAB) 
 * Members 
 *  1. Ahmad Andi Nugroho – 2902792355 
 *  2. Lynatu Khoirinnisa – 2902785980 
 *  3. Naura Zulwinda Putri – 2902783602 
 *  4. Indah Tri Praesti – 2902795395 
 *
 * Class Mahasiswa
 * ----------------
 * Digunakan sebagai objek data yang akan disimpan
 * di dalam Hash Table maupun BST.
 */

public class Mahasiswa {

    // ===== Atribut =====
    private String nim;
    private String nama;
    private String jurusan;
    private double ipk;

    // ===== Constructor =====
    public Mahasiswa(String nim, String nama, String jurusan, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // ===== Getter =====
    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public double getIpk() {
        return ipk;
    }

    // ===== Setter =====
    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "NIM       : " + nim + "\n" +
               "Nama      : " + nama + "\n" +
               "Jurusan   : " + jurusan + "\n" +
               "IPK       : " + ipk + "\n" +
               "-----------------------------";
    }

    // ===== Contoh pengujian mandiri (opsional) =====
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("2201001", "Andi Saputra", "Teknik Informatika", 3.75);
        Mahasiswa m2 = new Mahasiswa("2201002", "Siti Aminah", "Sistem Informasi", 3.90);

        System.out.println(m1);
        System.out.println(m2);

        // Contoh penggunaan setter
        m1.setIpk(3.85);
        System.out.println("Setelah update IPK:");
        System.out.println(m1);
    }
}
