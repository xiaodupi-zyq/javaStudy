package zyq07;

class Soap {
    private String s;
    public Soap() {
        s = "constructru";
    }
    public String toString(){
        return s;
    }
}

public class Bath {
    private Soap soap;
    public String toString(){
        if (soap == null){
            soap = new Soap();
        }
        return "s=" + soap;
    }
    public static void main(String [] args){
        Bath bath = new Bath();
        System.out.println(bath);
    }
}
