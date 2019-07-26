package zyq05;

enum Size{
    ONE,TWO,FIVE,TEN
}

public class Money {
    public static void main(String[] args) {
        for (Size size:Size.values()){
            System.out.println(size +" "+ size.ordinal());
        }
        Size money = Size.TEN;
        switch (money){
            case ONE:
                System.out.println("一块");
                break;
            case TWO:
                System.out.println("两块");
                break;
            case FIVE:
                System.out.println("五块");
                break;
            case TEN:
                System.out.println("十块");
                break;
                default:
                    System.out.println("not money");
        }
    }
}
