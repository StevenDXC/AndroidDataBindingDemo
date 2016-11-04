package com.dx.databindingdemo.viewmodel;

import android.databinding.BaseObservable;

/**
 * Created by Miutrip_iMac on 2016/11/4.
 */

public class RepoDetailViewModel extends BaseObservable {

    private String name;


    public RepoDetailViewModel(){
        name = "Loading";
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
        notifyChange();
    }

}
