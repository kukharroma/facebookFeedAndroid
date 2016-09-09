
package com.cooksdev.facebookfeedandroid.data.dto.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PictureEntity {

    @SerializedName("data")
    @Expose
    private PictureInfoEntity pictureInfoEntity;

    /**
     * @return The pictureInfoEntity
     */
    public PictureInfoEntity getPictureInfoEntity() {
        return pictureInfoEntity;
    }

    /**
     * @param pictureInfoEntity The pictureInfoEntity
     */
    public void setPictureInfoEntity(PictureInfoEntity pictureInfoEntity) {
        this.pictureInfoEntity = pictureInfoEntity;
    }

}
