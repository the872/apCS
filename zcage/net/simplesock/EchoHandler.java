package com.zcage.net.simplesock;
/**
 * Just echo back the message that you receive. This Handler could be used
 * for testing that a communication channel is up and running.
 * 
 * @author Eric Elfner
 */
public class EchoHandler implements SimpleSocketHandler {

	public Object handleSimpleSocketRequest(Object message) {
		return message;
	}
}
