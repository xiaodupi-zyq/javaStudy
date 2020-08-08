package thinkInJava.zyq10.test;

class Outer1 {
    private String str;
    Outer1(String str){
        this.str = str;
    }
    class Inner {
        public String toString(){
            return str;
        }
    }
    public Inner f(){
        return new Inner();
    }
    public static void main(String [] args){
        Outer1 outer1 = new Outer1("zyq");
        Outer1.Inner inner = outer1.f();
        System.out.println(inner);
    }
}