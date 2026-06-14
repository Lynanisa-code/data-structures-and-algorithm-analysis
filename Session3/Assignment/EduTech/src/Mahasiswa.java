public class Mahasiswa {
	String nama;
	String nim;
	String jurusan;
	//double ipk;
	private double ipk;
	
	public String getNim() {
		return this.nim;
	}
	
	public double getIpk() {
		return this.ipk;
	}
	
	public void setIpk(double ipk) {
		this.ipk = ipk;
	}
	
	public Mahasiswa(String nama, String nim, String jurusan, double ipk ) {
		this.nama = nama;
		this.nim = nim;
		this.jurusan = jurusan;
		this.ipk = ipk;
	}
	
	public void tampilkanInfo() {
		System.out.println("Nama	: " + this.nama);
		System.out.println("NIM	: " + this.nim);
		System.out.println("Jurusan	: " + this.jurusan);
		System.out.printf("IPK	: %.2f\n", this.ipk);
		System.out.println("Status	: " + cekKelulusan(this.ipk));
		System.out.printf("Predikat: %s\n\n", hitungPredikat(this.ipk));
	}
	
	public String cekKelulusan(double ipk) {
		String status;
		
		if(ipk >= 3.00) {
			status = "Lulus";
		} else {
			status = "Belum Lulus";
		}
		
		return status;
	}
	
	public void updateIpk(double ipkBaru) {
		this.ipk = ipkBaru;
		System.out.println("Data berhasil diperbarui!");
	}
	
	public String hitungPredikat(double ipk) {
		String predikat;
		
		if(ipk >= 3.75) {
			predikat = "Dengan Pujian";
		} else if(ipk >= 3.50 && ipk < 3.75) {
			predikat = "Sangat Memuaskan";
		} else if(ipk >= 3.00 && ipk < 3.50) {
			predikat = "Memuaskan";
		} else {
			predikat = "Perlu Perbaikan";
		}
		
		return predikat;
	}
}
