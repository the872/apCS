package com.zcage.net.simplesock.test;

import com.zcage.net.simplesock.EchoStringHandler;
import com.zcage.net.simplesock.SimpleSocketHandler;
import com.zcage.net.simplesock.SimpleSocketServer;
import com.zcage.net.simplesock.client.Client;

import junit.framework.TestCase;

public class VerySimpleTest extends TestCase {

	private SimpleSocketHandler simpleSocketHandler = new EchoStringHandler(); 
    private SimpleSocketServer simpleSocketServer;

    public void setUp() throws Exception {
        
    	simpleSocketServer = SimpleSocketServer.startServer(simpleSocketHandler);
    }

    public void tearDown() {
    	simpleSocketServer.stopServer();
    }

    public void testOne() {
        String testString = "Hello";
        String response = Client.sendString(testString);
        assertTrue(response.indexOf("Hello") > 0);
    }

}
