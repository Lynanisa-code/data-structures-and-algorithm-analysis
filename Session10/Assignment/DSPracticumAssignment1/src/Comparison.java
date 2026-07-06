import java.util.ArrayList;

public class Comparison {
    public static void main(String[] args) {
        int dataSize = 1000;
        int[] array = new int[dataSize];
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Inisialisasi data dummy
        for (int i = 0; i < dataSize; i++) {
            array[i] = i;
            arrayList.add(i);
        }

        System.out.println("=== PENGUJIAN SKALA KECIL ===");
        int[] smallArr = {10, 20, 30, 40, 50};
        ArrayList<Integer> smallList = new ArrayList<>();
        for(int val : smallArr) smallList.add(val);
        
        System.out.print("Array Traversal: ");
        ArrayOperations.traverse(smallArr);
        System.out.print("ArrayList Traversal: ");
        ArrayListOperations.traverse(smallList);
        System.out.println("\n");
        
        System.out.println("Pencarian 30 dalam Array: Ditemukan di indeks " + ArrayOperations.linearSearch(smallArr, 30));
        System.out.println("Pencarian 30 dalam ArrayList: Ditemukan di indeks " + ArrayListOperations.searchElement(smallList, 30));
        System.out.println("\n");
        
        smallArr = ArrayOperations.insert(smallArr, 2, 25);
        ArrayListOperations.insertElement(smallList, 2, 25);
        System.out.print("Array setelah penyisipan elemen 25: ");
        ArrayOperations.traverse(smallArr);
        System.out.print("ArrayList setelah penyisipan elemen 25: ");
        ArrayListOperations.traverse(smallList);
        System.out.println("\n");
        
        // Mengukur waktu eksekusi pencarian di Array
        long startArr = System.nanoTime();
        ArrayOperations.linearSearch(smallArr, 30);
        long endArr = System.nanoTime();
        double timeArr = (endArr - startArr) / 1_000_000.0; // Konversi ke ms

        // Mengukur waktu eksekusi pencarian di ArrayList
        long startList = System.nanoTime();
        ArrayListOperations.searchElement(smallList, 30);
        long endList = System.nanoTime();
        double timeList = (endList - startList) / 1_000_000.0;

        System.out.println("Waktu eksekusi pencarian pada Array: " + timeArr + " ms");
        System.out.println("Waktu eksekusi pencarian pada ArrayList: " + timeList + " ms");
        System.out.println("\n");

        System.out.println("=== PERBANDINGAN KINERJA (" + dataSize + " Elemen) ===");
        
        // Test Pencarian
        int target = 999;
        long startTime = System.nanoTime();
        ArrayOperations.linearSearch(array, target);
        long endTime = System.nanoTime();
        double arraySearchTime = (endTime - startTime) / 1_000_000.0;

        startTime = System.nanoTime();
        ArrayListOperations.searchElement(arrayList, target);
        endTime = System.nanoTime();
        double arrayListSearchTime = (endTime - startTime) / 1_000_000.0;

        // Test Penyisipan ditengah (index 500)
        startTime = System.nanoTime();
        array = ArrayOperations.insert(array, 500, 9999);
        endTime = System.nanoTime();
        double arrayInsertTime = (endTime - startTime) / 1_000_000.0;

        startTime = System.nanoTime();
        ArrayListOperations.insertElement(arrayList, 500, 9999);
        endTime = System.nanoTime();
        double arrayListInsertTime = (endTime - startTime) / 1_000_000.0;

        // Test Penghapusan ditengah (index 500)
        startTime = System.nanoTime();
        array = ArrayOperations.delete(array, 500);
        endTime = System.nanoTime();
        double arrayDeleteTime = (endTime - startTime) / 1_000_000.0;

        startTime = System.nanoTime();
        ArrayListOperations.removeElement(arrayList, 500);
        endTime = System.nanoTime();
        double arrayListDeleteTime = (endTime - startTime) / 1_000_000.0;

        // Tampilkan Tabel
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s |\n", "Operasi", "Array (ms)", "ArrayList (ms)");
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-15s | %-15.4f | %-15.4f |\n", "Pencarian", arraySearchTime, arrayListSearchTime);
        System.out.printf("| %-15s | %-15.4f | %-15.4f |\n", "Penyisipan", arrayInsertTime, arrayListInsertTime);
        System.out.printf("| %-15s | %-15.4f | %-15.4f |\n", "Penghapusan", arrayDeleteTime, arrayListDeleteTime);
        System.out.println("---------------------------------------------------------");
    }
}