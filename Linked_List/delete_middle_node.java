/*
 * You are given the head of a linked list. Delete the middle node, and 
 * return the head of the modified linked list. The middle node of a linked list 
 * of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, 
 * where ⌊x⌋ denotes the largest integer less than or equal to x.
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */

package Linked_List;

import java.util.Scanner;

public class delete_middle_node {
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

    static Node deleteMiddle(Node head) {
        Node temp = head;

        if (head == null || head.next == null) {
            return null;
        }
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int middle = length / 2;
        temp = head;

        for (int i = 1; i < middle; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
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
            print(deleteMiddle(head));
        }
    }
}
