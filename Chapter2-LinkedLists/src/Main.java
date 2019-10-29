import java.util.HashSet;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(2, null);
        Node n5 = new Node(1, null);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node curr = n1;
        System.out.print("[");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null]");

        System.out.println("===========================");
        deleteDuplicate(n1);
        curr = n1;
        System.out.print("[");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null]");

    }

    private static class Node {
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // public static void deleteDuplicate(Node n) {
    //     if (n == null) return;

    //     HashSet<Integer> nodes = new HashSet<>();
    //     Node prev = null;

    //     while (n != null) {
    //         if (nodes.contains(n.val)) {
    //             prev.next = n.next;
    //         } else {
    //             nodes.add(n.val);
    //             prev = n;
    //         }
    //         n = n.next;
    //     }
    // }

    public static void deleteDuplicate(Node n) {
        while (n != null) {
            Node curr = n;
            while (curr.next != null) {
                if (curr.next.val == n.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            n = n.next;
        }
    }
}