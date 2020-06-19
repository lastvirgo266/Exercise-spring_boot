package chat.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import chat.VO.ChatMessage;
import chat.VO.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
@Slf4j
public class ChatRoomController {

	private final chat.repository.ChatRoomRepository chatRoomRepository;
	
	@GetMapping("/room")
	public String rooms(Model model) {
		ChatMessage msg = new ChatMessage();
		msg.setMessage("asdsad");
		msg.setRoomId("asdsad");
		msg.setSender("asdasdsa");
		msg.setType("TALK");
		
		log.info(msg.toString());
		
		return "/chat/room";
	}
	
	@GetMapping("/rooms")
	@ResponseBody
	public List<ChatRoom> room(){
		return chatRoomRepository.findAllRoom();
	}
	
	
	//Creat room
	@PostMapping("/room")
	@ResponseBody
	public ChatRoom createRoom(@RequestParam String name) {
		return chatRoomRepository.createChatRoom(name);
	}
	
	@GetMapping("/room/enter/{roomId}")
	public String roomDetail(Model model, @PathVariable String roomId) {
		model.addAttribute("roomId", roomId);
		return "/chat/roomdetail";
	}
	
	@GetMapping("/room/{roomId}")
	@ResponseBody
	public ChatRoom roomInfo(@PathVariable String roomId) {
		return chatRoomRepository.findRoomById(roomId);
	}
	
	
	
}
