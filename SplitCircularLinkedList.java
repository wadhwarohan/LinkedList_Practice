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
            newNode.next = head; // Make it circular
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Make it circular
        }
    }
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    public void splitList() {
        if (head == null || head.next == head) {
            System.out.println("The list cannot be split.");
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // For an even number of nodes, move fast one more step
        if (fast.next.next == head) {
            fast = fast.next;
        }
        // Set the head of the second half
        Node head2 = slow.next;
        // Make the first half circular
        slow.next = head;
        // Make the second half circular
        fast.next = head2;
        // Print the two halves
        System.out.print("First Half: ");
        printList(head);
        System.out.print("Second Half: ");
        printList(head2);
    }
    private void printList(Node start) {
        Node current = start;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != start);
        System.out.println();
    }
}
public class SplitCircularLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(4);
        linkedList.addNode(2);
        linkedList.addNode(7);
        linkedList.addNode(9);
        linkedList.addNode(1);
        System.out.print("Original List: ");
        linkedList.printList();
        linkedList.splitList();
    }
}