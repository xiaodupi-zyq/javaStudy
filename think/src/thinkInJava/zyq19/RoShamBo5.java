package thinkInJava.zyq19;

import java.util.EnumMap;
import static thinkInJava.zyq19.OutCome.*;

public enum RoShamBo5 implements Competitor<RoShamBo5>{
    PAPER,SCISSORS,ROCK;
    static EnumMap<RoShamBo5,EnumMap<RoShamBo5,OutCome>> table = new EnumMap<>(RoShamBo5.class);
    static {
        for(RoShamBo5 it : RoShamBo5.values())
            table.put(it,new EnumMap<>(RoShamBo5.class));
        initRow(PAPER,DRAW,LOSE,WIN);
        initRow(SCISSORS,WIN,DRAW,LOSE);
        initRow(ROCK,LOSE,WIN,DRAW);

    }
    static void initRow(RoShamBo5 it,OutCome vPAPER,OutCome vSCISSORS,OutCome vROCK){
        EnumMap<RoShamBo5,OutCome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER,vPAPER);
        row.put(RoShamBo5.SCISSORS,vSCISSORS);
        row.put(RoShamBo5.ROCK,vROCK);
    }
    public OutCome compete(RoShamBo5 it){
        return table.get(this).get(it);
    }
    public static void main(String[] args){
        RoShamBo.play(RoShamBo5.class,10);
    }
}