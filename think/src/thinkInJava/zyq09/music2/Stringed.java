package thinkInJava.zyq09.music2;

public class Stringed implements Instrument,Played{
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }
    public String toString(){
        return "Stringed";
    }
    public void adjust() {
        System.out.println("Adjusting Stringed");
    }
}
