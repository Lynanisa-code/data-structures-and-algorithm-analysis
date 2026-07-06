import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    // Menambahkan elemen
    public static void addElement(ArrayList<Integer> list, int value) {
        list.add(value);
    }
    
    // Menyisipkan elemen pada indeks tertentu
    public static void insertElement(ArrayList<Integer> list, int index, int value) {
        list.add(index, value);
    }

    // Menghapus elemen berdasarkan indeks
    public static void removeElement(ArrayList<Integer> list, int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }

    // Pencarian elemen
    public static int searchElement(ArrayList<Integer> list, int target) {
        return list.indexOf(target);
    }

    // Mengurutkan elemen
    public static void sortList(ArrayList<Integer> list) {
        Collections.sort(list);
    }
    
    // Traversal
    public static void traverse(ArrayList<Integer> list) {
        System.out.println(list.toString());
    }
}