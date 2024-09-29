package com.wspfeiffer.danvegaai.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chatgpt")
    public String generate(@RequestParam(value = "prompt", defaultValue = "Tell me a dad joke") String message) {

        ChatClient.CallResponseSpec callResponseSpec = chatClient.prompt()
                .user(message).call();
        String test = callResponseSpec.content();

        return test;
    }
}
