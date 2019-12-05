package algorithm;

public class MyArray {
    private int[] array;
    private int size;
    public MyArray(int capacity){
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 插入数据
     * @param element
     * @param index
     * @throws Exception
     */
    public void insert(int element,int index) throws Exception{
        //判断下标
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标超出范围！");
        }
        //判断容量是否需要扩容
        if(size >= array.length){
            resize();
        }
        for(int i = size - 1; i >= index;i--){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
    }

    /**
     * 扩容方法
     */
    public void resize(){
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
    }

    /**
     * 删除元素
     * @param index
     */
    public int delete(int index) throws Exception{
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标超出范围！");
        }
        int deleteElement = array[index];
        for(int i = index; i < size - 1;i++){
            array[i] = array[i+1];
        }
        size--;
        return deleteElement;
    }

    public void output(){
        for(int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
        System.out.println("size(): " + size);
        System.out.println("array.length(): " + array.length);
    }
    public static void main(String[] args) throws Exception{
        MyArray myArray = new MyArray(4);
        myArray.insert(3,0);
        myArray.insert(7,1);
        myArray.insert(9,2);
        myArray.insert(5,3);
        myArray.output();
        System.out.println();
        myArray.insert(6,1);
        myArray.output();
        System.out.println();
        System.out.println("delete: " + myArray.delete(2));
        myArray.output();
        System.out.println();

    }
}
