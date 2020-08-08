package thinkInJava.zyq14.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test1414 {
}

class Part {
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Class<? extends Part>> partFactories = new ArrayList<Class<? extends Part>>();//生成一个class类的list，其中class类型信息继承自part
    static {
//       默认构造函数，创建一个新的list
        partFactories.add(FuelFilter.class);
        partFactories.add(AirFilter.class);
        partFactories.add(CabinAirFilter.class); //创建一个类型信息的list
        partFactories.add(OilFilter.class);
        partFactories.add(FanBelt.class);
        partFactories.add(PowerSteeringBelt.class);
        partFactories.add(GeneratorBelt.class);
    }
    private static Random rand = new Random(47);
    public static Part createRandom() {
        try{
            int n = rand.nextInt(partFactories.size());
            return partFactories.get(n).newInstance(); //需要处理异常
        }catch(InstantiationException e){
            throw new RuntimeException(e);
        }catch(IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }
}

class Filter extends Part{ }

class FuelFilter extends Filter{
    public static class Factory implements thinkInJava.zyq14.Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter {
    public static class Factory implements thinkInJava.zyq14.Factory<AirFilter>{
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
class CabinAirFilter extends Filter {
    public static class Factory implements thinkInJava.zyq14.Factory<CabinAirFilter>{
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}
class OilFilter extends Filter {
    public static class Factory implements thinkInJava.zyq14.Factory<OilFilter>{
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements thinkInJava.zyq14.Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements thinkInJava.zyq14.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements thinkInJava.zyq14.Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

class RegisteredFactories {
    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
            System.out.println(Part.createRandom());
        }
    }
}