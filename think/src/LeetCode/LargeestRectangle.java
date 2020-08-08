package LeetCode;

import java.util.Stack;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 一手pop，peek用的妙的很
 * @Date: Created in 13:42 2020/8/8
 * @Modified By:
 */
public class LargeestRectangle {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxAera = 0;
        for(int i = 0; i < heights.length;i++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                maxAera = Math.max(maxAera,heights[stack.pop()] * (i - stack.peek() -1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            maxAera = Math.max(maxAera,heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        return maxAera;
    }
    public static void main(String[] args){
        LargeestRectangle largeestRectangle = new LargeestRectangle();
        int[] height = {2,1,5,6,2,3};
        System.out.println(largeestRectangle.largestRectangleArea(height));
    }
}
