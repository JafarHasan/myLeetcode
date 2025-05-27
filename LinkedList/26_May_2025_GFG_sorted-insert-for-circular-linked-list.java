/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {

    public Node sortedInsert(Node head, int data) {
        // code here
        //when list is empty
        Node add = new Node(data);
        if (head == null) {
            add.next = add;
            head = add;
            return head;
        }
        //when newnode is minimum (insert before head)
        Node curr = head;
        //find last Node 
        if (data <= head.data) {
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = add;
            add.next = head;
            head = add;
            return head;
        }

        //between anywhere
        Node prev = head;
        curr = head.next;
        while (curr != head && curr.data < data) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = add;
        add.next = curr;
        return head;

    }
}
