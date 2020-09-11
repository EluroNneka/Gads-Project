package com.nneka.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class LSkills implements Parcelable {
    public String name;
    public String skills;
    public String country;
    public String image;

    protected LSkills(Parcel in) {
        name = in.readString();
        skills = in.readString();
        country = in.readString();
        image = in.readString();
    }

    public static final Creator<LSkills> CREATOR = new Creator<LSkills>() {
        @Override
        public LSkills createFromParcel(Parcel in) {
            return new LSkills(in);
        }

        @Override
        public LSkills[] newArray(int size) {
            return new LSkills[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
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

    public LSkills(String name, String skills, String country, String image) {
        this.name = name;
        this.skills = skills;
        this.country = country;
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(skills);
        parcel.writeString(country);
        parcel.writeString(image);
    }
}
