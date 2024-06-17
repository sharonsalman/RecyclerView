package com.sharonsalman.recyclerview;

// TVShow.java
public class TVShow {
    private String title;
    private String language;
    private int imageResource;
    private String info; // Additional info about the TV show

    public TVShow(String title, String language, int imageResource, String info) {
        this.title = title;
        this.language = language;
        this.imageResource = imageResource;
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getInfo() {
        return info;
    }
}
