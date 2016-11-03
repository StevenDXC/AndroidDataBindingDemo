package com.dx.databindingdemo.model;

/**
 * Created by Miutrip_iMac on 2016/10/16.
 */

public class User {

    private String name;
    private String avatarImage;
    private String desc;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }


    public String getAvatarImage(){
        return this.avatarImage;
    }

    public String getDesc(){
        return this.desc;
    }


}
