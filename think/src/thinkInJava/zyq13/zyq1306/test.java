package thinkInJava.zyq13.zyq1306;

import java.util.regex.Pattern;

public class test {
    public static void main(String[] args){
//        String as;
//        for(int i =0 ; i < 4; i++){
//            as = "wegfs";
//        }
//        String s = "怀化南-麻元13.000-322.000";
//        System.out.println("s:" + s);
//        String s3 = s.replaceAll("\\s*","");
//        System.out.println("ss:" + s3);
//        String s1 = s.replaceAll("([0-9]+\\.[0-9]+)[～~—\\-]([0-9]+\\.[0-9]+)","");
//        String s2 = s.replaceAll(s1,"");
//        System.out.println("s1:" + s1);
//        System.out.println("s2:" + s2);
//        System.out.println();
//
//        String sss = "13.000～322.000";
//        System.out.println("sss:"+sss.replaceAll("[K\\+\\.]","").replaceAll("[～~—\\-]","-"));
//        if (Pattern.matches("([0-9]+\\.[0-9]+)[～~—\\-]([0-9]+\\.[0-9]+)", sss)) {
//            System.out.println(sss.replaceAll("[K\\+\\.]","").replaceAll("[～~—\\-]","-"));
//        }
//
//        System.out.println();
//
//
//        if(!(Pattern.matches("([\\u4E00-\\u9FA5A-Za-z0-9]+)[～~—\\-]([\\u4E00-\\u9FA5A-Za-z0-9]+)([A-Z]*K[0-9]+\\+[0-9]+)[～~—\\-]([A-Z]*K[0-9]+\\+[0-9]+)",s))){
//            System.out.println(s);
//        }else
//        {
//            System.out.println("no");
//        }
        String ss1 = " ";
        if((Pattern.matches("[零一二三四五六七八九十百千万亿]+",ss1))){
            System.out.println(ss1);
        }else
        {
            System.out.println("no");
        }
    }
}
