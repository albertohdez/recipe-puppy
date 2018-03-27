package com.alberto.recipepuppy.common.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SearchDTO implements Parcelable {
    @SerializedName("title")
    private String title;
    @SerializedName("href")
    private String href;
    @SerializedName("ingredients")
    private String ingredients;
    @SerializedName("thumbnail")
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.href);
        dest.writeString(this.ingredients);
        dest.writeString(this.thumbnail);
    }

    public SearchDTO() {
    }

    protected SearchDTO(Parcel in) {
        this.title = in.readString();
        this.href = in.readString();
        this.ingredients = in.readString();
        this.thumbnail = in.readString();
    }

    public static final Parcelable.Creator<SearchDTO> CREATOR = new Parcelable.Creator<SearchDTO>() {
        @Override
        public SearchDTO createFromParcel(Parcel source) {
            return new SearchDTO(source);
        }

        @Override
        public SearchDTO[] newArray(int size) {
            return new SearchDTO[size];
        }
    };
}
