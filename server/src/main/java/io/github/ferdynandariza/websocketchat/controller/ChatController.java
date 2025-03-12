package io.github.ferdynandariza.websocketchat.controller;

import io.github.ferdynandariza.websocketchat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return null;
    }
}
