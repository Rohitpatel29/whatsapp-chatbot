package com.example.whatsappchatbot.controller;

import com.example.whatsappchatbot.model.WebhookRequest;
import com.example.whatsappchatbot.model.WebhookResponse;
import com.example.whatsappchatbot.service.ChatbotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WebhookController {

    private static final Logger log = LoggerFactory.getLogger(WebhookController.class);

    private final ChatbotService chatbotService;

    public WebhookController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping(value = "/webhook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebhookResponse webhook(@RequestBody WebhookRequest request) {
        String incoming = request != null ? request.getMessage() : null;
        log.info("Incoming message: {}", incoming);

        String reply = chatbotService.getReply(incoming);
        return new WebhookResponse(reply);
    }
}
