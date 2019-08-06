package zyq08.music;

class Gita extends Instrument{
    public void play(Note n) {
        System.out.println("Gita.play() " + n);
    }
    public String toString(){
        return "Gita";
    }
    void adjust() {
        System.out.println("Adjusting Gita");
    }
}

public class Music3 {
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll (Instrument[] e){
        for(Instrument i : e)
            tune(i);
    }
    public static void main(String[] args){
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind(),
                new Gita()
        };
        tuneAll(orchestra);
        for(Instrument i : orchestra){
            System.out.println(i.toString());
            i.adjust();
        }

    }
}
