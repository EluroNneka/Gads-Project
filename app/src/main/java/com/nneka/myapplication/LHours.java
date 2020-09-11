package com.nneka.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class LHours implements Parcelable {
    public String name;
    public String hours;
    public String country;
    public String image;

    protected LHours(Parcel in) {
        name = in.readString();
        hours = in.readString();
        country = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(hours);
        dest.writeString(country);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LHours> CREATOR = new Creator<LHours>() {
        @Override
        public LHours createFromParcel(Parcel in) {
            return new LHours(in);
        }

        @Override
        public LHours[] newArray(int size) {
            return new LHours[size];
        }
    };

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void hours(String name, String hours, String country, String image) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
