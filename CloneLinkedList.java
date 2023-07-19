class Node {
    int data;
    Node next;
    Node random;
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
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
            System.out.print("Data: " + current.data);
            if (current.random != null) {
                System.out.print(", Random: " + current.random.data);
            }
            System.out.println();
            current = current.next;
        }
    }
    public LinkedList clone() {
        if (head == null) {
            return null;
        }
        // Step 1: Create a copy of each node and insert it next to the original node
        Node current = head;
        while (current != null) {
            Node cloneNode = new Node(current.data);
            cloneNode.next = current.next;
            current.next = cloneNode;
            current = cloneNode.next;
        }
        // Step 2: Update the random pointers of the cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        // Step 3: Separate the original and cloned linked lists
        LinkedList clonedList = new LinkedList();
        current = head;
        Node clonedHead = current.next;
        while (current != null) {
            Node clonedNode = current.next;
            current.next = clonedNode.next;
            if (clonedNode.next != null) {
                clonedNode.next = clonedNode.next.next;
            }
            clonedList.addNode(clonedNode.data);
            current = current.next;
        }
        clonedList.head = clonedHead;

        return clonedList;
    }
}
public class CloneLinkedList {
    public static void main(String[] args) {
        LinkedList originalList = new LinkedList();
        originalList.addNode(13);
        originalList.addNode(22);
        originalList.addNode(30);
        originalList.addNode(24);
        originalList.addNode(75);
        // Set random pointers
        originalList.head.random = originalList.head.next.next;
        originalList.head.next.random = originalList.head.next.next.next;
        originalList.head.next.next.random = originalList.head;
        System.out.println("Original List:");
        originalList.printList();
        LinkedList clonedList = originalList.clone();
        System.out.println("\nCloned List:");
        clonedList.printList();
    }
}