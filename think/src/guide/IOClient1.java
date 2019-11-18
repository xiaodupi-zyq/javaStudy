package guide;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IOClient1 {
    public static void main(String[] args){

        new Thread(() -> {
            try{
                Socket socket = new Socket("127.0.0.1",3333);
                while (true) {
                    try{
                        socket.getOutputStream().write((new Date() + ": hello world1").getBytes());
                        Thread.sleep(3000);
                    }catch (Exception e){

                    }
                }
            }catch (IOException e){

            }
        }).start();
    }
}
