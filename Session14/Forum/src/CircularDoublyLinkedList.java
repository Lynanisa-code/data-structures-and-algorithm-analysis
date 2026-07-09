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

class CircularDoublyLinkedList {
    Node head = null;

    // Insertion at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            Node tail = head.prev;

            newNode.next = head;
            newNode.prev = tail;
            
            tail.next = newNode; 
            head.prev = newNode; 
            head = newNode;    
        }
        System.out.println("Berhasil menambahkan " + data + " di awal.");
    }

    // Insertion at the end 
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            Node tail = head.prev;

            newNode.next = head;
            newNode.prev = tail;

            tail.next = newNode; 
            head.prev = newNode; 
        }
        System.out.println("Berhasil menambahkan " + data + " di akhir.");
    }

    // Deletion at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List kosong, tidak ada elemen untuk dihapus.");
            return;
        }

        if (head.next == head) {
            System.out.println("Menghapus node terakhir: " + head.data);
            head = null;
        } else {
            Node tail = head.prev;
            System.out.println("Menghapus node awal: " + head.data);
            
            head = head.next;    
            head.prev = tail;  
            tail.next = head; 
        }
    }

    // Deletion at the End
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List kosong, tidak ada elemen untuk dihapus.");
            return;
        }

        if (head.next == head) {
            System.out.println("Menghapus node terakhir: " + head.data);
            head = null;
        } else {
            Node tail = head.prev;
            Node newTail = tail.prev; 
            System.out.println("Menghapus node akhir: " + tail.data);
            
            newTail.next = head; 
            head.prev = newTail; 
        }
    }

    // 5. Menampilkan elemen dari Head hingga Tail (Forward Traversal)
    public void displayForward() {
        if (head == null) {
            System.out.println("Circular Doubly Linked List kosong.");
            return;
        }

        Node temp = head;
        System.out.print("Forward: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head " + head.data + ")");
    }

    // tampilkan elemen dari Tail hingga Head 
    public void displayBackward() {
        if (head == null) {
            System.out.println("Circular Doubly Linked List kosong.");
            return;
        }

        Node tail = head.prev;
        Node temp = tail;
        System.out.print("Backward: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println("(Back to Tail " + tail.data + ")");
    }
}

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        cdll.insertAtEnd(10);
        cdll.insertAtEnd(20);
        cdll.insertAtEnd(30);
        cdll.insertAtBeginning(5);
        
        cdll.displayForward();  
        cdll.displayBackward(); 

        System.out.println("\n- Operasi Penghapusan -");
        cdll.deleteAtBeginning();

        cdll.deleteAtEnd();       
        cdll.displayForward();   
    }
}
