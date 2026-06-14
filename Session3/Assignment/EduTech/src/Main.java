import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Mahasiswa mahasiswa1 = new Mahasiswa("Andi Pratama", "2440001", "Teknik Informatika", 3.75);
//		Mahasiswa mahasiswa2 = new Mahasiswa("Budi Santoso", "2440002", "Sistem Informasi", 3.40);
//		Mahasiswa mahasiswa3 = new Mahasiswa("Citra Lestari", "2440003", "Teknik Informatika", 3.90);
//		Mahasiswa mahasiswa4 = new Mahasiswa("Joni Suhartono", "2440004", "Teknik Informatika", 3.00);
//		Mahasiswa mahasiswa5 = new Mahasiswa("Bulan Suci", "2440005", "Akuntansi", 3.20);
//		
//		System.out.println("=== Daftar Mahasiswa ===");
//		mahasiswa1.tampilkanInfo();
//		mahasiswa2.tampilkanInfo();
//		mahasiswa3.tampilkanInfo();
//		mahasiswa4.tampilkanInfo();
//		mahasiswa5.tampilkanInfo();
		
		Scanner scanner = new Scanner(System.in);
		
		// Contractor object untuk class Mahasiswa
		Mahasiswa[] mahasiswa = new Mahasiswa[5];
		mahasiswa[0] = new Mahasiswa("Andi Pratama", "2440001", "Teknik Informatika", 3.75);
		mahasiswa[1] = new Mahasiswa("Budi Santoso", "2440002", "Sistem Informasi", 3.40);
		mahasiswa[2] = new Mahasiswa("Citra Lestari", "2440003", "Teknik Informatika", 3.90);
		mahasiswa[3] = new Mahasiswa("Joni Suhartono", "2440004", "Teknik Informatika", 3.00);
		mahasiswa[4] = new Mahasiswa("Bulan Suci", "2440005", "Akuntansi", 3.20);
		
		// Menampilkan daftar mahasiswa
		System.out.println("=== Daftar Mahasiswa ===");
		for(int i=0; i<mahasiswa.length; i++) {
			mahasiswa[i].tampilkanInfo();
		}
		
		// Mengupdate IPK
		System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nim = scanner.next();
        System.out.print("Masukkan IPK Baru: ");
        double newIpk = scanner.nextDouble();
        
        boolean isFound = false;
        for(int i=0; i<mahasiswa.length; i++) {
        	if(nim.equals(mahasiswa[i].getNim())) {
        		mahasiswa[i].updateIpk(newIpk);
        		System.out.println("\n\n=== Daftar Mahasiswa ===");
        		mahasiswa[i].tampilkanInfo();
        		isFound = true;
        		break; // Stop pencarian jika NIM telah ditemukan
        	} 
		}
        
        if(!isFound) {
        	System.out.println("NIM Tidak Ditemukan!");
        }
        
        scanner.close();
	}
}
