package com.example.student1.allsaints;

import android.support.annotation.NonNull;

public class Saint implements Comparable {


    private String name;
    private String dob;
    private String dod;
    private float rating = 0f;

    public Saint(String name, String dob, String dod, float rating) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setDod(String dod) {
        this.dod = dod;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getDod() {
        return dod;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }
}
