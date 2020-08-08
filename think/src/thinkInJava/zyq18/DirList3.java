package thinkInJava.zyq18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
    public static void main(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile("[\\u4E00-\\u9FA5A-Za-z0-9]+\\.iml");
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }else {
            list = path.list();
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }
}
