public class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = size = 0;
    }

    // Cek antrian penuh
    public boolean isFull() {
        return size == capacity;
    }

    // Cek antrian kosong
    public boolean isEmpty() {
        return size == 0;
    }

    // Tambah elemen ke dalam Queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue penuh. Tidak dapat menambahkan " + data);
            return;
        }
        queue[rear] = data;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println("Enqueued: " + data);
    }

    // Hapus elemen dari Queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong");
            return -1;
        }
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued: " + data);
        return data;
    }

    // Tampilkan isi Queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue kosong");
            return;
        }
        System.out.print("Isi Circular Queue: ");
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.display();

        cq.dequeue(); 
        cq.dequeue(); 
        cq.display();

        // Tambahkan elemen baru untuk melihat efek circular
        cq.enqueue(50);
        cq.enqueue(60);
        cq.enqueue(70);
        cq.display(); 
    }
}
