package com.example.eziketobenna.bakingapp.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.example.eziketobenna.bakingapp.BR;
import com.example.eziketobenna.bakingapp.R;
import com.example.eziketobenna.bakingapp.utils.GlideApp;
import com.google.gson.annotations.SerializedName;

public class Step extends BaseObservable implements Parcelable {
    @SerializedName("videoURL")
    private String videoURL;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private int id;

    @SerializedName("shortDescription")
    private String shortDescription;

    @SerializedName("thumbnailURL")
    private String thumbnailURL;

    public static final Creator<Step> CREATOR = new Creator<Step>() {
        @Override
        public Step createFromParcel(Parcel in) {
            return new Step(in);
        }

        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };

    public Step() {
    }

    public Step(String videoURL, String description, int id, String shortDescription, String thumbnailURL) {
        this.videoURL = videoURL;
        this.description = description;
        this.id = id;
        this.shortDescription = shortDescription;
        this.thumbnailURL = thumbnailURL;
    }

    protected Step(Parcel in) {
        videoURL = in.readString();
        description = in.readString();
        id = in.readInt();
        shortDescription = in.readString();
        thumbnailURL = in.readString();
    }

    @BindingAdapter({"errorImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        GlideApp.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(view);
    }
    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        notifyPropertyChanged(BR.shortDescription);
    }

    @Bindable
    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
        notifyPropertyChanged(BR.thumbnailURL);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(videoURL);
        dest.writeString(description);
        dest.writeInt(id);
        dest.writeString(shortDescription);
        dest.writeString(thumbnailURL);
    }

    @NonNull
    @Override
    public String toString() {
        return "Step{" +
                "videoURL='" + videoURL + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", shortDescription='" + shortDescription + '\'' +
                ", thumbnailURL='" + thumbnailURL + '\'' +
                '}';
    }
}