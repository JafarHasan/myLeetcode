
//USING DOUBLY LL
import java.util.*;
import java.util.ArrayList;

//Using DLL with implementation all methods myself
class MyCircularDeque {
    class Node {
        Node next;
        Node prev;
        int val;

        Node(int val) {
            this.val = val;
        }

    }

    int currSize;
    int maxSize;
    Node head;
    Node tail;

    public MyCircularDeque(int k) {
        this.maxSize = k;
    }

    public boolean insertFront(int value) {
        if (!isFull()) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            currSize++;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (!isFull()) {
            Node newNode = new Node(value);
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = tail.next;
            }

            currSize++;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            if (head == tail) {
                // only one node
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            currSize--;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            if (head == tail) {
                // only one element
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            currSize--;
            return true;
        }
        return false;

    }

    public int getFront() {
        if (!isEmpty()) {
            return head.val;
        }
        return -1;
    }

    public int getRear() {
        if (!isEmpty() || tail != null) {
            return tail.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return maxSize == currSize;
    }
}

// Using ArrayList<>();
class MyCircularDeque2 {
    ArrayList<Integer> cq;
    int k;

    public MyCircularDeque2(int k) {
        cq = new ArrayList<>();
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (!isFull()) {
            cq.add(0, value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (!isFull()) {
            cq.add(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            cq.remove(0);
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            cq.remove(cq.size() - 1);
            return true;
        }
        return false;
    }

    public int getFront() {
        if (!isEmpty()) {
            return cq.get(0);
        }
        return -1;
    }

    public int getRear() {
        if (!isEmpty()) {
            return cq.get(cq.size() - 1);
        }
        return -1;
    }

    public boolean isEmpty() {
        return cq.size() == 0;
    }

    public boolean isFull() {
        return cq.size() == k;
    }
}

// Using singly LL with predefined methods
class MyCircularDeque3 {
    LinkedList<Integer> li;
    int size = 0;

    public MyCircularDeque3(int k) {
        size = k;
        li = new LinkedList<Integer>();
    }

    public boolean insertFront(int value) {
        if (li.size() < size) {
            li.addFirst(value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (li.size() < size) {
            li.addLast(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (li.size() == 0)
            return false;
        li.pollFirst();
        return true;
    }

    public boolean deleteLast() {
        if (li.size() == 0)
            return false;
        li.pollLast();
        return true;
    }

    public int getFront() {
        if (li.size() == 0)
            return -1;
        return li.peekFirst();
    }

    public int getRear() {
        if (li.size() == 0)
            return -1;
        return li.peekLast();
    }

    public boolean isEmpty() {
        if (li.size() == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if (li.size() == size)
            return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */