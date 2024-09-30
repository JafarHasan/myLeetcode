import java.util.*;

//4ms running time using Array of maxSize
class CustomStack {
    int[] st;
    int top;
    int maxSize;

    public CustomStack(int maxSize) {
        this.top = -1;
        this.maxSize = maxSize;
        st = new int[maxSize];

    }

    public void push(int x) {
        if (top < st.length - 1) {
            st[++top] = x;
        }
    }

    public int pop() {
        return top > -1 ? st[top--] : -1;

    }

    public void increment(int k, int val) {

        k = Math.min(k, top + 1);
        for (int i = 0; i < k; i++)
            st[i] += val;
    }

}

// 11ms running time using ArrayList
class CustomStack1 {
    List<Integer> st;
    int maxSize;

    public CustomStack1(int maxSize) {
        st = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (!isFull()) {
            st.add(x);
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return st.remove(st.size() - 1);
        }
        return -1;

    }

    public void increment(int k, int val) {
        // if(k>=st.size()){
        // while(k-->0){
        // st.set(k-1,st.get(k-1)+val);
        // }
        // }
        // else{
        // while(k-->0){
        // st.set(k-1,st.get(k-1)+val);
        // }
        // }
        k = Math.min(k, st.size());
        for (int i = 0; i < k; i++)
            st.set(i, st.get(i) + val);
    }

    public boolean isEmpty() {
        return st.size() == 0;
    }

    public boolean isFull() {
        return st.size() == maxSize;
    }
}

// 76ms running time using stack +temp stack for incrementt
class CustomStack2 {
    Stack<Integer> st;
    int maxSize;

    public CustomStack2(int maxSize) {
        st = new Stack<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (!isFull()) {
            st.push(x);
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return st.pop();
        }
        return -1;

    }

    public void increment(int k, int val) {
        Stack<Integer> temp = new Stack<>();
        if (k >= st.size()) {
            while (st.size() > 0) {
                temp.push(st.pop() + val);
            }
            while (temp.size() > 0) {
                st.push(temp.pop());
            }
        }
        // k<st.size()
        else {
            int bottom = st.size() - k;
            while (bottom-- > 0) {
                temp.push(st.pop());
            }

            while (st.size() > 0) {
                temp.push(st.pop() + val);
            }
            while (temp.size() > 0) {
                st.push(temp.pop());
            }
        }

    }

    public boolean isEmpty() {
        return st.size() == 0;
    }

    public boolean isFull() {
        return st.size() == maxSize;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */