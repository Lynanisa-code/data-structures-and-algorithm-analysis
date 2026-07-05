class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head = null;
    Node tail = null;

    //tambahkan node ke dalam list
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; 
        } else {
            tail.next = newNode; 
            tail = newNode;   
            tail.next = head;   
        }
    }

    //tampilkan isi circular linked list
    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List kosong");
        } else {
            do {
                System.out.print(current.data + " -> ");
                current = current.next;
            } while (current != head);
            System.out.println("(kembali ke head: " + head.data + ")");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        
        cll.add(10);
        cll.add(20);
        cll.add(30);
        cll.add(40);
        
        System.out.println("Isi Circular Linked List:");
        cll.display();
    }
}
