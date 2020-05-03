package com.example.marinero_kj.pojo;

import java.io.Serializable;

public class Sight implements Serializable {

    private String name, description;
    private double latitude, longitude;
    private int image;
    private boolean isTown, isHearted;

    public Sight(String name, String description, boolean isTown){
        this.name=name;
        this.description=description;
        this.isTown=isTown;
        image=-1;
        isHearted=false;
        latitude=-1;
        longitude=-1;
    }

    public Sight(String name, String description, int image, boolean isTown, boolean isHearted){
        this.name=name;
        this.description=description;
        this.isTown=isTown;
        this.isHearted=isHearted;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isTown() {
        return isTown;
    }

    public void setTown(boolean town) {
        isTown = town;
    }

    public boolean isHearted() {
        return isHearted;
    }

    public void setHearted(boolean hearted) {
        isHearted = hearted;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
