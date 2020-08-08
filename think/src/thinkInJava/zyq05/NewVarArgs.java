package thinkInJava.zyq05;

public class NewVarArgs {
    static void printArray(Object...args) {//...代表可变参数
        for (Object obj : args) {
            System.out.println(obj + " ");
        }
        System.out.println();
    }
    public static  void main(String[] args) {
        printArray(new Integer(47),new Float(3.14),new Double(11.11));
        printArray();

    }

}
