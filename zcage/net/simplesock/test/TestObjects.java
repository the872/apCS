package com.zcage.net.simplesock.test;

import java.util.Date;
import java.util.ResourceBundle;

import junit.framework.TestCase;

import com.zcage.net.simplesock.EchoDateHandler;
import com.zcage.net.simplesock.EchoHandler;
import com.zcage.net.simplesock.EchoNullHandler;
import com.zcage.net.simplesock.SimpleSocketServer;
import com.zcage.net.simplesock.client.Client;

public class TestObjects extends TestCase {

    static private int port;
    static private String host;
    static {
        ResourceBundle resources = ResourceBundle.getBundle("com.zcage.net.simplesock.test.TestServer");
        port = 10 + Integer.parseInt(resources.getString("server.port"));
        host = resources.getString("server.host");
    }
    
    public void testEcho() {
    	SimpleSocketServer simpleSocketServer = SimpleSocketServer.startServer(port, new EchoHandler());
        String[] strings = {"Hello", "World"};
        String[] response = (String[]) Client.send(host, port, strings);
        assertTrue(response[0].equals("Hello"));
    	simpleSocketServer.stopServer();
    }
    public void testDate() {
    	SimpleSocketServer simpleSocketServer = SimpleSocketServer.startServer(port, new EchoDateHandler());
        Date serverDate = (Date) Client.send(host, port, (Object) null);
        long halfTripTimeMsec = (new Date()).getTime() - serverDate.getTime();
        System.out.println("Half Trip Time: " + halfTripTimeMsec);
        assertTrue(halfTripTimeMsec >= 0 && halfTripTimeMsec < 1000);
    	simpleSocketServer.stopServer();
    }

    public void testNull() {
    	SimpleSocketServer simpleSocketServer = SimpleSocketServer.startServer(port, new EchoNullHandler());
        Date serverDate = (Date) Client.send(host, port, (Object) null);
        assertTrue(serverDate == null);
    	simpleSocketServer.stopServer();
    }

}
