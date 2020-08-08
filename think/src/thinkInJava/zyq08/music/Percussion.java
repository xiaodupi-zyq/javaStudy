package thinkInJava.zyq08.music;

public class Percussion extends Instrument {
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }
    public String toString(){
        return "Percussion";
    }
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}
