package com.dx.databindingdemo.viewmodel;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.dx.databindingdemo.model.RepoListModel;
import com.dx.databindingdemo.ui.activity.RepoActivity;


public class RepoListViewModel extends BaseObservable{

    private RepoListModel repoListModel;

    public RepoListViewModel(RepoListModel repoListModel){
        this.repoListModel = repoListModel;
    }

    public String getName(){
        return repoListModel.name;
    }

    public String getDescription(){
        return repoListModel.description;
    }

    public void onItemClick(View view){

        Intent intent = new Intent(view.getContext(), RepoActivity.class);
        intent.putExtra("url",repoListModel.html_url);
        view.getContext().startActivity(intent);

    }

    public void setRepoListModel(RepoListModel repoListModel) {
        this.repoListModel = repoListModel;
        notifyChange();
    }

}
