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
    Node head = null;

    // Insert Node at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insertion at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insertion after a given node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Node acuan tidak boleh null.");
            return;
        }

        Node newNode = new Node(data);
        
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next = newNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    // Insertion before a given node
    public void insertBefore(Node nextNode, int data) {
        if (nextNode == null) {
            System.out.println("Node acuan tidak boleh null.");
            return;
        }

        Node newNode = new Node(data);

        newNode.prev = nextNode.prev;
        newNode.next = nextNode;
        nextNode.prev = newNode;

        if (newNode.prev == null) {
            head = newNode;
        } else {
            newNode.prev.next = newNode;
        }
    }

    // Insertion at a specific position (1-based index)
    public void insertAtPosition(int position, int data) {
        if (position < 1) {
            System.out.println("Posisi harus lebih besar dari 0.");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Posisi melebihi batas indeks list saat ini.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    // cetak list dari depan ke belakang
    public void display() {
        if (head == null) {
            System.out.println("List Kosong");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println("1. Insert at Beginning");
        dll.insertAtBeginning(20);
        dll.insertAtBeginning(10);
        dll.display();

        System.out.println("\n2. Insert at End");
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.display();

        System.out.println("\n3. Insert After Given Node");
        Node targetAfter = dll.head.next; 
        dll.insertAfter(targetAfter, 30);
        dll.display(); 

        System.out.println("\n4. Insert Before Given Node");
        Node targetBefore = dll.head;
        dll.insertBefore(targetBefore, 5);
        dll.display(); 

        System.out.println("\n5. Insert at Specific Position");
        dll.insertAtPosition(4, 25);
        dll.display(); 
    }
}
