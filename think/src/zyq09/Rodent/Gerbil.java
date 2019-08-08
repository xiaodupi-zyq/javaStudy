package zyq09.Rodent;

public class Gerbil implements Rodent{
    @Override
    public void name(){
        System.out.println("Gerbil");
    }
    @Override
    public void live(){
        System.out.println("under the ground");
    }
}
