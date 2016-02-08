package com.zcage.net.simplesock;

import java.util.Date;

public class EchoStringHandler implements SimpleSocketHandler {

	public Object handleSimpleSocketRequest(Object message) {
		return "EchoMessageHandler (" + (new Date()).toString() + "): " + message.toString();
	}
}
