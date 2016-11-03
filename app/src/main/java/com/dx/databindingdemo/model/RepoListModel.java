package com.dx.databindingdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Miutrip_iMac on 2016/10/17.
 */

public class RepoListModel {

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("stargazers_count")
    public int stargazers_count;


    @SerializedName("watchers_count")
    public int watchers_count;

    @SerializedName("html_url")
    public String html_url;
}
