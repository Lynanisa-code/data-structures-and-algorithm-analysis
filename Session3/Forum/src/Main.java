public class Main {
    public static void main(String[] args) {
    		//--- Polymorphism
        Kalkulator calc = new Kalkulator();
        System.out.println("Hasil 2 angka: " + calc.tambah(7, 5));
        System.out.println("Hasil 3 angka: " + calc.tambah(3, 5, 9));

        Hewan hewan = new Hewan();
        hewan.suara(); // Call method Hewan
        
        Hewan peliharaan = new Kucing();
        peliharaan.suara(); // Call method Kucing, bukan Hewan
        
        // Separator
        System.out.println("-------------------------------------");
        
        //--- Encapsulation
        RekeningBank akun = new RekeningBank(100000);
        
        // akun.saldo = 50000; --> tidak bisa diakses karena private
        
        akun.setor(50000); // Menggunakan method public
        System.out.println("Saldo saat ini: Rp" + akun.getSaldo()); // Memanggil getter
        
        // Separator
        System.out.println("-------------------------------------");
        
        //--- Inheritance
        Mobil myMobil = new Mobil("Toyota", 4);
        myMobil.infoMobil();
    }
}
