package thinkInJava.zyq19;

public enum SpaceShip {
    SCOUT,CARGO,TRANSPORT,CRUISER,BATTLESHIP,MOTHERSHIP;
    public String toString(){
        String id = name();
        String lower = id.substring(1).toLowerCase();
//        System.out.println(lower);
        return id.charAt(0) + lower;
    }
    public static void main(String[] args){
        for(SpaceShip s : values()){
            System.out.println(s);
        }
    }
}
