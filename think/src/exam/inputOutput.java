package exam;


import java.util.*;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 21:34 2020/3/23
 * @Modified By:
 */
public class inputOutput {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] visit = new boolean[n+1];
        for(int i=0;i<n+1;i++)
            visit[i] = false;

        List<List<Integer>> map = new ArrayList<> ();
        for(int i=0;i<=n;i++) {
            List<Integer> lst = new ArrayList<Integer>();
            lst.add(i);
            map.add(lst);
        }
        for(int i=1;i<n;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            List<Integer> lst = map.get(x);
            lst.add(y);
            lst = map.get(y);
            lst.add(x);
        }//graph


        class Element{
            int point;
            int deep;
            Element(int point, int deep){
                this.point = point;
                this.deep = deep;
            }
        }
        Queue<Element> queue = new LinkedList<>();
        Element e = new Element(1,0);
        visit[1] = true;
        int max = 0;
        queue.offer(e);
        while(!queue.isEmpty()) {
            Element temp = queue.poll();
            max=Math.max(max, temp.deep);
            List<Integer> lst = map.get(temp.point);
            for(int i=1;i<lst.size();i++) {
                if(!visit[lst.get(i)]) {
                    visit[lst.get(i)]=true;
                    queue.offer(new Element(lst.get(i),temp.deep+1));
                }
            }
        }
        int distance = 2*((n-1)-max)+max;
        System.out.println(distance);
    }
}

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        int[] res = new int[len - k + 1];
        int l = 0;
        int r = 0;
        while(r < len){
            if(queue.size() < k){
                queue.add(nums[r]);
                r++;
            }
            if(queue.size() == k){
                res[l] = queue.peek();
                queue.remove((Integer) nums[l]);
                l++;
            }
        }
        return res;

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int tmp : nums){
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for(Integer key : map.keySet()){
            queue.offer(key);
            if(queue.size() > k){
                queue.poll();
            }
        }
        List<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll());
        }
        return list;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int r = row - 1;
        int c = 0;
        while(r >= 0 && c < col){
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] > target){
                r--;
            }else{
                c++;
                continue;
            }
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] - nums[i-1] == 1){
                count++;
            }else if(nums[i] - nums[i-1] == 0){
                continue;
            }else{
                if(count > max){
                    max = count;
                }
                count = 1;
            }
        }
        return max < count ? count : max;
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
        stack.push(intervals[0][0]);
        stack.push(intervals[0][1]);
        for(int i = 1; i < intervals.length;i++){
            if(intervals[i][0] == intervals[i-1][0]){
                if(intervals[i][1] > stack.peek()){
                    stack.pop();
                    stack.push(intervals[i][1]);
                }
            }else if(intervals[i][0] <= stack.peek()){
                if(intervals[i][1] > stack.peek()){
                    stack.pop();
                    stack.push(intervals[i][1]);
                }
            }else {
                stack.push(intervals[i][0]);
                stack.push(intervals[i][1]);
            }
        }
        int len = stack.size() / 2;
        int[][] res = new int[len][2];
        ArrayList<Integer> list = new ArrayList<>(stack);
        for(int i = 0; i < len;i++){
            res[i][0] = list.get(0);
            list.remove((Integer) res[i][0]);
            res[i][1] = list.get(0);
            list.remove((Integer) res[i][1]);
        }
        return res;
    }

    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }



    public static void main(String[] args){
        Solution solution = new Solution();

        solution.numSquares(12);

        int[][] intervals = {{1,1},{8,10},{4,6},{5,8},{9,11},{9,11},{7,7},{8,12},{9,10},{4,6},{8,12},{5,9}};
        solution.merge(intervals);


        int[] num1 = {9,1,-3,2,4,8,3,-1,6,-2,-4,7};
        solution.longestConsecutive(num1);

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = solution.maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(res));
        int[] num = {1,1,1,2,2,3};
        solution.topKFrequent(num,2);
        int[][] mat = {{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        solution.searchMatrix(mat,0);

    }
}