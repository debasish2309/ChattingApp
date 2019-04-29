package com.example.chattingapp.Model;

public class User {
    private String id;
    private String username;
    private String ImageURL;

    public User() {
    }

    public User(String id, String username, String imageURL) {
        this.id = id;
        this.username = username;
        this.ImageURL = imageURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }
}
