package LeetCode;

public class ReverseSen {
    public String ReverseSentence(String str) {
        if(str.equals("") || str == null){
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.reverse();
        System.out.println(stringBuffer.toString());
        int start = 0;
        int end = 0;
        for(int i = 0; i < stringBuffer.length(); i++){
            if(stringBuffer.charAt(i) == ' ' || i == stringBuffer.length()-1){
                if(i == stringBuffer.length()-1){
                    end = i+1;
                }else{
                    end = i;
                }
                String tmp = new StringBuffer(stringBuffer.substring(start,end)).reverse().toString();
                stringBuffer.replace(start,end,tmp);
                start = end+1;
            }
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args){
        String str = "  ";
        String result = new ReverseSen().ReverseSentence(str);
        System.out.println(result);

    }
}
