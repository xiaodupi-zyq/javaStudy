package thinkInJava.zyq19;
import static thinkInJava.zyq19.OutCome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW,LOSE,WIN),
    SCISSORS(WIN,DRAW,LOSE),
    ROCK(LOSE,WIN,DRAW);
    private OutCome vPARER,vSCISSORS,vROCK;
    //constructor
    RoShamBo2(OutCome paper,OutCome scissors,OutCome rock){
        this.vPARER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }
    public OutCome compete(RoShamBo2 it){
        switch (it) {
            default:
            case PAPER: return vPARER;
            case SCISSORS: return vSCISSORS;
            case ROCK:return vROCK;
        }
    }
    public static void main(String[] args){
        RoShamBo.play(RoShamBo2.class,20);
    }

}

class RoShamBo {
    public static <T extends Competitor<T>> void match(T a,T b){
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }
    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass,int size) {
        for(int i = 0; i < size; i++){
            match(Enums.random(rsbClass),Enums.random(rsbClass));
        }
    }
}