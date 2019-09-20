package zyq14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//显式创建了list
class Part {
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    static {
//       默认构造函数，创建一个新的list
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory()); //创建一个新的内部类Factory（）
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}



class NullPart extends Part implements Null{

    public final static Part NULL=new NullPart();

    public static class Factory implements zyq14.Factory<NullPart>{

        public NullPart create(){return (NullPart)NULL;}

    }

    public String toString(){return "it's NullPart";}

}

class Filter extends Part{ }

class FuelFilter extends Filter{
    public static class Factory implements zyq14.Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter {
    public static class Factory implements zyq14.Factory<AirFilter>{
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
class CabinAirFilter extends Filter {
    public static class Factory implements zyq14.Factory<CabinAirFilter>{
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}
class OilFilter extends Filter {
    public static class Factory implements zyq14.Factory<OilFilter>{
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements zyq14.Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements zyq14.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements zyq14.Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
            System.out.println(Part.createRandom());
        }
    }
}
