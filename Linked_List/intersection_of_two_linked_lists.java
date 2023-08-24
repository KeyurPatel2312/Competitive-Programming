package Linked_List;

import java.util.Scanner;

public class intersection_of_two_linked_lists {
    static class Node {
        int num;
        Node next;

        Node() {
        }

        Node(int val) {
            num = val;
            next = null;
        }
    }

    static Node insertNode(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.num + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static int findLenDiff(Node head1, Node head2) {
        int len1 = 0, len2 = 0;

        while (head1 != null) {
            len1++;
            head1 = head1.next;
        }

        while (head2 != null) {
            len2++;
            head2 = head2.next;
        }

        return (len1 - len2);
    }

    static Node getIntersectionNode(Node head1, Node head2) {
        int lendiff = findLenDiff(head1, head2);

        if (lendiff < 0) {
            while (lendiff++ <= 0) {
                head1 = head1.next;
            }
        } else {
            while (lendiff-- >= 0) {
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }

    public static void main(String args[]) {
        Node head1 = null;
        Node head2 = null;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the length of linked list 1");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                head1 = insertNode(head1, val);
            }
            System.out.println("Enter the length of linked list 2");
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int val = sc.nextInt();
                head2 = insertNode(head2, val);
            }
            System.out.println("Linked List 1 Created");
            print(head1);
            System.out.println("Linked List 2 Created");
            print(head2);
            Node ans = getIntersectionNode(head1, head2);

            System.out.println(ans.num);
        }
    }
}
