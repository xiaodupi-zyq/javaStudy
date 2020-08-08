package thinkInJava.zyq07;

public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls = new SpaceShipControls();
    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    public void back(int velocity) {
        controls.back(velocity);
    }
    public void up(int velocity) {
        controls.up(velocity);
    }
    public void down(int velocity) {
        controls.down(velocity);
    }
    public void forward(int velocity) {
        controls.forward(velocity);
    }
    public void left(int velocity) {
        controls.left(velocity);
    }
    public void right(int velocity) {
        controls.right(velocity);
    }
    public static void main(String[] args){
        SpaceShipDelegation protector = new SpaceShipDelegation("NASA protector");
        protector.forward(1000);
    }
}
