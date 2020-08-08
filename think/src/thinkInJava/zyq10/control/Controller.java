package thinkInJava.zyq10.control;

import java.util.LinkedList;
import java.util.ListIterator;

public class Controller {
//    private List<Event> eventList = new ArrayList<Event>();
    private LinkedList<Event> eventList = new LinkedList<>();

    public void addEvent(Event c){
        eventList.add(c);
    }
    public void run(){
        ListIterator<Event> iterator = eventList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//        for(Event e : new ArrayList<Event>(eventList)){
//            if(e.ready()){
//                System.out.println(e);
//                e.action();
//                eventList.remove(e);
//            }
//        }
    }
}
