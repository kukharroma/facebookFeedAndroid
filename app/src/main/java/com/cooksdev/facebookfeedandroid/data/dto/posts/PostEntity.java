
package com.cooksdev.facebookfeedandroid.data.dto.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PostEntity {

    @SerializedName("permalink_url")
    @Expose
    private String permalinkUrl;
    @SerializedName("full_picture")
    @Expose
    private String fullPicture;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("created_time")
    @Expose
    private Date createdTime;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * @return The permalinkUrl
     */
    public String getPermalinkUrl() {
        return permalinkUrl;
    }

    /**
     * @param permalinkUrl The permalink_url
     */
    public void setPermalinkUrl(String permalinkUrl) {
        this.permalinkUrl = permalinkUrl;
    }

    /**
     * @return The fullPicture
     */
    public String getFullPicture() {
        return fullPicture;
    }

    /**
     * @param fullPicture The full_picture
     */
    public void setFullPicture(String fullPicture) {
        this.fullPicture = fullPicture;
    }

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The createdTime
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime The created_time
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

}
