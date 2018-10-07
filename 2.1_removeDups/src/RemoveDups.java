import java.util.*;

public class RemoveDups {

    public static void main(String[] args) {

        MyLinkedList newList = new MyLinkedList();
        newList.insert(2);
        newList.insert(3);
        newList.insert(3);
        newList.insert(3);
        newList.insert(1);
        newList.insert(1);
        System.out.print("Original list: ");
        newList.print();
        removeDupsInPlace(newList);
        System.out.print("With duplicates removed: ");
        newList.print();

    }

    public static void removeDups(MyLinkedList input) {

        HashSet uniqueVals = new HashSet();

        MyLinkedList.Node prevNode = null;
        MyLinkedList.Node currNode = input.head;

        while (currNode != null) {
            if (uniqueVals.contains(currNode.data)) {
                prevNode.next = currNode.next;
            } else {
                uniqueVals.add(currNode.data);
                prevNode = currNode;
            }
            currNode = currNode.next;
        }

    }

    public static void removeDupsInPlace(MyLinkedList input) {

        MyLinkedList.Node currNode = input.head;

        while (currNode != null) {
            MyLinkedList.Node runnerNode = currNode;
            while (runnerNode.next != null) {
                if (currNode.data == runnerNode.next.data) {
                    runnerNode.next = runnerNode.next.next;
                } else {
                    runnerNode = runnerNode.next;
                }
            }
            currNode = currNode.next;
        }

    }

}
