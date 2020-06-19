package practice.service;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import ch.qos.logback.core.db.dialect.MySQLDialect;

import org.springframework.stereotype.Service;





@Service
public class CustomService{
	
	static long leftCount = 0;
	
	public long GetCount() {
		return this.leftCount;
	}
	
	public void MinCount() {
		this.leftCount--;
	}
	
	public void SetCount(long count) {
		this.leftCount = count;
	}
	
	public void CreateQueue(String id) {
		 ConnectionFactory factory = new ConnectionFactory();
		 factory.setHost("localhost");
		 factory.setUsername("username");
		 factory.setPassword("password");
		 
		 
		 try {
		 Connection conn = factory.newConnection();
		 Channel channel = conn.createChannel();
		 
		 channel.exchangeDeclare("spring-boot-exchange", "topic", true);
		 channel.queueDeclare("queue-"+id,false,false,false,null);
		 channel.queueBind("queue-"+id, "spring-boot-exchange", "foo.message."+id);
		 
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }
		 
		
	}
	
	 public void ReceivedMessage(String id) {
		 ConnectionFactory factory = new ConnectionFactory();
		 factory.setHost("localhost");
		 factory.setUsername("username");
		 factory.setPassword("password");
		 
		 
		 try {
			 Connection conn = factory.newConnection();
			 Channel channel = conn.createChannel();
			 channel.queueDeclare("queue-"+id,false,false,false,null);
			 
			 String QUEUE_NAME = "queue-"+id;
		 
			 SetCount(channel.messageCount(QUEUE_NAME));
		 
		 
	        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	        System.out.println(" [*] Waiting for messages.");
	        
	    

	        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
	        	
	            String message = new String(delivery.getBody(), "UTF-8");
	            System.out.println(" [x] Received '" + message + "'" + "Revise" + consumerTag);
	            
	            
	        	if(GetCount() == 0) {
	        		channel.basicCancel(consumerTag);
	        		return;
	        	}
	        	
	        	MinCount();
	            
	        };
	        
	        
	        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { 

	            System.out.println(" [*] MessageCount : " + QUEUE_NAME+"   " + channel.messageCount(QUEUE_NAME));
	        	
	        });
		 
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }
		 
		 
	 }
	
	
}



