package thinkInJava.zyq07;

class Huawei{
    private String name;
    Huawei(String name){
        this.name = name;
        System.out.println(name);
    }
    void changeName(String name){
        this.name = name;
    }

}

public class Test719 {
    private int i;
    private final int j;
    private final Huawei huawei;
    public Test719(){
        j = 9;
       // j = 10; 一旦初始化就不再变化，常量
        huawei = new Huawei("p9");
        //huawei = new Huawei("p20"); 一旦初始化，就不能再变化，引用固定
        huawei.changeName("p20");//固定引用中的数据是可以变化的，数值可以变化


    }
    public Test719(int i){
        this.i = i;
        j = 10;
        huawei = new Huawei("p30");
    }
    public static void main(String[] args){
        new Test719();
        new Test719(30);
    }
}
