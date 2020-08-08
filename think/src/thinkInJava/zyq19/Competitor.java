package thinkInJava.zyq19;

public interface Competitor<T extends Competitor<T>> {
    OutCome compete(T competitor);
}
