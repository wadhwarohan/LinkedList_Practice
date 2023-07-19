class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void addNode(int data) {
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

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node findNthNodeFromEnd(int n) {
        if (head == null || n <= 0) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // Move the fast pointer n positions ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null; // n is greater than the list length
            }
            fast = fast.next;
        }

        // Move both pointers together until the fast pointer reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

public class FindNthNodeFromEnd {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);

        System.out.print("Linked List: ");
        linkedList.printList();

        int n = 2;
        Node nthNodeFromEnd = linkedList.findNthNodeFromEnd(n);

        if (nthNodeFromEnd != null) {
            System.out.println("The " + n + "th node from the end is: " + nthNodeFromEnd.data);
        } else {
            System.out.println("Invalid value of n or the linked list is empty.");
        }
    }
}