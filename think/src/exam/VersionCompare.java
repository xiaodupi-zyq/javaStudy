package exam;

import java.util.Scanner;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 16:11 2020/7/22
 * @Modified By:
 */
public class VersionCompare {
    public  static boolean versionCompare(String ver1,String ver2){
        String[] v1 = ver1.split("\\.");
        String[] v2 = ver2.split("\\.");
        int len = Math.max(v1.length,v2.length);
        for(int i = 0; i < len; i++){
            int val1 = 0;
            int val2 = 0;
            if(i < v1.length){
                val1 = Integer.parseInt(v1[i]);
            }
            if(i < v2.length){
                val2 = Integer.parseInt(v2[i]);
            }
            if(val2 > val1){
                return true;
            }
        }
        return false;
     }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] versions = new String[n][2];
//        sc.nextLine();
        for(int i = 0; i < n; i++){
            versions[i][0] = sc.next();
            versions[i][1] = sc.next();
        }

        for(int i = 0; i < n; i++){
            System.out.println(versionCompare(versions[i][0],versions[i][1]));
        }
    }
}
