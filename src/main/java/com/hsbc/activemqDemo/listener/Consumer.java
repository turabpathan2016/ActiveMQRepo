package com.hsbc.activemqDemo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
@JmsListener(destination="MyQueue1.queue")
public void consume(final String message) {
	System.out.println("Message:"+message);
}
}
