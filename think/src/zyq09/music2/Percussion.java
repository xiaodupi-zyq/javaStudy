package zyq09.music2;

public class Percussion implements Instrument,Played{
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }
    public String toString(){
        return "Percussion";
    }
    public void adjust() {
        System.out.println("Adjusting Percussion");
    }
}
