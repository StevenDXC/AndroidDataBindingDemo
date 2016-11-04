package com.dx.databindingdemo.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.dx.databindingdemo.R;
import com.dx.databindingdemo.adapter.RepoListAdapter;
import com.dx.databindingdemo.data.RepoEvent;
import com.dx.databindingdemo.databinding.ActivityMainBinding;
import com.dx.databindingdemo.ui.LinearLayoutColorDivider;
import com.dx.databindingdemo.viewmodel.MainViewModel;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(dataBinding.toolbar);

        dataBinding.listRepo.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        dataBinding.listRepo.addItemDecoration(new LinearLayoutColorDivider(getResources(),0xffcccccc,R.dimen.default_divider_size,LinearLayoutManager.VERTICAL));
        dataBinding.listRepo.setAdapter(new RepoListAdapter());

        MainViewModel viewModel = new MainViewModel();
        dataBinding.setMainViewModel(viewModel);

        RxBus.get().register(this);
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        RxBus.get().unregister(this);
    }

    @Subscribe
    public void onEvent(RepoEvent event){
        if(event.repoList != null){
            RepoListAdapter adapter = (RepoListAdapter)dataBinding.listRepo.getAdapter();
            adapter.setRepoList(event.repoList);
        }
    }
}
