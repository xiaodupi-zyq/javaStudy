package zyq18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) throws Exception {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("E:\\java学习\\think\\think\\src\\zyq18\\FormattedMemoryInput.java").getBytes()));
            while (true){
                System.out.print((char) in.readByte());
            }
        }catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
}
