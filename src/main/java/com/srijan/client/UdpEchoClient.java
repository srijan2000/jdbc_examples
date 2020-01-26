package com.srijan.client;
import java.net.*;
import java.io.*;

public class UdpEchoClient{

        public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String messageString;
        String replayString;
        byte[] sendBytes = new byte[1024];
        byte[] receiveBytes = new byte[1024];
        InetAddress ipAddress = InetAddress.getByName("localhost");
        DatagramSocket clientSocket = new DatagramSocket();

        System.out.println("Ente message: ");
        messageString = br.readLine();
        sendBytes = messageString.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBytes, sendBytes.length, ipAddress, 9876);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveBytes, receiveBytes.length);
        clientSocket.receive(receivePacket);
        replayString = new String(receivePacket.getData());
        System.out.println("From Server : " + replayString);

    }
}

