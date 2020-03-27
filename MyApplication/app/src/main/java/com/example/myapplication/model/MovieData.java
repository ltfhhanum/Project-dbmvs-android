package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

public class MovieData {
    @SerializedName("id")
    public int id;
    @SerializedName("original_title")
    public String original_title;
    @SerializedName("poster_path")
    public String poster_path;
    @SerializedName("adult")
    public boolean adult;
    @SerializedName("overview")
    public String overview;
    @SerializedName("release_date")
    public String release_date;
    @SerializedName("genre_ids")
    public List<Integer> genre_ids;
    @SerializedName("original_language")
    public String original_language;
    @SerializedName("title")
    public String title;
    @SerializedName("backdrop_path")
    public String backdrop_path;
    @SerializedName("popularity")
    public double popularity;
    @SerializedName("vote_count")
    public int vote_count;
    @SerializedName("video")
    public boolean video;
    @SerializedName("vote_average")
    public double vote_average;

    public MovieData(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public int getVote_count() {
        return vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVote_average() {
        return vote_average;
    }
}
