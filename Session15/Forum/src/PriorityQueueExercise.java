import java.util.PriorityQueue;
import java.util.Collections;

public class PriorityQueueExercise {
    public static void main(String[] args) {
        System.out.println("=== Priority Queue Default (Min-Heap) ===");
        // Default pada Java adalah Min-Heap (Nilai terkecil diproses lebih dulu)
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        minPq.add(30);
        minPq.add(10);
        minPq.add(20);
        
        System.out.println("Urutan keluar dari Min-Heap:");
        while (!minPq.isEmpty()) {
            // poll() menghapus dan mengembalikan elemen dengan prioritas tertinggi
            System.out.println(minPq.poll()); 
        }

        System.out.println("\n=== Priority Queue Custom (Max-Heap) ===");
        // Menggunakan Collections.reverseOrder() untuk mengubah menjadi Max-Heap
        // Nilai terbesar akan diproses lebih dulu
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        maxPq.add(30);
        maxPq.add(10);
        maxPq.add(50);
        maxPq.add(20);
        
        System.out.println("Urutan keluar dari Max-Heap:");
        while (!maxPq.isEmpty()) {
            System.out.println(maxPq.poll()); 
        }
    }
}
