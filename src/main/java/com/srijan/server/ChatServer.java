package com.srijan.server;


import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public void chatServer() throws Exception{
        ServerSocket serverSocket = new ServerSocket(2024);
        System.out.println("Chat Server started.");
        Socket socket = serverSocket.accept();
        System.out.println("Chat client is connected.");
        //reading client message
        DataInputStream input = new DataInputStream(socket.getInputStream());
        System.out.println("Client: " + input.readUTF());
        input.close();
        socket.close();
        serverSocket.close();
    }

    public static void main(String[] args){
        ChatServer server = new ChatServer();
        try {
            server.chatServer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
