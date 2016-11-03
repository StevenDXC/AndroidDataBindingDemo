package com.dx.databindingdemo.data.api;

import com.dx.databindingdemo.model.RepoListModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Miutrip_iMac on 2016/10/17.
 */

public interface APIService {


     @GET("users/StevenDXC/repos")
     Observable<List<RepoListModel>> listRepos();


}
