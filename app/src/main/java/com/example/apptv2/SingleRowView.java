package com.example.apptv2;

import android.graphics.drawable.Drawable;

public class SingleRowView {
    String name = "";
    Drawable image = null;

    public SingleRowView(String name, Drawable image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
