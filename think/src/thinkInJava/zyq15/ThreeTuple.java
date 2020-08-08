package thinkInJava.zyq15;

public class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
    public final C third;
    public ThreeTuple(A a,B b,C c){
        super(a,b);
        third = c;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}

class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> {
    public final D fourth;
    public FourTuple(A a,B b,C c,D d){
        super(a,b,c);
        fourth = d;
    }

    @Override
    public String toString() {
        return "FourTuple{" +
                "third=" + third +
                ", fourth=" + fourth +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
