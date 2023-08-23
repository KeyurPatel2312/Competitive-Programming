package Linked_List;

import java.util.*;

public class remove_N_th_node_from_the_end_of_a_linked_list {
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

    static Node removeNthNodeFromEnd(Node head, int n) {
        Node start = new Node();
        start.next = head;
        Node fast = start;
        Node slow = start;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String args[]) {
        Node head = null;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the length of linked list");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                head = insertNode(head, val);
            }
            System.out.println("Linked List Created");
            print(head);
            System.out.println("Enter Nth Node from end to be deleted");
            int m = sc.nextInt();
            System.out.println("Linked List after deleting Nth node from end");
            print(removeNthNodeFromEnd(head, m));
        }
    }
}