import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        Node n5 = new Node(5, null);
        Node n6 = new Node(6, null);
        Node n7 = new Node(7, null);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n3;
        // n5.next = n6;
        // n6.next = n7;

        // printLinkedList(n1);
        // printLinkedList(n4);
        // printLinkedList(n4);
        // System.out.println(getInt(n1));
        // System.out.println(getInt(n4));
        // printLinkedList(addLists(n1, n4, 0));

        // deleteDuplicate(n1);
        // curr = n1;
        // System.out.print("[");
        // while (curr != null) {
        //     System.out.print(curr.val + " -> ");
        //     curr = curr.next;
        // }
        // System.out.println("null]");

        // System.out.println(getKthElement(n1, 5).val);

        // deleteMiddleNode(n1, n4);
        // curr = n1;
        // System.out.print("[");
        // while (curr != null) {
        //     System.out.print(curr.val + " -> ");
        //     curr = curr.next;
        // }
        // System.out.println("null]");

        // partition method
        // partition(n1, 5);
        // curr = n1;
        // System.out.print("[");
        // while (curr != null) {
        //     System.out.print(curr.val + " -> ");
        //     curr = curr.next;
        // }
        // System.out.println("null]");

        // System.out.println("===========================");

        // System.out.println(isPalindrome(n1));

        // System.out.println(hasIntersection(n1, n4));

        System.out.println(loopDetection(n1).val);

    }

    public static void printLinkedList(Node n) {
        Node curr = n;
        System.out.print("[");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null]");

        System.out.println("===========================");
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
            while (curr != null) {
                if (curr.next.val == n.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            n = n.next;
        }
    }

    // method that iterates through the nodes, finds the size of the list,
    // and then iterates to the Kth element of the list to get the node.
    // public static Node getKthElement(Node n, int i) {
    //     int size = 1;
    //     Node curr = n;
    //     while (curr.next != null) {
    //         size++;
    //         curr = curr.next;
    //     }

    //     System.out.println("size = " + size);

    //     int start = 0;
    //     int end = size - i - 1;
    //     Node node = n;
    //     while (start < end) {
    //         node = node.next;
    //         start++;
    //     }

    //     return node;
    // }

    // iterate through the list once and do a sliding window type of solution
    public static Node getKthElement(Node n, int i) {
        Node curr = n;
        Node follower = n;
        int lead = 0;
        while (curr.next != null) {
            if (lead >= i) {
                follower = follower.next;
            }
            lead++;
            curr = curr.next;
        }

        return follower;
    }

    // 2.3 Delete the middle node
    public static void deleteMiddleNode(Node n1, Node deleteNode) {
        Node curr = n1;
        while(curr != deleteNode && curr.next != null) {
            if (curr.next.equals(deleteNode)) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public static Node partition(Node node, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while (node != null) {
            Node next = node.next;
            node.next = null;
            if (node.val < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }
        
        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static Node sumLists(Node n1, Node n2) {
        int fromN1 = getInt(n1);
        int fromN2 = getInt(n2);
        int sum = fromN1 + fromN2;
        Node head = null;
        Node prev = null;
        while (sum > 0) {
            Node temp = new Node(sum % 10, null);
            if (head == null) {
                head = temp;
                prev = temp;
            } else {
                prev.next = temp;
                prev = temp;
            }
            sum /= 10;
        }

        return head;
    }

    public static int getInt(Node n) {
        int digits = n.val;
        int byTen = 1;
        Node curr = n.next;
        while (curr != null) {
            byTen *= 10;
            digits += curr.val * byTen;
            curr = curr.next;
        }

        return digits;
    }

    public static Node addLists(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        Node result = new Node(0, null);
        int value = carry;
        if (n1 != null) {
            value += n1.val;
        }
        if (n2 != null) {
            value += n2.val;
        }

        result.val = value % 10;
        if (n1 != null || n2 != null) {
            Node more = addLists(n1 == null ? null : n1.next,
                                 n2 == null ? null : n2.next,
                                 value >= 10 ? 1 : 0);
            result.next = more;
        }

        return result;
    }

    public static boolean isPalindrome(Node n) {
        Stack<Integer> stack = new Stack<>();
        Node check = n;
        while (check != null) {
            stack.push(check.val);
            check = check.next;
        }

        check = n;
        while (check != null) {
            if (check.val == stack.peek()) {
                stack.pop();
            }
            check = check.next;
        }

        System.out.println(stack.toString());
        return stack.isEmpty();
    }

    public static boolean hasIntersection(Node n1, Node n2) {
        HashMap<Integer, Node> map = new HashMap<>();
        while (n1 != null) {
            map.put(n1.val, n1.next);
            n1 = n1.next;
        }

        while (n2 != null) {
            if (map.containsKey(n2.val) && map.get(n2.val).equals(n2.next)) {
                return true;
            }
            n2 = n2.next;
        }

        return false;
    }

    // loop detection method that I built and wrote
    // public static Node loopDetection(Node n) {
    //     Node runner = n.next.next;
    //     Node curr = n;
    //     while (curr != null) {
    //         if (curr.equals(runner)) {
    //             return curr;
    //         }
    //         curr = curr.next;
    //         runner = runner.next.next;
    //     }

    //     return null;
    // }

    // loop detection method from book
    public static Node loopDetection(Node n) {
        Node slow = n;
        Node fast = n;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = n;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}