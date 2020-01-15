package leetCode;

import java.util.ArrayList;

public class MatrixPrintOut {
    /**
     * 顺时针输出数组
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(up <= down && left <= right){
            for(int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }
            up++;
            for(int i = up; i <= down; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(up <= down && left <= right){
                for(int i = right; i >= left; i--){
                    list.add(matrix[down][i]);
                }
                down--;
                for(int i = down; i >= up; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }
        return list;
    }
    public static void main(String[] args){
        int[][] matrix = {{1},{2},{3},{4}};
        MatrixPrintOut m = new MatrixPrintOut();
        System.out.println(m.printMatrix(matrix));
    }
}
