/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

package Linked_List;

import java.util.Scanner;

public class add_two_numbers {
    static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
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
            System.out.print(temp.val + "->");
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

    public static Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        Node final_LL = new Node();
        Node ans = final_LL;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum > 9) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            Node temp = new Node(sum);
            ans.next = temp;
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                int sum = l1.val + carry;
                if (sum > 9) {
                    sum = sum - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                Node temp = new Node(sum);
                ans.next = temp;
                ans = ans.next;
                l1 = l1.next;
            }
        } else {
            while (l2 != null) {
                int sum = l2.val + carry;
                if (sum > 9) {
                    sum = sum - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                Node temp = new Node(sum);
                ans.next = temp;
                ans = ans.next;
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            Node temp = new Node(1);
            ans.next = temp;
            ans = ans.next;
        }
        return final_LL.next;
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
            print(addTwoNumbers(head1, head2));
        }
    }
}
