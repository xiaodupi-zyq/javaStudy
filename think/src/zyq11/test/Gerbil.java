package zyq11.test;

import java.util.ArrayList;

public class Gerbil {
    private int gerbilNumber;
    Gerbil(int gerbilNumber){
        this.gerbilNumber = gerbilNumber;
    }
    public void hop(){
        System.out.println("number:" + gerbilNumber + " is jumping");
    }
    public static void main(String[] args){
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        gerbils.add(new Gerbil(12));
        gerbils.add(new Gerbil(17));
        gerbils.add(new Gerbil(19));
        gerbils.add(new Gerbil(20));
        gerbils.add(new Gerbil(24));
        gerbils.add(new Gerbil(30));
        for(Gerbil g : gerbils){
            g.hop();
        }
    }
}
