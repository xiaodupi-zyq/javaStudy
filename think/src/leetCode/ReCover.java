package leetCode;

/**
 * 使用小矩形覆盖大矩形
 */
public class ReCover {
    public int RectCover(int target) {
        //此处0有意义
        if(target <= 2){
            return target;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }
    public static void main(String[] args){
        ReCover reCover = new ReCover();
        for(int i = 1; i < 6; i++){
            System.out.println(reCover.RectCover(i));
        }
    }
}
