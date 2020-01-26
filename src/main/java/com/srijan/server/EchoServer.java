package com.srijan.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoServer
{
    public static void main(String args[]) throws Exception{
        ServerSocket sok = new ServerSocket(2025);
        System.out.println(" Server is Ready To Receive a Message. ");
        System.out.println(" Waiting ..... ");
        Socket so = sok.accept();

        if (so.isConnected() == true) {
            System.out.println(" Client Socket is Connected Succecfully. ");
        }
        DataInputStream in = new DataInputStream(so.getInputStream());
        while(true) {
            String msg = in.readUTF();
            System.out.println(" Client: " + msg);
            DataOutputStream ou = new DataOutputStream(so.getOutputStream());
            ou.writeUTF(msg);
            ou.close();
        }

    }
}

