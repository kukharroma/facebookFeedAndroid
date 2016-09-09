
package com.cooksdev.facebookfeedandroid.data.dto.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PostsDataEntity {

    @SerializedName("data")
    @Expose
    private List<PostEntity> data = new ArrayList<>();
    @SerializedName("pagingEntity")
    @Expose
    private PagingEntity pagingEntity;

    /**
     * @return The data
     */
    public List<PostEntity> getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(List<PostEntity> data) {
        this.data = data;
    }

    /**
     * @return The pagingEntity
     */
    public PagingEntity getPagingEntity() {
        return pagingEntity;
    }

    /**
     * @param pagingEntity The pagingEntity
     */
    public void setPagingEntity(PagingEntity pagingEntity) {
        this.pagingEntity = pagingEntity;
    }

}
