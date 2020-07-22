package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 20:43 2020/2/26
 * @Modified By:
 */
public class HasStrPath {
    boolean[][] visited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix.length < str.length){
            return false;
        }
        char[][] array = new char[rows][cols];
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                array[i][j] = matrix[i*cols + j];
                visited[i][j] = false;
            }
        }
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(find(array,i,j,rows,cols,str,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] array,int rnum,int cnum,int rows,int cols,char[] str,int snum){
        if(snum >= str.length){
            return true;
        }
        if(rnum < 0 || rnum >=rows || cnum < 0|| cnum >= cols || array[rnum][cnum] != str[snum] || visited[rnum][cnum]){
            return false;
        }
        visited[rnum][cnum] = true;
        boolean flag = find(array,rnum+1,cnum,rows,cols,str,snum+1)
                || find(array,rnum,cnum+1,rows,cols,str,snum+1)
                || find(array,rnum-1,cnum,rows,cols,str,snum+1)
                || find(array,rnum,cnum-1,rows,cols,str,snum+1);
        visited[rnum][cnum] = false;
        return flag;
    }

    public static void main(String[] args){
        HasStrPath strPath = new HasStrPath();
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        char[] str = "AAAAAAAAAAAA".toCharArray();
        System.out.println(strPath.hasPath(matrix,3,4,str));
    }
}
