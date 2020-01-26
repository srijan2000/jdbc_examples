package com.srijan.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient
{
    public static void main(String args[]) throws Exception
    {

        Socket sok=new Socket("localhost",2025);
        if(sok.isConnected()==true) {
            System.out.println(" Server Socket is Connected Succecfully. ");
        }
        DataOutputStream out = new DataOutputStream(sok.getOutputStream());
        Scanner buf1=new Scanner(System.in);
        System.out.print(" Enter the Message : ");
        String str1=buf1.nextLine();
        out.writeUTF(str1);
        out.flush();

        DataInputStream in = new DataInputStream(sok.getInputStream());
        String str2 = in.readUTF();
        System.out.println(" Server echo: " + str2);

    }
}
