
package com.cooksdev.facebookfeedandroid.data.dto.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostsEntity {

    @SerializedName("posts")
    @Expose
    private PostsDataEntity posts;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * @return The posts
     */
    public PostsDataEntity getPosts() {
        return posts;
    }

    /**
     * @param posts The posts
     */
    public void setPosts(PostsDataEntity posts) {
        this.posts = posts;
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
