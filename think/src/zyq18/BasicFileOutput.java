package zyq18;

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("E:\\java学习\\think\\think\\src\\zyq18\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null){
            out.println(lineCount++ + " : " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
