package algorithm;

public class MyArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    //初始化
    public MyArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item){
//        if(tail == n) {
//            return false;
//        }
//        items[tail] = item;
//        ++tail;
//        return true;

        //数据搬移的入队操作
        if(tail == n) {
            if(head == 0){
                return  false;
            }
            for(int i = head; i < tail; ++i){
                items[i - head] = items[i];
            }

            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    //出队
    public String dequeue(){
        if(head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }
}
