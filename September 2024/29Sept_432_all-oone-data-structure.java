import java.util.*;

class Node {
    Node prev;
    Node next;
    List<String> list;
    int cnt;

    Node(int cnt) {
        this.cnt = cnt;
        this.list = new ArrayList<>(); // Initialize the list
        this.prev = null;
        this.next = null;
    }
}

class AllOne {
    private Node head;
    private Node tail;
    private HashMap<String, Node> map;

    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        tail = head; // Initially, head and tail point to the same node
        head.next = null; // Connect head to nothing initially
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            // Key doesn't exist, add it with count 1
            if (head.next == null || head.next.cnt != 1) {
                addNode(head, 1);
            }
            head.next.list.add(key);
            map.put(key, head.next);
        } else {
            // Key already exists, increase its frequency
            Node curr = map.get(key);
            int currCnt = curr.cnt;

            // Add a new node if it doesn't exist for currCnt + 1
            if (curr.next == null || curr.next.cnt != currCnt + 1) {
                addNode(curr, currCnt + 1);
            }

            curr.next.list.add(key);
            map.put(key, curr.next);
            curr.list.remove(key);

            // Remove current node if its list is empty
            if (curr.list.isEmpty()) {
                removeNode(curr);
            }
        }
    }

    public void dec(String key) {
        Node curr = map.get(key);
        if (curr == null)
            return; // Key doesn't exist

        int currCnt = curr.cnt;
        curr.list.remove(key);

        if (currCnt == 1) {
            map.remove(key); // Remove from map if count reaches zero
        } else {
            // Decrease frequency
            if (curr.prev == head || curr.prev.cnt != currCnt - 1) {
                addNode(curr.prev, currCnt - 1);
            }
            curr.prev.list.add(key);
            map.put(key, curr.prev);
        }

        // Remove current node if its list is empty
        if (curr.list.isEmpty()) {
            removeNode(curr);
        }
    }

    public String getMaxKey() {
        if (tail == head)
            return ""; // No nodes exist
        return tail.list.get(0); // Return any string from the list
    }

    public String getMinKey() {
        if (head.next == null)
            return ""; // No nodes exist
        return head.next.list.get(0); // Return any string from the list
    }

    // Adding a node after the previous node
    private void addNode(Node prev, int cnt) {
        Node newNode = new Node(cnt);
        newNode.next = prev.next;
        newNode.prev = prev;

        if (prev.next != null) {
            prev.next.prev = newNode; // Connect the next node's prev to new node
        }
        prev.next = newNode;

        if (prev == tail) {
            tail = newNode; // Update tail if needed
        }
    }

    private void removeNode(Node currNode) {
        if (currNode.prev != null) {
            currNode.prev.next = currNode.next;
        }
        if (currNode.next != null) {
            currNode.next.prev = currNode.prev;
        }
        if (tail == currNode) {
            tail = currNode.prev; // Update tail if needed
        }
        // Clear the currNode references (optional for garbage collection)
        currNode.prev = null;
        currNode.next = null;
    }
}
