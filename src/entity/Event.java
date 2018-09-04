package entity;

import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.util.Locale;

public class Event {
    String name;
//    LocalDateTime beginPlan;
    String discription;
    int time;
    boolean status;
    int priority;
    LocalDateTime notificationStart;

    public Event(String name, /*LocalDateTime beginPlan,*/ String discription, int time, boolean status) {
        this.name = name;
//        this.beginPlan = beginPlan;
        this.discription = discription;
        this.time = time;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
//                ", beginPlan=" + beginPlan +
                ", discription='" + discription + '\'' +
                ", time=" + time +
                ", status=" + status +
                ", notificationStart=" + notificationStart +
                '}';
    }
}
