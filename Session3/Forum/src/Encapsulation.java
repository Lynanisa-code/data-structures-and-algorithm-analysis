class RekeningBank {
    // Variabel dibuat private
    private double saldo;

    public RekeningBank(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    // Public Getter
    public double getSaldo() {
        return saldo;
    }

    // Public Setter with logic
    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Berhasil setor: Rp" + jumlah);
        } else {
            System.out.println("Jumlah setor tidak valid!");
        }
    }
}
