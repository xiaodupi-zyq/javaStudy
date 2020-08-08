package thinkInJava.zyq10.test;

public class Test1018 {
    private static class Car{
        private int wheel = 4;
        public void getWheel() {
            System.out.println(wheel);
        }
    }
    static Car getCar(){
        return new Car();
    }
    public static void main(String[] args){
        Car car = getCar();
        car.getWheel();
    }
}
