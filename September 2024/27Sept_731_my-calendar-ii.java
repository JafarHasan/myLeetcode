import java.util.*;

class Event {
    int start;
    int end;

    Event(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

class MyCalendarTwo {
    List<Event> overLapEvents;
    List<Event> bookEvents;

    public MyCalendarTwo() {
        overLapEvents = new ArrayList<>();
        bookEvents = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (Event e : overLapEvents) {
            if (isOverLap(e, start, end)) {
                return false;
            }
        }

        for (Event e : bookEvents) {
            if (isOverLap(e, start, end)) {
                overLapEvents.add(getOverlapEvent(e, start, end));
            }
        }
        bookEvents.add(new Event(start, end));
        return true;
    }

    public boolean isOverLap(Event e, int start, int end) {
        return Math.max(e.start, start) < Math.min(e.end, end);
    }

    public Event getOverlapEvent(Event e, int start, int end) {
        return new Event(Math.max(e.start, start), Math.min(e.end, end));
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */