package guide;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IOClient {
    public static void main(String[] args){

        new Thread(() -> {
            try{
                Socket socket = new Socket("127.0.0.1",3333);
//                int len;
//                byte[] data = new byte[1024];
//                InputStream inputStream = socket.getInputStream();
//                while((len = inputStream.read(data)) != -1){
//                    System.out.println(new String(data,0,len));
//                }
                while (true) {
                    try{
                        //向socket发送请求
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);

                    }catch (Exception e){

                    }
                }
            }catch (IOException e){

            }
        }).start();
    }
}
