package com.srijan.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ChatServer2 {

    public void chatServer() throws Exception{
        ServerSocket serverSocket = new ServerSocket(2024);
        System.out.println("Chat Server started.");
        Socket socket = serverSocket.accept();
        System.out.println("Chat client is connected.");
        //reading client message
        DataInputStream input = new DataInputStream(socket.getInputStream());

        String str = "";
        String rStr = "";
        Scanner sc = new Scanner(System.in);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while(true){
            //client interaction
            rStr = input.readUTF();
            System.out.println("Client says: " + rStr);
            str = sc.nextLine();
            if (str.equalsIgnoreCase("quit")) {
                break;
            }
            //server interaction
            out.writeUTF(str);
            out.flush();
        }
        sc.close();
        input.close();
        out.close();
        socket.close();
        serverSocket.close();
    }

    public static void main(String[] args){
        ChatServer2 server = new ChatServer2();
        try {
            server.chatServer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
