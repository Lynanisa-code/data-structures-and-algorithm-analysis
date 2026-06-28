import java.util.Arrays;

public class ArrayDeletion {
    public static void main(String[] args) {
        // Array awal
        int[] angka = {10, 20, 30, 40, 50};
        int pos = 2; // Indeks yang ingin dihapus (menghapus angka 30)

        // Membuat array hasil dengan ukuran lebih kecil
        int[] hasil = new int[angka.length - 1];

        // Menyalin elemen sebelum posisi yang dihapus
        for (int i = 0; i < pos; i++) {
            hasil[i] = angka[i];
        }

        // Menyalin elemen setelah posisi yang dihapus
        // Menggeser elemen sisa untuk mengisi kekosongan
        for (int i = pos; i < angka.length - 1; i++) {
            hasil[i] = angka[i + 1];
        }

        // Menampilkan hasil
        System.out.println("Array setelah penghapusan: " + Arrays.toString(hasil));
    }
}
