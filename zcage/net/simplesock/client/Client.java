package com.zcage.net.simplesock.client;

import java.io.*;
import java.net.*;
/**
 * Very simple socket server client example written as static methods for simplicity
 * in adding to an existing project.
 */
public class Client {

    public static String sendString(String request) {
    	return sendString("localhost", 14444, request);
    }
    public static String sendString(String server, int port, String request) {
    	return (String) send(server, port, (Object) request);
    }
    public static Object send(String server, int port, Object request) {
    	Object response;

        try {
            Socket socket = new Socket(server, port);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            out.writeObject(request);
            out.flush();

            response = in.readObject();
            
            out.close();
            in.close();
            socket.close();
        } 
        catch (Exception e) {
        	throw new RuntimeException(e);
        }        
        return response;
    }
}
