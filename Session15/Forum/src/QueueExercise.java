// Queue Menggunakan Array
class ArrayQueue {
    private int[] queue;
    private int front, rear, capacity, currentSize;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    // Menambahkan elemen ke belakang
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("ArrayQueue Penuh! Tidak bisa menambahkan " + data);
            return;
        }
        rear++;
        queue[rear] = data;
        currentSize++;
        System.out.println("ArrayQueue -> Enqueued: " + data);
    }

    // Menghapus elemen dari depan
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("ArrayQueue Kosong!");
            return -1;
        }
        int data = queue[front];
        front++;
        currentSize--;
        System.out.println("ArrayQueue -> Dequeued: " + data);
        return data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("ArrayQueue Kosong!");
            return;
        }
        System.out.print("Isi ArrayQueue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

// Queue Menggunakan Linked List
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListQueue {
    private Node front, rear;

    public LinkedListQueue() {
        this.front = this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Menambahkan elemen ke belakang 
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            System.out.println("LinkedListQueue -> Enqueued: " + data);
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
        System.out.println("LinkedListQueue -> Enqueued: " + data);
    }

    // Menghapus elemen dari depan
    public int dequeue() {
        if (this.front == null) {
            System.out.println("LinkedListQueue Kosong!");
            return -1;
        }
        Node temp = this.front;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }
        System.out.println("LinkedListQueue -> Dequeued: " + temp.data);
        return temp.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("LinkedListQueue Kosong!");
            return;
        }
        System.out.print("Isi LinkedListQueue: ");
        Node current = front;
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
        System.out.println("=== Latihan Queue dengan Array ===");
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.display();
        
        arrayQueue.dequeue();
        arrayQueue.display();
        
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        arrayQueue.display();

        System.out.println("\n=== Latihan Queue dengan Linked List ===");
        LinkedListQueue listQueue = new LinkedListQueue();
        listQueue.enqueue(100);
        listQueue.enqueue(200);
        listQueue.enqueue(300);
        listQueue.display();
        
        listQueue.dequeue();
        listQueue.display();
        
        listQueue.enqueue(400);
        listQueue.enqueue(500);
        listQueue.enqueue(600);
        listQueue.display();
    }
}
