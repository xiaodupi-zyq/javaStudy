package thinkInJava.zyq08;

class Grain {
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    public String toString() {
        return "Wheet";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args){
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        //这次返回的Wheat类型，是可以认为是一种Grain类型的
        System.out.println(g);
    }
}
