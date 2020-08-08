package thinkInJava.zyq10.control;

public abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public Event (long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    public void start(){
        eventTime = System.nanoTime() + delayTime;//当前时间＋延迟时间，事件触发时间
    }
    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();
}
