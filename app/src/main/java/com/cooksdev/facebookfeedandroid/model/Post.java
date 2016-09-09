package com.cooksdev.facebookfeedandroid.model;

/**
 * Created by roma on 09.09.16.
 */
public class Post {

    private String created;
    private String message;
    private String pictureUrl;
    private String permanentUrl;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPermanentUrl() {
        return permanentUrl;
    }

    public void setPermanentUrl(String permanentUrl) {
        this.permanentUrl = permanentUrl;
    }
}
