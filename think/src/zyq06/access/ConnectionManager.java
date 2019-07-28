package zyq06.access;

class Connection{
    private Connection() {}
    public static Connection makeConnection(){
        System.out.println("make a new Connection!!!");
        return new Connection();
    }
}

/**
 * 静态方法获取对象
 */
public class ConnectionManager {
    public static void main(String[] args){
        System.out.println("make 5 connections");
        Connection[] connections = new Connection[5];
        for (int i = 0;i < connections.length; i++){
            connections[i] = Connection.makeConnection();
        }
    }
}
