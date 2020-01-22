package com.srijan.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient2 {

    public void chatClient() throws Exception{
        Socket socket = new Socket("localhost",2024);
        Scanner scanner = new Scanner(System.in);
        //writing message to the server
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF(scanner.nextLine());
        String str = "";
        String rStr = "";
        //read data
        DataInputStream input = new DataInputStream(socket.getInputStream());
        while(true){
            rStr = input.readUTF();
            System.out.println("Server says: " + rStr);
            str = scanner.nextLine();
            if (str.equalsIgnoreCase("quit")) {
                break;
            }
            out.writeUTF(str);
            out.flush();
        }
        scanner.close();
        out.close();
        input.close();
        socket.close();
    }

    public static void main(String[] args){
        ChatClient2 chatClient = new ChatClient2();
        try {
            chatClient.chatClient();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
