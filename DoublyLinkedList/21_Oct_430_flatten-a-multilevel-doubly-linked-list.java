package DoublyLinkedList;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> st = new Stack<>();
        Node curr = head;
        Node tail = head;

        while (curr != null) {
            // check if child exists( another DLL)
            if (curr.child != null) {
                // collect that child
                Node child = curr.child;

                if (curr.next != null) {
                    // push curr next into stack
                    st.push(curr.next);
                    // make curnext prev null
                    curr.next.prev = null;
                }
                // attach child in psrent DLL
                curr.next = child;
                child.prev = curr;
                // now sub DLL has been added to parent DLL make child null
                curr.child = null;
            }
            tail = curr;
            curr = curr.next;
        }

        // now just need to add another Parent DLL into a single DLL which are stored
        // into Stack
        while (!st.isEmpty()) {
            curr = st.pop();
            tail.next = curr;
            curr.prev = tail;

            while (curr != null) {
                tail = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}