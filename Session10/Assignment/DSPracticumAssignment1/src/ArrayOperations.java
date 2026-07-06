import java.util.Arrays;

public class ArrayOperations {
    // Menampilkan isi array (Traversal)
    public static void traverse(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Pencarian Linear
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Pencarian Binary (Array terurut)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Penyisipan nilai ke dalam array
    public static int[] insert(int[] arr, int index, int value) {
        if (index < 0 || index > arr.length) return arr;
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        newArr[index] = value;
        System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
        return newArr;
    }

    // Penghapusan nilai dari array berdasarkan indeks
    public static int[] delete(int[] arr, int index) {
        if (index < 0 || index >= arr.length) return arr;
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
        return newArr;
    }
}