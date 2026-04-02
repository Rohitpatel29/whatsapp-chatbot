package com.example.whatsappchatbot.model;

public class WebhookResponse {

    private String reply;

    public WebhookResponse() {
    }

    public WebhookResponse(String reply) {
        this.reply = reply;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
