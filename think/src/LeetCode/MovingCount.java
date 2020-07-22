package LeetCode;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 21:23 2020/2/26
 * @Modified By:
 */
public class MovingCount {
    boolean[][] visited;
    public int movingCount(int threshold, int rows, int cols)
    {
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                visited[i][j] = false;
            }
        }
        mark(threshold,0,0,rows,cols);
        int count = 0;
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    public void mark(int threshold,int rnum,int cnum,int rows,int cols){
        int sum = 0;
        int r = rnum;
        int c = cnum;
        while(r > 0){
            sum += (r % 10);
            r = r / 10;
        }
        while(c > 0){
            sum += (c % 10);
            c = c / 10;
        }
        if(rnum < 0 || cnum < 0 || rnum >= rows || cnum >= cols || sum > threshold || visited[rnum][cnum]){
            return;
        }
        visited[rnum][cnum] = true;
        mark(threshold,rnum+1,cnum,rows,cols);
        mark(threshold,rnum,cnum+1,rows,cols);
        mark(threshold,rnum-1,cnum,rows,cols);
        mark(threshold,rnum,cnum-1,rows,cols);
    }
    public static void main(String[] args){
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(15,20,20));
    }
}
