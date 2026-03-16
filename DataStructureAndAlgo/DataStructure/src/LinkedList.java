public class LinkedList {

    private class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size = 0;

    public LinkedList() {
        head = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void remove(int data) {
        while (head != null && head.data != data) {
            head = head.next;
        }
    }

    public void addBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // find
            size++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

}
