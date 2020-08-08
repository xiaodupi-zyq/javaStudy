package thinkInJava.zyq08.music;

public class Woodwind extends Wind {
    public void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }
    public String toString(){
        return "Woodwind";
    }
}
