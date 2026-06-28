public class BinarySearch {
    public static void main(String[] args) {
        // Array harus dalam keadaan terurut
        int[] sortedAngka = {3, 5, 7, 8, 12};
        int target = 12;
        int low = 0;
        int high = sortedAngka.length - 1;
        int hasilIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedAngka[mid] == target) {
                hasilIndex = mid;
                break;
            } else if (sortedAngka[mid] < target) {
                low = mid + 1; // Cari di sisi kanan
            } else {
                high = mid - 1; // Cari di sisi kiri
            }
        }

        if (hasilIndex != -1) {
            System.out.println("Elemen " + target + " ditemukan pada indeks " + hasilIndex);
        } else {
            System.out.println("Elemen " + target + " tidak ditemukan.");
        }
    }
}
