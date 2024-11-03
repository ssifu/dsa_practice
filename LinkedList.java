public class LinkedList {
    private Node head;
    private int length;

    public void insert(int val) {
        Node node = new Node(val);

        if (this.head == null) {
            this.head = node;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        ++this.length;
    }

    public void addFirst(int data) {
        Node node = new Node(data);

        if (this.head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public int size() {
        return this.length;
    }

    public void printList() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        System.err.println(list.size());
        list.printList();
        list.addFirst(9);
        list.printList();
        list.insert(10);
        list.printList();
    }
}