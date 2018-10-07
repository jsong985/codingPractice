public class MyLinkedList {

    Node head;

    class Node {

        int data;
        Node next;

        Node (int d) {
            data = d;
        }

    }

    void insert(int d) {

        Node newHead = new Node(d);
        newHead.next = head;
        head = newHead;

    }

    void print() {

        System.out.print("{ ");

        Node runner = head;
        while (runner != null) {
            System.out.print(runner.data + " ");
            runner = runner.next;
        }

        System.out.print("}\n");

    }

}
