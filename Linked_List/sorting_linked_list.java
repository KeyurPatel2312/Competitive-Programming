/*  Given the head of a linked list, return the list after sorting it in ascending 
    order.
*/
package Linked_List;

import java.util.*;

public class sorting_linked_list {
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

    static Node findMiddleNode(Node head) {
        Node slow = null;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = (slow == null) ? fast : slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;
        return mid;
    }

    static Node mergeSortedList(Node list1, Node list2) {
        Node dummy = new Node();
        Node tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.num < list2.num) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMiddleNode(head);
        Node left = sortList(head);
        Node right = sortList(mid);
        return mergeSortedList(left, right);
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
            System.out.println("Sorted Linked List");
            print(sortList(head));

        }
    }
}