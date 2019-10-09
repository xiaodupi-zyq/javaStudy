package zyq15.test;

import java.io.*;

public class Iofile {
    public static void main(String[] args) throws IOException {
        //读取文件(字节流)
        InputStream in = new FileInputStream("C:\\Users\\Agilephotonics\\Desktop\\ShiXiaJiang\\CB-105-3-09-009-3-V1.0.btf");
        //读取数据
        //一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        //循环取出数据
        while ((n = in.read(bytes,0,bytes.length)) != -1) {
            //转换成字符串
            String str = new String(bytes,0,n,"GBK"); //这里可以实现字节到字符串的转换，比较实用
            System.out.println(str);
        }
        //关闭流
        in.close();
    }
}
