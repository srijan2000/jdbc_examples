package com.srijan.client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String args[])throws  Exception{
        Scanner input =
                new Scanner (System.in);

        DatagramSocket clientSocket = new DatagramSocket();
        while(true) {
            //getting server ip address
            InetAddress ipAddress = InetAddress.getByName("LAPTOP-RSLGB6FG");  //localhost
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            String sentence = input.nextLine();
            if(sentence.equalsIgnoreCase("quit")){
                break;
            }
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 9876);
            clientSocket.send(sendPacket);
            DatagramPacket receivepacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivepacket);
            String modifiedSentence = new String(receivepacket.getData());
            System.out.println("From Server: " + modifiedSentence);
            sendData = null;
            receiveData = null;
        }
        clientSocket.close();
    }
}
