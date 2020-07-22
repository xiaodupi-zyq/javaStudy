package offer;

import java.util.ArrayList;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 21:43 2020/7/10
 * @Modified By:
 */
public class HasPath {
    boolean[][] visited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(str.length == 0){
            return true;
        }
        if(matrix == null || rows == 0){
            return false;
        }
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i * cols + j] == str[0]){
                    if(isHasPath(matrix,rows,cols,i,j,str,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isHasPath(char[] matrix,int rows,int cols,int row, int col, char[] str,int k){
        if(k >= str.length){
            return true;
        }
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || str[k] != matrix[row * cols + col]){
            return false;
        }
        visited[row][col] = true;
        boolean flag = isHasPath(matrix,rows,cols,row - 1,col,str,k+1)
                || isHasPath(matrix,rows,cols,row + 1,col,str,k+1)
                || isHasPath(matrix,rows,cols,row,col - 1,str,k+1)
                || isHasPath(matrix,rows,cols,row,col + 1,str,k+1);
        visited[row][col] = false;
        return flag;
    }
    public static void main(String[] args){
        HasPath hasPath = new HasPath();
        char[] ma = "ABCESFCSADEE".toCharArray() ;
        char[] str = "SEE".toCharArray();
        System.out.println(hasPath.hasPath(ma,3,4,str));
        ArrayList<Integer> list = new ArrayList<>();

    }
}

