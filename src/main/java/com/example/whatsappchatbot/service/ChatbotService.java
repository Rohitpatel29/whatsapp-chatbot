package com.example.whatsappchatbot.service;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String getReply(String message) {
        if (message == null) {
            return "I didn't understand that";
        }
        return switch (message) {
            case "Hi" -> "Hello";
            case "Bye" -> "Goodbye";
            default -> "I didn't understand that";
        };
    }
}
