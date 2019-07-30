package zyq07;

/**
 * 实现继承的相关方法，————————继承
 */
/*
class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s+=a; }
    public void dilute() {append(" dilute()");}
    public void apply() {append(" apply()");}
    public void scrub() {append(" scrub()");}
    public String toString() {return s;}
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();x.apply();x.scrub();
        System.out.println(x);
    }
}

public class Detergent extends Cleanser {
    //Change a method
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); //call base-class version
    }
    //add method
    public void foam() {
        append(" foam()");
    }
    public static void main(String[] args){
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }

}

class SuperDetergent extends Detergent{
    public void scrub(){
        append(" SuperDetergent.scrub()");
        super.scrub();
    }
    public void sterilize() {
        append(" sterilize()");
    }
    public static void main(String[] args) {
        SuperDetergent superDetergent = new SuperDetergent();
        superDetergent.dilute();
        superDetergent.scrub();
        superDetergent.apply();
        superDetergent.foam();
        superDetergent.sterilize();
        System.out.println(superDetergent);
    }
}
*/
class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s+=a; }
    public void dilute() {append(" dilute()");}
    public void apply() {append(" apply()");}
    public void scrub() {append(" scrub()");}
    public String toString() {return s;}
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();x.apply();x.scrub();
        System.out.println(x);
    }
}

public class Detergent extends Cleanser {
    private Cleanser cleanser = new Cleanser();
    private String s = "Detergent";
    public void append(String a) {
        cleanser.append(a);
    }
    public void dilute(){
        cleanser.dilute();
    }
    public void apply(){
        cleanser.apply();
    }
    public void scrub(){
        cleanser.scrub();
    }
    public String toString(){
        return cleanser.toString();
    }
    public static void main(String[] args){
        Detergent detergent = new Detergent();
        detergent.dilute();
        detergent.apply();;
        detergent.scrub();
        System.out.println(detergent);
    }

}
