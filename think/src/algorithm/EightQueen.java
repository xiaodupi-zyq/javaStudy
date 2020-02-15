package algorithm;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 16:05 2020/2/15
 * @Modified By:
 */
public class EightQueen {
    //全局变量，下标代表行，值表示queen存储在那一列
    int[] result = new int[8];

    /**
     *调用方式 cal8queens(0)
     * @param row
     */
    public void cal8queens(int row){
        //8个棋子都放好了
        if(row == 8){
            printQueens(result);
            return ;
        }
        //每一行都有8个方法
        for(int col = 0; col < 8;col++){
            if(isOk(row,col)){ //有些放法不满足要求
                result[row] = col; //第row行的棋子放在了col行
                cal8queens(row+1); //考察下一行
            }
        }
    }

    /**
     * 判断row行棋子放在col列是否合适
     * @param row
     * @param col
     * @return
     */
    public boolean isOk(int row,int col){
        int leftup = col - 1;
        int rightup = col + 1;
        for(int i = row - 1; i >= 0;i--){
            //考察正上方是否合适
            if(result[i] == col){
                return false;
            }
            //考察左上方是否合适
            if(leftup >= 0){
                if(result[i] == leftup){
                    return false;
                }
            }
            //考察右上方是否合适
            if(rightup < 8){
                if(result[i] == rightup){
                    return false;
                }
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    /**
     * 打印
     * @param result
     */
    private void printQueens(int[] result){
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(result[row] == col){
                    System.out.print("Q ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        EightQueen eightQueen = new EightQueen();
        eightQueen.cal8queens(0);
    }
}
