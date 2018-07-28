package com.sourabh.android.androidbasictourguide;

public class BaseRecyclerViewModel {
    private int ImageResource = -1;
    private String title;
    private String details;

    public BaseRecyclerViewModel(int imageResource, String title, String details) {
        ImageResource = imageResource;
        this.title = title;
        this.details = details;
    }

    public BaseRecyclerViewModel(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }
}
