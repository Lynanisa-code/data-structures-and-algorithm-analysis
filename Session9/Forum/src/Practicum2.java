// COMPONENT SINGLE LINKED LIST (SLL)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    void insertAtPosition(int position, int data) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Posisi melebihi panjang Linked List");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void delete(int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }

    void reverse() {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Latihan 5.1
    void findMax() {
        if (head == null) {
            System.out.println("Linked List kosong");
            return;
        }
        int max = head.data;
        int position = 0, currentPosition = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
                position = currentPosition;
            }
            currentPosition++;
            temp = temp.next;
        }
        System.out.println("Nilai maksimum: " + max + " ditemukan di posisi: " + position);
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// COMPONENT DOUBLY LINKED LIST (DLL)
class DoublyNode {
    int data;
    DoublyNode next, prev;

    DoublyNode(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

class DoublyLinkedList {
    DoublyNode head;

    void insert(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    void insertAtEnd(int data) {
        insert(data);
    }

    void delete(int key) {
        DoublyNode temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null) return; 
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next; 
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("Linked List kosong");
            return;
        }
        DoublyNode temp = head;
        if (position == 0) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        for (int i = 0; i < position && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Posisi melebihi panjang Linked List");
            return;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    void reverseTraversal() {
        if (head == null) {
            System.out.println("Linked List kosong");
            return;
        }
        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Latihan 5.2
    void deleteByValue(int value) {
        if (head == null) {
            System.out.println("Linked List kosong");
            return;
        }
        DoublyNode temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Nilai tidak ditemukan");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    void display() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        // --- SINGLE LINKED LIST (SLL) ---
        System.out.println("=== SINGLE LINKED LIST (SLL) ===");
        LinkedList sll = new LinkedList();
        
        System.out.print("Insert awal (10, 20, 30): ");
        sll.insert(10);
        sll.insert(20);
        sll.insert(30);
        sll.display(); 

        System.out.print("Insert At Beginning (5): ");
        sll.insertAtBeginning(5);
        sll.display(); 

        System.out.print("Delete key (20): ");
        sll.delete(20);
        sll.display(); 

        System.out.print("Insert At Position 2 (Nilai 25): ");
        sll.insertAtPosition(2, 25);
        sll.display();

        System.out.print("Reverse List: ");
        sll.reverse();
        sll.display(); 

        System.out.println("\n--- Latihan Studi Kasus 5.1 (SLL) ---");
        LinkedList sllExercise = new LinkedList();
        sllExercise.insert(10);
        sllExercise.insert(20);
        sllExercise.insert(15);
        sllExercise.insert(30);
        System.out.print("Isi List Latihan: ");
        sllExercise.display();
        sllExercise.findMax();


        // --- DOUBLY LINKED LIST (DLL) ---
        System.out.println("\n=== DOUBLY LINKED LIST (DLL) ===");
        DoublyLinkedList dll = new DoublyLinkedList();
        
        System.out.print("Insert awal (10, 20, 30): ");
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.display(); 

        System.out.print("Insert At End (40): ");
        dll.insertAtEnd(40);
        dll.display();

        System.out.print("Delete At Position 1: ");
        dll.deleteAtPosition(1);
        dll.display();

        System.out.print("Reverse Traversal (Mundur): ");
        dll.reverseTraversal(); 

        System.out.println("\n--- Latihan Studi Kasus 5.2 (DLL) ---");
        DoublyLinkedList dllExercise = new DoublyLinkedList();
        dllExercise.insert(10);
        dllExercise.insert(20);
        dllExercise.insert(30);
        dllExercise.insert(40);
        System.out.print("Isi List Latihan: ");
        dllExercise.display();
        
        System.out.print("Delete By Value (30): ");
        dllExercise.deleteByValue(30);
        dllExercise.display();
    }
}
