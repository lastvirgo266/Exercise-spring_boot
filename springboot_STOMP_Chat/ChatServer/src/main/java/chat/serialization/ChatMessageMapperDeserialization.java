package chat.serialization;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import chat.VO.ChatMessage;

public class ChatMessageMapperDeserialization implements Deserializer<ChatMessage> {
	
	  @Override
	  public void close() {

	  }

	  @Override
	  public void configure(Map<String, ?> arg0, boolean arg1) {

	  }

	  @Override
	  public ChatMessage deserialize(String arg0, byte[] arg1) {
	    ObjectMapper mapper = new ObjectMapper();
	    ChatMessage message = null;
	    try {
	      message = mapper.readValue(arg1, ChatMessage.class);
	    } catch (Exception e) {

	      e.printStackTrace();
	    }
	    return message;
	  }
	
	

}
