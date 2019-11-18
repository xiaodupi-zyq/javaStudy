package leetCode;

public class test06 {
    public String z(String s,int numRows){
        int len = s.length();
        if(len == 0){
            return s;
        }
        int size = numRows > 1 ? 2 * numRows -2 : 1;
        int l = len % size == 0 ? len / size : len/size+1;
        StringBuffer str = new StringBuffer();
        String[] strings = new String[l];
        for(int i = 0; i < l; i++){
            strings[i] = s.substring(i * size, (i+1)*size > (len-1) ? len : (i+1)*size);
            System.out.println("dd: " + strings[i]);
        }
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < l; j++){
                if(i < strings[j].length()){
                    str.append(strings[j].charAt(i));
                }
                if (i == size - i){
                    continue;
                }
                if(size - i < strings[j].length()) {
                        str.append(strings[j].charAt(size - i));
                    }
                }

        }
        return str.toString();
    }
    public int reverse(int x) {
        if(x == 0){
            return x;
        }
        int flag = 1;
        String s = String.valueOf(x);
        StringBuffer str = new StringBuffer();
//        System.out.println(s);
        if(s.charAt(s.length()-1) == '0'){
            s = s.substring(0,s.length()-1);
//            System.out.println(s);
        }
        if(s.charAt(0) == '-'){
            flag = -1;
            s = s.substring(1);
        }
        for(int i = s.length()-1;i >= 0; i--){
            str.append(s.charAt(i));
        }
//        System.out.println(str.toString());
        int y = flag * Integer.valueOf(str.toString());

        if((-2^31) <= y && y <= (2^31)){
            return y;
        }

        return 0;
    }
    public static void main(String[] args){
        String s = "ABCD";
        int nums = 1;
        test06 t = new test06();
//        System.out.println(t.z(s,nums));
        System.out.println(t.reverse(1534236469));
    }
}
