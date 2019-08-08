package zyq09.Rodent;

public class Test907 {
    public static void main(String[] args){
        Rodent[] rodent = {
                new Mouse(),
                new Gerbil(),
                new Hamster()
        };
        for (Rodent i : rodent){
            i.name();
            i.live();
        }
    }
}
