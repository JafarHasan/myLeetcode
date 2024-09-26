import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int event[] : calendar) {
            // int s1=event[0];
            // int e1=event[1];
            if (event[0] < end && start < event[1])
                return false;
        }
        calendar.add(new int[] { start, end });
        return true;
    }
}

/**
 * Overlapping Example:
 * Event 1:
 * [10,20]
 * Event 2:
 * [15,25]
 * Result: They overlap because both overlap conditions are satisfied.
 * 
 * Non-Overlapping Example:
 * Event 3:
 * [20,30]
 * Event 4:
 * [30,40)
 * Result: They do not overlap because Condition A is satisfied.
 * 
 * 
 */
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */