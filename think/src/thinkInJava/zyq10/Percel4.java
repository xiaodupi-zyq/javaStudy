package thinkInJava.zyq10;

public class Percel4 {
    private class PContents implements Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }
    protected class PDestionation implements Destination {
        private String label ;
        private PDestionation(String whereTo){
            label = whereTo;
        }
        public String readLabel() {
            return label;
        }
    }
    public Destination destination (String s){
        return new PDestionation(s);
    }
    public Contents contents() {
        return new PContents();
    }

    public static class TestParcel {
        public static void main(String[] args){
            Percel4 p = new Percel4();
            Contents c = p.contents();
            Destination d = p.destination("Tasmanisa");
        }
    }

}
