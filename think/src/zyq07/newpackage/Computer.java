package zyq07.newpackage;

public class Computer {
    private String name;
    private String language;
    protected void coding(String language){
        this.language = language;
//        System.out.println(language);
    }
    public String toString(){
        return name + " " + language;
    }
    public Computer(String name,String language){
        this.name = name;
        this.language = language;
    }
}
