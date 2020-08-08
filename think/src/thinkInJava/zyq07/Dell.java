package thinkInJava.zyq07;

import thinkInJava.zyq07.newpackage.Computer;

public class Dell extends Computer {
    private String software;
    public Dell(String name,String language,String software){
        super(name,language);
        this.software = software;
    }
    public void Change(String language){
        coding(language);
    }
    public String toString(){
        return "name and language: " + super.toString() + " softwore: " + software;
    }
    public static void main(String[] args){
        Dell dell = new Dell("zyq","java","IDEA");
        System.out.println(dell);
        dell.Change("python");
        System.out.println(dell);

    }
}
