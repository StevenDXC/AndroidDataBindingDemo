package com.dx.databindingdemo.viewmodel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.dx.databindingdemo.data.RepoEvent;
import com.dx.databindingdemo.data.api.RetrofitClient;
import com.dx.databindingdemo.model.RepoListModel;
import com.hwangjr.rxbus.RxBus;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class MainViewModel {

    public ObservableInt loading;
    public ObservableInt progressBarVisible;
    public ObservableInt retryBtnVisible;
    public ObservableField<String> message;

    public MainViewModel(){
        getRepos();
        loading = new ObservableInt(View.VISIBLE);
        progressBarVisible = new ObservableInt(View.VISIBLE);
        retryBtnVisible = new ObservableInt(View.INVISIBLE);
        message = new ObservableField<>("loading...");
    }

    private void getRepos(){
        new RetrofitClient().getAPIService().listRepos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<RepoListModel>>() {
                    @Override
                    public void call(List<RepoListModel> repoListModels) {
                        loading.set(View.GONE);
                        progressBarVisible.set(View.INVISIBLE);
                        RepoEvent event = new RepoEvent();
                        event.repoList = repoListModels;
                        RxBus.get().post(event);

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        progressBarVisible.set(View.INVISIBLE);
                        retryBtnVisible.set(View.VISIBLE);
                        message.set(throwable.getMessage());
                    }
                });
    }

    public void onRetry(View view){
        progressBarVisible.set(View.VISIBLE);
        retryBtnVisible.set(View.INVISIBLE);
        message.set("loading...");
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                getRepos();
            }
        },3000);

    }

}
