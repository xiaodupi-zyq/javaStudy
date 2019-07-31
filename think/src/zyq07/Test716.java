package zyq07;

class Amphibian {
    public void moveInWater() {
        System.out.println("Moving in Water");
    }
    public void moveOnLand() {
        System.out.println("Moving on Land");
    }
}

class Frog extends Amphibian {}
class Frog2 extends Amphibian {
    @Override
    public void moveInWater() {
        System.out.println("frog in Water");
    }
    @Override
    public void moveOnLand() {
        System.out.println("frog on Land");
    }
}

class Exercise717 {

    public static void main(String[] args) {
        Amphibian a = new Frog2();
        a.moveInWater();
        a.moveOnLand();
    }
}

public class Test716 {

    public static void main(String[] args) {
        Amphibian a = new Frog();
        a.moveInWater();
        a.moveOnLand();
    }
}

