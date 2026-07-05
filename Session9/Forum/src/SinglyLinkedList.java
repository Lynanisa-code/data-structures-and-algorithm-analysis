class Node {
    int data;
    Node next;

    // Konstruktor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data); 
        newNode.next = head;         
        head = newNode;               
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) { 
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int currentPosition = 0;

        // telusuri list satu sebelum posisi tujuan
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Posisi " + position + " melebihi panjang list.");
            return;
        }

        // sisipkan node baru
        newNode.next = current.next; 
        current.next = newNode;     
    }

    // tampilkan isi linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("=== Latihan Insertion Singly Linked List ===");

        //Insert at Head
        list.insertAtHead(30);
        list.insertAtHead(10);
        System.out.print("Setelah Insert at Head (10, 30): ");
        list.display();

        //Insert at Tail
        list.insertAtTail(50);
        list.insertAtTail(60);
        System.out.print("Setelah Insert at Tail (50, 60): ");
        list.display();

        //Insert in the Middle 
        list.insertAtPosition(20, 1);
        System.out.print("Setelah Insert 20 di posisi 1:   ");
        list.display();

        list.insertAtPosition(40, 3);
        System.out.print("Setelah Insert 40 di posisi 3:   ");
        list.display();
    }
}
