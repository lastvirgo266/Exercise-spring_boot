package practice.runner;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Runner implements CommandLineRunner {

    private static final String topicExchange = "spring-boot-exchange";

    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
    	
    	while(true) {
	        System.out.println("Sending message...");
	        String text = "¹»º¸³Ä";
	        rabbitTemplate.convertAndSend(topicExchange, "foo.bar.#", text);
	        rabbitTemplate.convertAndSend(topicExchange, "foo.message.abc", text);
	        try {
	        Thread.sleep(1000L);
	        }catch(Exception e) {
	        	
	        }
    	}
    }

}

