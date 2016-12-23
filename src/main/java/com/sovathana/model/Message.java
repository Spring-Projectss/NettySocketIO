package com.sovathana.model;

import java.util.UUID;

/**
 * Created by lunsovathana on 12/23/16.
 */
public class Message {
    private String id;
    private String senderName;
    private String text;
    private boolean isOwner;

    public Message(){
        this.id = UUID.randomUUID().toString();
    }

    public Message(String id, String senderName, String text, boolean isOwner) {
        this.id = id;
        this.senderName = senderName;
        this.text = text;
        this.isOwner = isOwner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", senderName='" + senderName + '\'' +
                ", text='" + text + '\'' +
                ", isOwner=" + isOwner +
                '}';
    }
}
