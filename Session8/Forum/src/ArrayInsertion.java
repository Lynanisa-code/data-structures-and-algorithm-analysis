import java.util.Arrays;

public class ArrayInsertion {
    public static void main(String[] args) {
        // Array awal
        int[] angka = {10, 20, 30, 40, 50};
        int elemenBaru = 25;
        int pos = 2; // Menyisipkan pada indeks ke-2

        // Membuat array baru dengan ukuran yang lebih besar (+1)
        int[] hasil = new int[angka.length + 1];

        // Menyalin elemen-elemen sebelum posisi penyisipan
        for (int i = 0; i < pos; i++) {
            hasil[i] = angka[i];
        }

        // Menyisipkan elemen baru pada posisi yang ditentukan
        hasil[pos] = elemenBaru;

        // Menyalin elemen-elemen setelah posisi penyisipan dengan menggesernya
        for (int i = pos; i < angka.length; i++) {
            hasil[i + 1] = angka[i];
        }

        // Menampilkan hasil
        System.out.println("Array setelah penyisipan: " + Arrays.toString(hasil));
    }
}
