// Superclass
class Kendaraan {
    String merk;

    void tampilkanInfo() {
        System.out.println("Merk Kendaraan: " + merk);
    }
}

// Subclass
class Mobil extends Kendaraan {
    int jumlahPintu;

    // Menggunakan keyword super untuk memanggil method superclass
    public Mobil(String merk, int jumlahPintu) {
        this.merk = merk; // Mengakses atribut dari superclass
        this.jumlahPintu = jumlahPintu;
    }

    void infoMobil() {
        super.tampilkanInfo(); // Call method dari superclass
        System.out.println("Jumlah pintu: " + jumlahPintu);
    }
}