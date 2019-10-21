package zyq18;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedInputFile {
    public static String read(String fileName) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }
    public static void main(String[] args)throws Exception{
        System.out.println(read("E:\\java学习\\think\\think\\src\\zyq18\\BufferedInputFile.java"));
    }
}
