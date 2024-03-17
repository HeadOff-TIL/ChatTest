package org.example.chattest.util;

public class ChatMessageDTO {
    private String content;
    private String sender;

    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }
}
