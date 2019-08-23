package zyq10;

public class DotNew {
    public class Inner {}
    public static void main(String[] args){
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();//.new从外部类生成对内部类的直接定义
    }
}
