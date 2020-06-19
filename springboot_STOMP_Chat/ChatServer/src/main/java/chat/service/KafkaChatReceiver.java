package chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import chat.VO.ChatMessage;

@Service
public class KafkaChatReceiver {
	
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@KafkaListener(id = "main-listener", topics = "test")
	public void receive(ChatMessage message) {
		
		template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
		
	}
	

}
