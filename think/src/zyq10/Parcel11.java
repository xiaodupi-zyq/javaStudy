package zyq10;

import zyq07.C;

public class Parcel11 {
    private static class ParcelContentd implements Contents{
        private int i = 11;
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }
        public String readLabel() {
            return label;
        }
        public void f(){}
        static class AnotherLevel {
            public static void f(){}
            static int x = 10;
        }
    }
    public static Destination destination(String s){
        return new ParcelDestination(s);
    }
    public static Contents contents(){
        return new ParcelContentd();
    }

    public static void main(String[] args){
        Contents c = contents();
        Destination d = destination("Tasdfd");
    }
}
