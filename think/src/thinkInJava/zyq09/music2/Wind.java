package thinkInJava.zyq09.music2;

public class Wind implements Instrument,Played{
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
    public String toString(){
        return "Wind";
    }
    public void adjust() {
        System.out.println("Adjusting Wind");
    }
}
