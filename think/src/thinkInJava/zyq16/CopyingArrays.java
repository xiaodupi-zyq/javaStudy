package thinkInJava.zyq16;

import java.util.Arrays;
import java.util.Collections;

public class CopyingArrays {
    public static void main(String[] args){
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i,47);
        Arrays.fill(j,99);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));
        System.arraycopy(i,0,j,0,i.length);
        System.out.println("j = " + Arrays.toString(j));
        int[] k = new int[5];
        Arrays.fill(k,103);
        System.arraycopy(i,0,k,0,k.length);
        System.out.println("k = " + Arrays.toString(k));
        Arrays.fill(k,103);
        System.arraycopy(k,0,i,0,k.length);
        System.out.println("k = " + Arrays.toString(i));
    }
}
class ComparingArrays {
    public static void main(String[] args){
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1,47);
        Arrays.fill(a2,47);
        System.out.println(Arrays.equals(a1,a2));
        a2[3] = 11;
        System.out.println(Arrays.equals(a1,a2));
    }
}

class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;
    public CompType(int i,int j){
        this.i = i;
        this.j = j;
    }
    public String toString(){
        String result = "[i = " + i + ". j = " + j + "]";
        if(count++ % 3 == 0){
            result += "\n";
        }
        return result;
    }
    public int compareTo(CompType rv) {
        return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
    }
    public static void main(String[] args){
        int a = 2;
        int c = 4;
        CompType compType = new CompType(a,c);
        CompType compType1 = new CompType(3,5);
        System.out.println(compType.compareTo(compType1));
    }
}

class StringSorting{
    public static void main(String[] args){
        String[] sa = Generated.array(new String[20],new CountingGenerator.String(5));
        System.out.println("Before : " + Arrays.toString(sa));
        Arrays.sort(sa);
        System.out.println("After : " + Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        System.out.println("Reserve sort : " + Arrays.toString(sa));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println("case-insensitive-order sort : " + Arrays.toString(sa));
    }
}






