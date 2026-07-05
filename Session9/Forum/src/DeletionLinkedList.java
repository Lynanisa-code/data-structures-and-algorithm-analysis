class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void removeHead() {
        if (head == null) {
            System.out.println("Linked List kosong"); 
            return;
        }
        head = head.next; 
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Linked List kosong");
            return;
        }
        
        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        current.next = null; 
    }

    public void removeAtPosition(int position) {
        if (head == null) {
            System.out.println("Linked List kosong");
            return;
        }

        if (position == 0) {
            removeHead();
            return;
        }

        Node current = head;
        int currentPosition = 0;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null || current.next == null) {
            System.out.println("Posisi " + position + " tidak ditemukan.");
            return;
        }

        current.next = current.next.next;
    }

    // tampilkan isi linked list
    public void display() {
        Node current = head;
        if (current == null) {
            System.out.println("Linked List kosong (null)");
            return;
        }
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

        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);

        System.out.println("=== Kondisi Awal Linked List ===");
        System.out.print("List Awal: ");
        list.display();
        System.out.println();

        System.out.println("--- 1. Menghapus Node Pertama (Head) ---");
        list.removeHead();
        System.out.print("Hasil:     ");
        list.display();
        System.out.println();

        System.out.println("--- 2. Menghapus Node Terakhir (Tail) ---");
        list.removeLast();
        System.out.print("Hasil:     ");
        list.display();
        System.out.println();

        System.out.println("--- 3. Menghapus Node Tengah (Indeks 1) ---");
        list.removeAtPosition(1);
        System.out.print("Hasil:     ");
        list.display();
    }
}
