package thinkInJava.zyq18;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("E:\\java学习\\think\\think\\src\\thinkInJava.zyq18\\FileOutputShortcut.java")));
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s ;
        while((s = in.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
