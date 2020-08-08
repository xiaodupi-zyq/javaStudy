package thinkInJava.zyq08.music;

public class Music {
    //多态的实现，在同时调用基类的情况下，根据实际不同的导出来调用不同的实际函数
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }
    public static void main(String[] args){
        Wind flute = new Wind();
        tune(flute);
    }
}
