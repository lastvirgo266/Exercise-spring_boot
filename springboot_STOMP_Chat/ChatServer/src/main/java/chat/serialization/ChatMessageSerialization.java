//package chat.serialization;
//
//import java.nio.ByteBuffer;
//import java.util.Map;
//
//import org.apache.kafka.common.serialization.Serializer;
//import org.apache.kafka.common.errors.SerializationException;
//
//
//import chat.VO.ChatMessage;
//
//public class ChatMessageSerialization implements Serializer<ChatMessage>{
//	
//	private String encoding = "UTF8";
//	
//	
//	@Override
//	public void configure(Map<String, ?> configs, boolean isKey) {
//		
//	}
//	
//	@Override
//	public byte[] serialize(String topic, ChatMessage message) {
//		int sizeOfType;
//		int sizeOfRoomId;
//		int sizeOfSender;
//		int sizeOfMessage;
//		
//		byte[] serializedType;
//		byte[] serializedRoomid;
//		byte[] serializedSender;
//		byte[] serializedMessage;
//		
//		try{
//			if(message == null)
//				return null;
//			
//			serializedType = message.getType().name().getBytes(encoding);
//			sizeOfType = serializedType.length;
//			
//			serializedRoomid = message.getRoomId().getBytes(encoding);
//			sizeOfRoomId = serializedRoomid.length;
//			
//			serializedSender = message.getSender().getBytes(encoding);
//			sizeOfSender = serializedSender.length;
//			
//			serializedMessage = message.getMessage().getBytes(encoding);
//			sizeOfMessage = serializedMessage.length;
//			
//			ByteBuffer buf = ByteBuffer.allocate(4 + sizeOfType + 4 + sizeOfRoomId+ 4 +sizeOfSender+ 4 +sizeOfMessage);
//			buf.putInt(sizeOfType);
//			buf.put(serializedType);
//			buf.putInt(sizeOfRoomId);
//			buf.put(serializedRoomid);
//			buf.putInt(sizeOfSender);
//			buf.put(serializedSender);
//			buf.putInt(sizeOfMessage);
//			buf.put(serializedMessage);
//			
//			return buf.array();
//			
//		}catch (Exception e) {
//            throw new SerializationException("Error when serializing Supplier to byte[]");
//        }
//	}
//	
//    @Override
//    public void close() {
//    }
//
//}
