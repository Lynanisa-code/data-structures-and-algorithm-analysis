// Stack Menggunakan Array
class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    // Menambahkan elemen ke atas stack
    public void push(int data) {
        if (isFull()) {
            System.out.println("ArrayStack Overflow! Tidak dapat menambahkan " + data);
            return;
        }
        stack[++top] = data;
        System.out.println("ArrayStack -> Pushed: " + data);
    }

    // Menghapus dan mengembalikan elemen teratas
    public int pop() {
        if (isEmpty()) {
            System.out.println("ArrayStack Underflow! Stack kosong.");
            return -1;
        }
        int data = stack[top--];
        System.out.println("ArrayStack -> Popped: " + data);
        return data;
    }

    // Melihat elemen teratas tanpa menghapus
    public int peek() {
        if (isEmpty()) {
            System.out.println("ArrayStack kosong.");
            return -1;
        }
        return stack[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("ArrayStack Kosong!");
            return;
        }
        System.out.print("Isi ArrayStack (dari atas ke bawah): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

// Stack Menggunakan Linked List
class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    private StackNode top;

    public LinkedListStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Menambahkan node baru di posisi top
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        System.out.println("LinkedListStack -> Pushed: " + data);
    }

    // Menghapus dan mengembalikan data dari node top
    public int pop() {
        if (isEmpty()) {
            System.out.println("LinkedListStack Underflow! Stack kosong.");
            return -1;
        }
        int data = top.data;
        top = top.next;
        System.out.println("LinkedListStack -> Popped: " + data);
        return data;
    }

    // Melihat elemen di node top
    public int peek() {
        if (isEmpty()) {
            System.out.println("LinkedListStack kosong.");
            return -1;
        }
        return top.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("LinkedListStack Kosong!");
            return;
        }
        System.out.print("Isi LinkedListStack (dari atas ke bawah): ");
        StackNode current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Class Main
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Latihan Stack dengan Array ===");
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.display();
        
        System.out.println("Elemen teratas (Peek): " + arrayStack.peek());
        
        arrayStack.pop();
        arrayStack.display();
        
        arrayStack.push(40);
        arrayStack.display();
        
        System.out.println("\n=== Latihan Stack dengan Linked List ===");
        LinkedListStack listStack = new LinkedListStack();
        listStack.push(100);
        listStack.push(200);
        listStack.push(300);
        listStack.display();
        
        System.out.println("Elemen teratas (Peek): " + listStack.peek());
        
        listStack.pop();
        listStack.display();
        
        listStack.push(400);
        listStack.push(500);
        listStack.display();
    }
}
