package com.srijan.client;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public void chatClient() throws Exception{
        Socket socket = new Socket("localhost",2024);
        Scanner scanner = new Scanner(System.in);
        //writing message to the server
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(scanner.nextLine());
        scanner.close();
        out.close();
        socket.close();
    }

    public static void main(String[] args){
        ChatClient chatClient = new ChatClient();
        try {
            chatClient.chatClient();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
