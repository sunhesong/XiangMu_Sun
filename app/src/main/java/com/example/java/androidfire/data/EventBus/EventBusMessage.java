package com.example.java.androidfire.data.EventBus;

public class EventBusMessage {
    private String img,title,url;

    public EventBusMessage(String img, String title, String url) {
        this.img = img;
        this.title = title;
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
