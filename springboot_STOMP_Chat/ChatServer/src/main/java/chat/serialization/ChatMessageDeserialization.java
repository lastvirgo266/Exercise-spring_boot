//package chat.serialization;
//
//import java.nio.ByteBuffer;
//import java.util.Map;
//
//import org.apache.kafka.common.errors.SerializationException;
//import org.apache.kafka.common.serialization.Deserializer;
//
//import chat.VO.ChatMessage;
//
//public class ChatMessageDeserialization implements Deserializer<ChatMessage> {
//	
//	private String encoding = "UTF8";
//	
//	public enum MessageType{
//		ENTER, TALK
//	}
//	
//	@Override
//	public void configure(Map<String, ?> configs, boolean isKey) {
//		
//	}
//	
//	@Override
//	public ChatMessage deserialize(String topic, byte[] message) {
//		
//		
//		try {
//			if(message == null){
//				return null;
//			}
//			
//			ByteBuffer buf = ByteBuffer.wrap(message);
//			
//			int sizeOfType = buf.getInt();
//			byte[] typeBytes = new byte[sizeOfType];
//			buf.get(typeBytes);
//			String deserializedType = new String(typeBytes, encoding);
//			
//			int sizeOfRoomId = buf.getInt();
//			byte[] roomIdBytes = new byte[sizeOfRoomId];
//			buf.get(roomIdBytes);
//			String deserializedRoomId = new String(roomIdBytes, encoding);
//			
//			int sizeOfSender = buf.getInt();
//			byte[] senderBytes = new byte[sizeOfSender];
//			buf.get(senderBytes);
//			String deserializedSender = new String(senderBytes, encoding);
//			
//			int sizeOfMessage = buf.getInt();
//			byte[] messageBytes = new byte[sizeOfMessage];
//			buf.get(messageBytes);
//			String deserializedMessage = new String(messageBytes, encoding);
//			
//			
//			
//			return new ChatMessage(deserializedType, deserializedRoomId, deserializedRoomId, deserializedMessage);
//			
//			
//		}catch (Exception e) {
//            throw new SerializationException("Error when deserializing byte[] to Supplier");
//        }
//		
//	}
//	
//    @Override
//    public void close() {
//        // nothing to do
//    }
//	
//	
//}
