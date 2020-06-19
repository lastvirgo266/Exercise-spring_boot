package chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import chat.VO.ChatMessage;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaChatSender {
	
	
	@Autowired
	private KafkaTemplate<String, ChatMessage> kafaKaTemplate;
	
	
	public void send(String topic, ChatMessage message) {
		log.info(message.toString());
		kafaKaTemplate.send(topic, message);
	}
	

}
