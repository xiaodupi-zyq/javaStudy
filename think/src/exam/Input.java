package exam;

import java.util.Scanner;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 14:30 2020/6/22
 * @Modified By:
 */
public class Input {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);
        int a = sc.nextInt();
        System.out.print(a);
//        int[][] array = new int[a][2];
//        String strLine;
//        for(int i = 0; i < a && sc.hasNextInt(); i++){
//            array[i][0] = sc.nextInt();
//            array[i][1] = sc.nextInt();
//        }
//        for(int[] tmp : array){
//            for(int t : tmp){
//                System.out.print(t + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        String[] Strarray = new String[a];
        String tmp = sc.nextLine();
        for(int i = 0; i < a ; i++){
            Strarray[i] = sc.nextLine();
        }
        for(String s : Strarray){
            System.out.println(s);
        }
        System.out.println();

    }
}
