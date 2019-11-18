package guide;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(3333);

        new Thread(() -> {
            while(true) {
                try{
                    //阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
//                    OutputStream outputStream = socket.getOutputStream();
//                    outputStream.write(("success").getBytes());
                    //接收客户端请求之后为每个客户端创建一个新的线程进行链路处理
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            //按照字节流的方式进行读取数据
                            while((len = inputStream.read(data)) != -1){
                                System.out.println(new String(data,0,len));
                            }
                        }catch (IOException e){

                        }
                    }).start();
                }catch (Exception e){

                }
            }
        }).start();
    }
}
