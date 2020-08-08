package thinkInJava.zyq12.test;

public class Test1203 {
    public static void main(String[] args){
        String[] strings = new String[5];
        try{
            for(int i = 0; i < 6; i++){
                strings[i] = i+"";
            }
        }catch (Exception e){
//            System.out.println(e);//下标索引超出范围
            e.printStackTrace(System.out);
        }

    }
}
