package chat.serialization;


import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import chat.VO.ChatMessage;

public class ChatMessageMapperSerialization implements Serializer<ChatMessage> {
	
	  @Override
	  public void close() {

	  }

	  @Override
	  public void configure(Map<String, ?> arg0, boolean arg1) {

	  }

	  @Override
	  public byte[] serialize(String arg0, ChatMessage arg1) {
	    byte[] retVal = null;
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	      retVal = objectMapper.writeValueAsString(arg1).getBytes();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return retVal;
	  }
	

}
