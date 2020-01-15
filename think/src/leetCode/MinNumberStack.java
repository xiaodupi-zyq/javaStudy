package leetCode;

import java.util.Stack;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 可以在O(1)时间复杂度下的找到min的栈
 * @Date: Created in 11:28 2020/1/10
 * @Modified By:
 */

public class MinNumberStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        if(stack1.empty()){
            stack1.push(node);
            stack2.push(node);
        }else{
            stack1.push(node);
            if(node <= stack2.peek()){
                stack2.push(node);
            }
        }
    }

    public void pop() {
        if(stack1.empty()){
            if(stack2.empty()){
                return;
            }else{
                while(!stack2.empty()){
                    stack2.pop();
                }
            }
        }
        if(stack1.peek() == stack2.peek()){
            stack1.pop();
            stack2.pop();
        }else{
            stack1.pop();
        }

    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

}
