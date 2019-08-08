package zyq09.music;

public class Wind extends Instrument {
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
    public String what(){
        return "Wind";
    }
    public void adjust() {
        System.out.println("Adjusting Wind");
    }
}
