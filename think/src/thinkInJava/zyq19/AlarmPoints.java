package thinkInJava.zyq19;

import java.util.EnumSet;

public enum AlarmPoints {
    STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3,
    OFFICE4, BATHROOM, UTILITY, KITCHEN
}
class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class); // Empty set
        points.add(thinkInJava.zyq19.AlarmPoints.BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(thinkInJava.zyq19.AlarmPoints.STAIR1, thinkInJava.zyq19.AlarmPoints.STAIR2, thinkInJava.zyq19.AlarmPoints.KITCHEN));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(thinkInJava.zyq19.AlarmPoints.STAIR1, thinkInJava.zyq19.AlarmPoints.STAIR2, thinkInJava.zyq19.AlarmPoints.KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(thinkInJava.zyq19.AlarmPoints.OFFICE1, thinkInJava.zyq19.AlarmPoints.OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}