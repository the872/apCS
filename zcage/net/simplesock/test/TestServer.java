package com.zcage.net.simplesock.test;

import java.util.ResourceBundle;

import com.zcage.net.simplesock.EchoStringHandler;
import com.zcage.net.simplesock.SimpleSocketHandler;
import com.zcage.net.simplesock.SimpleSocketServer;
import com.zcage.net.simplesock.client.Client;

import junit.framework.TestCase;

public class TestServer extends TestCase {

    static private int port;
    static private String host;
    static {
        ResourceBundle resources = ResourceBundle.getBundle("com.zcage.net.simplesock.test.TestServer");
        port = Integer.parseInt(resources.getString("server.port"));
        host = resources.getString("server.host");
    }
    
    private SimpleSocketHandler simpleSocketHandler = new EchoStringHandler(); 
    private SimpleSocketServer simpleSocketServer;
    
    public void setUp() throws Exception {
        
        simpleSocketServer = SimpleSocketServer.startServer(port, simpleSocketHandler);
        
    }

    public void tearDown() {
        simpleSocketServer.stopServer();
    }

    public void test1() {
        String testString = "Hello";
        String response = Client.sendString(host, port, testString);
        assertTrue(response.indexOf("Hello") > 0);
        Client.sendString("Another String");
    }
    public void test2() {
        String testString = "Hello World\nHow are you?";
        String response = Client.sendString(host, port, testString);
        assertTrue(response.indexOf("Hello") > 0);
        Client.sendString(host, port, "Another String");
    }
    public void test3() {
    	//Force error by starting another server on same port
    	//Server.startServer(port, new EchoStringHandler());
    }

}
