package zyq10;

public class Parcel6 {
    private void internalTracking(boolean b){
        if (b){
            class TrackingSlip {
                private String id;
                TrackingSlip(String s){
                    id = s;
                }
                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        //TrackingSlip,超出定义域，无法定义
    }
    public void track(){
        internalTracking(true);
    }
    public static void main(String[] args){
        Parcel6 p = new Parcel6();
        p.track();
    }
}
