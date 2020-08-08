package thinkInJava.zyq19;

import java.util.Random;

import static thinkInJava.zyq19.OutCome.*;

interface Item{
    OutCome compete(Item it);
    OutCome eval(Paper p);
    OutCome eval(Scissors s);
    OutCome eval(Rock r);
}

class Paper implements Item{
    public OutCome compete(Item it) {return it.eval(this);}
    public OutCome eval(Paper p) {return DRAW;}
    public OutCome eval(Scissors s){return WIN;}
    public OutCome eval(Rock s){return LOSE;}
    public String toString() {return "paper";}
}

class Scissors implements Item{
    public OutCome compete(Item it) {return it.eval(this);}
    public OutCome eval(Paper p) {return LOSE;}
    public OutCome eval(Scissors s){return DRAW;}
    public OutCome eval(Rock s){return WIN;}
    public String toString() {return "Scissors";}
}

class Rock implements Item{
    public OutCome compete(Item it) {return it.eval(this);}
    public OutCome eval(Paper p) {return WIN;}
    public OutCome eval(Scissors s){return LOSE;}
    public OutCome eval(Rock s){return DRAW;}
    public String toString() {return "Rock";}
}

public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);
    public static Item newItem() {
        switch (rand.nextInt(3)){
            default:
            case 0:return new Scissors();
            case 1:return new Paper();
            case 2:return new Rock();
        }
    }
    public static void match(Item a,Item b){
        System.out.println(a + " vs. " + b + " : " + a.compete(b));
    }
    public static void main(String[] args){
        for(int i = 0; i < SIZE;i++){
            match(newItem(),newItem());
        }
    }
}
