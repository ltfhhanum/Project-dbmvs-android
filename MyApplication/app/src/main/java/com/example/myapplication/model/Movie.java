package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Movie extends BaseModel<MovieData>{
    @SerializedName("total_results")
    public int total_results;
    @SerializedName("total_pages")
    public int total_pages;

    public Movie(){

    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
