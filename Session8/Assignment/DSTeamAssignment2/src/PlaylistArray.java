/**
 * ====================================================================
 * TEAM ASSIGNMENT 2 - COSC6025 Data Structures and Algorithm Analysis
 * Week 4: Arrays and Their Operations in Data Structures
 *
 * Group-5 (LVCA - LEC)
 * Members
 * 1. AHMAD ANDI NUGROHO - 2902792355
 * 2. LYNATU KHOIRINNISA - 2902785980
 * 3. NAURA ZULWINDA PUTRI - 2902783602
 * 4. INDAH TRI PRAESTI - 2902795395
 * 
 * Deskripsi:
 * Program mengembangkan sistem manajemen playlist musik sederhana 
 * yang telah dibuat pada Tugas Kelompok 1. Fokus program adalah 
 * pada operasi array dalam struktur data, yaitu bagaimana data lagu 
 * dikelola, diubah, dicari, dan ditampilkan dengan efisien.
 * ====================================================================
 */

// Import Libraries
import java.util.Scanner; // Library input

// ====================================================================
// MAIN CLASS — PlaylistArray
// Entry point program. Mendemonstrasikan seluruh fitur sistem.
// ====================================================================
public class PlaylistArray {
	
    public static void main(String[] args) {
    	// Inisialisasi object Scanner untuk input User
		Scanner scanner = new Scanner(System.in);
    	
        // Inisialisasi array playlist dengan kapasitas maksimal 10 lagu
        // Array digunakan sebagai struktur data utama untuk menyimpan objek Lagu.
        final int max = 10;
        Lagu[] playlist = new Lagu[max];
        int jumlahLagu   = 0; // Menyimpan jumlah lagu dalam array
        
        // Menambahkan lagu pada object playlist
        jumlahLagu = tambahLagu(playlist, jumlahLagu, new Lagu("Blinding Lights", "The Weekend", 3.20));
        jumlahLagu = tambahLagu(playlist, jumlahLagu, new Lagu("Shape of You", "Ed Sheeran", 3.53));
        jumlahLagu = tambahLagu(playlist, jumlahLagu, new Lagu("Levitating", "Dua Lipa", 3.23));
        jumlahLagu = tambahLagu(playlist, jumlahLagu, new Lagu("Dynamite", "BTS", 3.19));
        jumlahLagu = tambahLagu(playlist, jumlahLagu, new Lagu("Peaches", "Justin Bieber", 3.18));
        jumlahLagu = tambahLagu(playlist, jumlahLagu, new Lagu("Blinding Lights 1: Studio ver", "The Weekend", 3.21));
        jumlahLagu = tambahLagu(playlist, jumlahLagu, new Lagu("Lemon Tang", "Heart2hearts", 3.43));
        jumlahLagu = tambahLagu(playlist, jumlahLagu, new Lagu("Baby Blue", "NCT Wish", 3.15));

        System.out.println("=".repeat(70));
        System.out.println("                   SISTEM MANAJEMEN PLAYLIST MUSIK");
        System.out.println("           Arrays and Their Operations in Data Structures");
        System.out.println("=".repeat(70));

        // --------------------------------------------------------
        // Menampilkan Menu Interaktif
        // --------------------------------------------------------
        int opt;
        do {
        	System.out.println("                     === MENU PLAYLIST MUSIK ===");
        	System.out.println("  1. Tampilkan semua lagu");
        	System.out.println("  2. Tambah lagu baru");
        	System.out.println("  3. Hapus lagu berdasarkan judul");
        	System.out.println("  4. Cari lagu berdasarkan judul");
        	System.out.println("  5. Urutkan berdasarkan durasi");
        	System.out.println("  6. Keluar");
        	
        	System.out.printf("Pilih Menu: ");
        	opt = scanner.nextInt();
        	System.out.println("\n" + "=".repeat(70));
            scanner.nextLine(); // clear the buffer
        	
        	switch (opt) {
            case 1: // Memanggil fungsi menu "Tampilkan semua lagu"
            	tampilkanSemuaLagu(playlist, jumlahLagu);
            	System.out.println("\n" + "=".repeat(70));
                break;
            case 2: // Memanggil fungsi menu "Tambah lagu baru"
            	System.out.print("  Masukkan Judul Lagu    : ");
                String newLagu = scanner.nextLine();
                System.out.print("  Masukkan Nama Artis    : ");
                String newArtis = scanner.nextLine();
                System.out.print("  Masukkan Durasi (menit): ");
                double newDurasi = scanner.nextDouble();
                
                int tempJumlah = jumlahLagu;
                jumlahLagu = tambahLagu(playlist, jumlahLagu, new Lagu(newLagu, newArtis, newDurasi));
                if (jumlahLagu == tempJumlah + 1) {
                	System.out.println("  [+] Lagu \"" + newLagu + "\" berhasil ditambahkan.");
                }
            	System.out.println("\n" + "=".repeat(70));
                break;
            case 3: // Memanggil fungsi menu "Hapus lagu berdasarkan judul"
            	System.out.print("  Masukkan Judul Lagu    : ");
                String hapusLagu = scanner.nextLine();
                
                DeleteResult result = hapusLagu(playlist, jumlahLagu, hapusLagu);

                // Replace data baru
                playlist = result.updatedPlaylist();
                jumlahLagu = result.updatedJumlah();
            	System.out.println("\n" + "=".repeat(70));
                break;
            case 4: // Memanggil fungsi menu "Cari lagu berdasarkan judul"
            	System.out.print("  Masukkan Judul Lagu    : ");
                String searchLagu = scanner.nextLine();
                
                cariLagu(playlist, jumlahLagu, searchLagu);
            	System.out.println("\n" + "=".repeat(70));
                break;
            case 5: // Memanggil fungsi menu "Urutkan berdasarkan durasi"
            	if (jumlahLagu > 0) {
            	    bubbleSortByDurasi(playlist, jumlahLagu);
            	    tampilkanSemuaLagu(playlist, jumlahLagu);
            	} else {
            	    System.out.println("  [!] Tidak ada lagu untuk diurutkan.");
            	}
            	
            	System.out.println("\n" + "=".repeat(70));
                break;
            case 6: // Keluar dari program
            	System.out.println("Program selesai. Terima kasih!");
                System.out.println("=".repeat(70));
                break;
            default: // Tentukan default aksi
            	System.out.println("  [!] Menu tidak valid");
            	System.out.println("\n" + "=".repeat(70));
                break;
        	}
        } while (opt != 6);

        scanner.close();
    }
    
