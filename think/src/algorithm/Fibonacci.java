package algorithm;

public class Fibonacci {
    private static int getItem(int i){
        if(i == 1) return 1;
        if(i == 2) return 1;
        return getItem(i-1) + getItem(i - 2);
    }
    public static void main(String[] args){
        for(int i = 1; i < 10; i++){
            System.out.print(getItem(i) + " ");
        }
    }
}
