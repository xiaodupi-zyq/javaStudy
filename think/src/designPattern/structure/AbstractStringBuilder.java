package designPattern.structure;

import java.util.Arrays;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 9:57 2020/8/7
 * @Modified By:
 */
public class AbstractStringBuilder {
    protected char[] value;
    protected int count;

    public AbstractStringBuilder(int capacity){
        count = 0;
        value = new char[capacity];
    }

    public AbstractStringBuilder append(char c){
        ensureCapacityInternal(count + 1);
        value[count++] = c;
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity){
        if(minimumCapacity - value.length > 0){
            expandCapacity(minimumCapacity);
        }
    }
    void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if(newCapacity - minimumCapacity < 0){
            newCapacity = minimumCapacity;
        }
        if (newCapacity < 0) {
            if (minimumCapacity < 0) // overflow
                throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
}


//class StringBuilder extends AbstractStringBuilder {
//    public StringBuilder() {
//        super(16);
//    }
//
//    @Override
//    public String toString() {
//        // Create a copy, don't share the array
//        return new String(value, 0, count);
//    }
//}