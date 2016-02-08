package com.zcage.net.simplesock;

import java.net.*;
import java.util.logging.Logger;
import java.io.*;
/*
 * Very simple socket server example. That responds to a single object with
 * another object. The
 */
public class ServerThread extends Thread {

	private Logger jdkLogger = Logger.getLogger(this.getClass().getName());
    private Socket socket = null;
    private SimpleSocketHandler simpleSocketHandler = null;

    public ServerThread(Socket socket, SimpleSocketHandler simpleSocketHandler) {
        this.socket = socket;
        this.simpleSocketHandler = simpleSocketHandler;
    }

    public void run() {
    	jdkLogger.fine("Run");
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            Object input = null;
            Object output = null;

            input = in.readObject();
            jdkLogger.fine(" Input: " + input);

            output = simpleSocketHandler.handleSimpleSocketRequest(input); 
            jdkLogger.fine("Output: " + input);

            out.writeObject(output);
            
            out.close();
            in.close();
            socket.close();
            jdkLogger.fine("Complete");

        } catch (IOException e) {
        	jdkLogger.severe("run() error: " + e.toString());
        } catch (ClassNotFoundException e) {
        	jdkLogger.severe("run() error: " + e.toString());
		}
    }
}
