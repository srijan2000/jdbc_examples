package com.srijan.server;

import  java.net.*;

public class UdpEchoServer {
    public static void main (String[] args)throws Exception{

        String messageString;

        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte [] receiveBytes = new byte[1024];
        byte[] sendBytes = new byte[1024];
        DatagramPacket serverPacket = new DatagramPacket(receiveBytes,receiveBytes.length);
        serverSocket.receive(serverPacket);
        InetAddress ipAddress = serverPacket.getAddress();
        messageString = new String(serverPacket.getData());
        System.out.println("From client :" + messageString);
        sendBytes = messageString.getBytes();
        DatagramPacket echoPacket = new DatagramPacket(sendBytes,sendBytes.length,ipAddress,serverPacket.getPort());

        serverSocket.send(echoPacket);
    }
}
