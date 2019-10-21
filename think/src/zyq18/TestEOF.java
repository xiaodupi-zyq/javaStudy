package zyq18;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class TestEOF {
    public static void main(String[] args) throws Exception{
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("E:\\java学习\\think\\think\\src\\zyq18\\TestEOF.java")));
        while(in.available() != 0){
            System.out.print((char) in.readByte());
        }
    }
}
