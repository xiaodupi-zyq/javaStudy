package leetCode;

import java.util.Stack;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 是否为出栈顺序
 * @Date: Created in 20:28 2020/1/13
 * @Modified By:
 */
public class PopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int k = 0;
        for(int i = 0; i < pushA.length; i++){
            int a = pushA[i];
            stack.push(pushA[i]);
            if(stack.peek() == popA[k]){
                stack.pop();
                k++;
            }
        }

        while(!stack.empty() && stack.peek() == popA[k]){
            stack.pop();
            k++;
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        int [] a = {1,2,3,4,5};
        int [] b = {4,5,3,2,1};
        PopOrder popOrder = new PopOrder();
        System.out.println(popOrder.IsPopOrder(a,b));
    }
}