    public static void tampilkanSemuaLagu(Lagu[] playlist, int jumlahLagu) {
        if (jumlahLagu == 0) {
            System.out.println("  [!] Playlist masih kosong.");
            return;
        }
        System.out.printf("  %-30s | %-20s | %s%n", "JUDUL", "ARTIS", "DURASI");
        System.out.println("  " + "-".repeat(65));
        for (int i = 0; i < jumlahLagu; i++) {
            playlist[i].tampilkanInfo();
        }
    }
    
    public static int tambahLagu(Lagu[] playlist, int jumlahLagu, Lagu laguBaru) {
        if (jumlahLagu >= playlist.length) {
            System.out.println("  [!] Playlist penuh! Kapasitas maksimal " + playlist.length + " lagu.");
            return jumlahLagu;
        }
        playlist[jumlahLagu] = laguBaru;
        jumlahLagu++;
        return jumlahLagu;
    }
    
    public record DeleteResult(Lagu[] updatedPlaylist, int updatedJumlah) {}
    
    public static DeleteResult hapusLagu(Lagu[] playlist, int jumlahLagu, String keyword) {
        // Posisi index array yang akan dihapus
    	int pos = -1;
        
    	boolean found = false;
        for (int i = 0; i < jumlahLagu; i++) {
            // Pencarian case-insensitive menggunakan toLowerCase()
            if (playlist[i].getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                // Simpan index array yang akan dihapus
            	pos = i;
                found = true;
                break;
            }
        }
        
        if (found) {
        	// Array hasil setelah penghapusan 
            Lagu[] hasil = new Lagu[playlist.length];
            
        	// Menyalin elemen-elemen sebelum posisi penghapusan
            for (int i = 0; i < pos; i++) { 
                hasil[i] = playlist[i]; 
            } 
            
            // Menyalin elemen-elemen setelah posisi penghapusan 
            for (int i = pos; i < playlist.length - 1; i++) { 
                hasil[i] = playlist[i + 1]; 
            } 
            
            // Return data playlist dengan hasil setelah penghapusan
            System.out.println("  Lagu \"" + keyword + "\" berhasil dihapus");
            return new DeleteResult(hasil, jumlahLagu - 1);
        } else {
            System.out.println("  [!] Data Lagu dengan judul \"" + keyword + "\" tidak ditemukan.");
            return new DeleteResult(playlist, jumlahLagu); // Return original data
        }
    }
    
