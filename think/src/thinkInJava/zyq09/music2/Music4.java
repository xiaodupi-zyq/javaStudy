package thinkInJava.zyq09.music2;

public class Music4 {
    static void tune(Played i){
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Played[] e){
        for (Played i : e){
            tune(i);
        }
    }
    public static void main(String[] args){
        Played[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
