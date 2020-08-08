package thinkInJava.zyq13.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1310 {
    public static void main(String[] args){
        String[] s = {"^java","\\Breg.*","n.w\\s+h(a|i)s","s?","s+","s{4}","s{1}","s{1,3}"};
        String ss = "Java now has regular expressions";
        for(String regex : s){
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(ss);
            while(m.find()){
                System.out.println(regex+": "+m.group());
            }
        }
    }
}