    // Pencarian dengan Linear Search, yaitu mencari elemen dengan menelusuri array satu per satu
    public static void cariLagu(Lagu[] playlist, int jumlahLagu, String keyword) {
        boolean found = false;
        System.out.println("  Hasil pencarian untuk: \"" + keyword + "\"");
        System.out.printf("  %-30s | %-20s | %s%n", "JUDUL", "ARTIS", "DURASI");
        System.out.println("  " + "-".repeat(65));
        for (int i = 0; i < jumlahLagu; i++) {
            // Pencarian case-insensitive menggunakan toLowerCase()
            if (playlist[i].getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                playlist[i].tampilkanInfo();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("  [!] Lagu dengan judul \"" + keyword + "\" tidak ditemukan.");
        }
    }
    
    public static void bubbleSortByDurasi(Lagu[] playlist, int jumlahLagu) {
        boolean swapped;
        for (int i = 0; i < jumlahLagu - 1; i++) {
            swapped = false;
            for (int j = 0; j < jumlahLagu - i - 1; j++) {
                // Bandingkan durasi lagu
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    // Swap object didalam array
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                    swapped = true;
                }
            }
            // Jika tidak ada penukaran elemen, maka array sudah di sorting
            if (!swapped) break;
        }
    }
}


// ====================================================================
// CLASS LAGU
// Merepresentasikan setiap lagu dalam playlist dengan atribut
// judul, artis, dan durasi (dalam menit).
// ====================================================================
class Lagu {
    // Enkapsulasi: atribut dibuat private agar tidak bisa diakses langsung dari luar
    private String judul;
    private String artis;
    private double durasi;

    // Constructor: menginisialisasi objek Lagu dengan nilai awal.
    // Dipanggil saat membuat objek Lagu baru.
    public Lagu(String judul, String artis, double durasi) {
        this.judul  = judul;
        this.artis  = artis;
        this.durasi = durasi;
    }

    // --- Getter ---
    // Mengembalikan judul lagu
    public String getJudul() {
    	return judul;
    }

    // Mengembalikan nama artis
    public String getArtis() {
    	return artis; 
    }

    // Mengembalikan durasi lagu (dalam menit)
    public double getDurasi() { 
    	return durasi; 
    }

    // --- Setter ---
    // Mengubah judul lagu
    public void setJudul(String judul) { 
    	this.judul  = judul; 
    }

    // Mengubah nama artis
    public void setArtis(String artis) { 
    	this.artis  = artis; 
    }

    // Mengubah durasi lagu
    public void setDurasi(double durasi) { 
    	this.durasi = durasi; 
    }

    // Menampilkan informasi lengkap tentang sebuah lagu.
    // Format: Judul | Artis | Durasi
    public void tampilkanInfo() {
        System.out.printf("  %-30s | %-20s | %.2f menit%n", judul, artis, durasi);
    }
}