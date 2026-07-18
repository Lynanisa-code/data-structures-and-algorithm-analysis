// Implementasi Stack dengan Min Stack
class MinStack {
    private int arr[];
    private int top;
    private int min;

    MinStack(int size) {
        arr = new int[size];
        top = -1;
        min = Integer.MAX_VALUE;
    }

    void push(int x) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        // Jika nilai yang dimasukkan lebih kecil dari nilai min saat ini, perbarui min
        if (x < min) {
            min = x; 
        }
        arr[++top] = x;
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int removed = arr[top--];
        
        // Jika elemen yang dihapus adalah min, perbarui nilai min
        if (removed == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i <= top; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
        }
        return removed;
    }

    int getMin() {
        return min;
    }
}

// Class Main
public class Main {
    public static void main(String[] args) {
        MinStack stack = new MinStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(5);
        stack.push(30);
        
        System.out.println("Nilai minimum dalam stack: " + stack.getMin());
    }
}
