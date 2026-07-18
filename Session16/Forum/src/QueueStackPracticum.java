// Implementasi Queue Menggunakan Dua Stack
import java.util.Stack;

class QueueUsingStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void enqueue(int data) {
        // Elemen dimasukkan langsung ke stack1
        stack1.push(data);
    }

    int dequeue() {
        // Jika stack2 kosong, pindahkan semua elemen dari stack1 ke stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        // Cek jika queue kosong
        if (stack2.isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        
        return stack2.pop();
    }
}

public class Main {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        System.out.println("Elemen yang di-dequeue: " + queue.dequeue());
    }
}
