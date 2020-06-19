package chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import chat.VO.ChatMessage;
import chat.service.KafkaChatSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
public class ChatController {
	
	private static String DEFAULT_TOPIC = "test";
	
	@Autowired
	private KafkaChatSender sender;
	
	
	@MessageMapping("/chat/message")
	public void message(ChatMessage message) {
		
		if(ChatMessage.MessageType.ENTER.equals(message.getType()))
			message.setMessage(message.getSender() + "Incoming");
		
		sender.send(DEFAULT_TOPIC, message);
		//messageingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
		
	}
}
