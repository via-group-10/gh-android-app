package com.example.grinhouseapp.ui.notification;

public class NotificationItem {
    private int imageResource;
    private String d;
    private String h;
    private String v;
    private String desc;

    public NotificationItem(int imgResource, String date, String hour, String value, String description){
        imageResource = imgResource;
        d = date;
        h = hour;
        v = value;
        desc = description;
    }

    public int getnImageResource(){
        return imageResource;
    }

    public String getnDate(){
        return d;
    }

    public String getnHour() {
        return h;
    }

    public String getnValue() {
        return v;
    }

    public String getnDescription() {
        return desc;
    }
}
