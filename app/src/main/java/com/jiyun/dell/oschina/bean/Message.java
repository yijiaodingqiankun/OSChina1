package com.jiyun.dell.oschina.bean;

/**
 * Created by DELL zhanghuirong on 2017/7/17.
 */

public class Message {
    private int img;
    private String message;

    public Message(int img, String message) {
        this.img = img;
        this.message = message;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "img=" + img +
                ", message='" + message + '\'' +
                '}';
    }
}
