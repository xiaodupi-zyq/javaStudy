package algorithm;


import java.util.*;

public class Permutations {
    /**
     * int[] a = a = {1,2,3,4};printPermutations(a,4,4)
     * k表示要处理的子数据的数据个数
     */
    public void printPermutations(ArrayList<String> list, int[] data, int n, int k){
        String str = "";
        if(k == 1) {
            for(int i = 0; i < n; ++i){
                System.out.print(data[i] + " ");
                str += data[i];
            }
            list.add(str);
            System.out.println(str);
            System.out.println();
        }

        for(int i = 0; i < k; ++i){
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            printPermutations(list,data,n,k-1);

            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }
    public static void main(String[] args){
        Permutations p = new Permutations();
        int[] a = {1,2,3,4};
        ArrayList<String> list = new ArrayList<>();
        p.printPermutations(list,a,3,4);
        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        String string = "1231";
        System.out.println(string.substring(0,1));


        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Collections.singletonList(1));
        System.out.println(list1);


    }
}


class Solution {
    Map<Integer,String> phoneNum = new HashMap<>();
    {
        phoneNum.put(2,"abc");
        phoneNum.put(3,"def");
        phoneNum.put(4,"ghi");
        phoneNum.put(5,"jkl");
        phoneNum.put(6,"mno");
        phoneNum.put(7,"pqrs");
        phoneNum.put(8,"tuv");
        phoneNum.put(9,"wxyz");
    }

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits.length() != 0){
            trackback("",digits);
        }
        return list;
    }
    public void trackback(String str,String digits){
        if(digits.length() == 0){
            list.add(str);
            return;
        }
        int num = Integer.valueOf(digits.substring(0,1));
        String s = phoneNum.get(num);
        for(int i = 0; i < s.length();i++) {
            str += s.charAt(i);
            trackback(str, digits.substring(1));
            str = str.substring(0,str.length()-1);
        }

    }
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.letterCombinations("23");
        System.out.println(solution.list);
        Queue<Integer> queue = new LinkedList<>();
        queue.poll();
    }
}

//class Solution1 {
//    ArrayList<String> result = new ArrayList<String>();
//    public ArrayList<String> Permutation(String str) {
//        char[] arrayChar = str.toCharArray();
//        if(arrayChar.length == 0){
//            return result;
//        }
//        result = PermutationString(arrayChar,arrayChar.length,arrayChar.length);
//        Collections.sort(result);
//        return result;
//    }
//}