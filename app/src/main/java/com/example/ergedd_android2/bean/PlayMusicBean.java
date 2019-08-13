package com.example.ergedd_android2.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayMusicBean implements Parcelable {
    private String name;
    private String resource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.resource);
    }

    public PlayMusicBean() {
    }

    protected PlayMusicBean(Parcel in) {
        this.name = in.readString();
        this.resource = in.readString();
    }

    public static final Parcelable.Creator<PlayMusicBean> CREATOR = new Parcelable.Creator<PlayMusicBean>() {
        @Override
        public PlayMusicBean createFromParcel(Parcel source) {
            return new PlayMusicBean(source);
        }

        @Override
        public PlayMusicBean[] newArray(int size) {
            return new PlayMusicBean[size];
        }
    };
}
