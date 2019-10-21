package zyq18;

import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws Exception {
        StringReader in = new StringReader(BufferedInputFile.read("E:\\java学习\\think\\think\\src\\zyq18\\MemoryInput.java"));
        int c;
        while((c = in.read()) != -1){
            System.out.print((char) c);
        }
    }
}
