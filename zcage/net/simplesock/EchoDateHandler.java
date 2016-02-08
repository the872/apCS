package com.zcage.net.simplesock;

import java.util.Date;

public class EchoDateHandler implements SimpleSocketHandler {

	public Object handleSimpleSocketRequest(Object message) {
		return new Date();
	}
}
