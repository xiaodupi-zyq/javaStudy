package zyq13.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1311 {
    public static void main(String[] args){
        String s = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        String ss = "Arline ate eight apples and one orange while Anita hadn't any";
        Pattern p = Pattern.compile(s);
        Matcher m = p.matcher(ss);
        while(m.find()){
            System.out.println(m.group());
        }
    }
}
