class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Menambahkan elemen di akhir (Push at Tail)
    public void pushAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Deletion at the Beginning (popFromHead)
    public void deleteAtBeginning() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            System.out.println("Linked List sudah kosong.");
        }
    }

    // Deletion at the End (popFromTail)
    public void deleteAtEnd() {
        if (head != null) {
            if (head.next == null) {
                head = null; 
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.prev.next = null;
            }
        }
    }

    // menghapus node tertentu yang sudah diketahui
    private void deleteNode(Node del) {
        if (head == null || del == null) {
            return;
        }
        
        if (head == del) {
            head = del.next;
        }

        if (del.next != null) {
            del.next.prev = del.prev;
        }

        if (del.prev != null) {
            del.prev.next = del.next;
        }
    }

    // Deletion after a given node
    public void deleteAfter(Node givenNode) {
        if (givenNode == null || givenNode.next == null) {
            System.out.println("Node yang diberikan tidak boleh null atau merupakan node terakhir.");
            return;
        }
        deleteNode(givenNode.next);
    }

    // Deletion before a given node
    public void deleteBefore(Node givenNode) {
        if (givenNode == null || givenNode.prev == null) {
            System.out.println("Node yang diberikan tidak boleh null atau merupakan node pertama.");
            return;
        }
        deleteNode(givenNode.prev);
    }

    // Deletion at a specific position (1-based index)
    public void deleteAtPosition(int position) {
        if (head == null || position <= 0) {
            System.out.println("Posisi tidak valid atau list kosong.");
            return;
        }

        Node current = head;

        for (int i = 1; current != null && i < position; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Posisi melebihi ukuran list.");
            return;
        }

        deleteNode(current);
    }

    // Menampilkan isi Doubly Linked List
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Memasukkan data awal
        dll.pushAtTail(10);
        dll.pushAtTail(20);
        dll.pushAtTail(30);
        dll.pushAtTail(40);
        dll.pushAtTail(50);
        dll.pushAtTail(60);

        System.out.println("List Awal:");
        dll.display();

        System.out.println("\n1. Deletion at the Beginning:");
        dll.deleteAtBeginning(); 
        dll.display();

        System.out.println("\n2. Deletion at the End:");
        dll.deleteAtEnd();
        dll.display();

        System.out.println("\n3. Deletion after given node (node bernilai 30):");
        Node node30 = dll.head.next; 
        dll.deleteAfter(node30);
        dll.display();
        System.out.println("(node bernilai 40 deleted)");

        System.out.println("\n4. Deletion before given node (node bernilai 50):");
        Node node50 = dll.head.next.next; 
        dll.deleteBefore(node50);
        dll.display();
        System.out.println("(node bernilai 30 deleted)");

        System.out.println("\n5. Deletion at specific position (posisi 2):");
        dll.deleteAtPosition(2);
        dll.display();
    }
}
