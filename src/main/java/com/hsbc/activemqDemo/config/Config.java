package com.hsbc.activemqDemo.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {
	@Value("${activeMq.broker-url}")
	public String mqBrokerUrl;
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("MyQueue1.queue");
	}
	@Bean
	public ActiveMQConnectionFactory mqConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(mqBrokerUrl);
	return	activeMQConnectionFactory;
	}
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(mqConnectionFactory());
	}
}
