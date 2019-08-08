package zyq09.music2;

public interface Instrument {
    int VALUE = 5;
//    public String what(){
//        return "Instrument";
//    }
//    接口中只能有方法声明
    void adjust();
}
interface Played {
    void play(Note n);
}