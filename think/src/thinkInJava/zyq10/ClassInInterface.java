package thinkInJava.zyq10;

public interface ClassInInterface {
    void howdy();
    //接口中定义嵌套类
    class Test implements ClassInInterface {
        public void howdy() {
            System.out.println("Howdy!");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
