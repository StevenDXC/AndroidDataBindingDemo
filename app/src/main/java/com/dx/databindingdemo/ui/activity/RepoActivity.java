package com.dx.databindingdemo.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.dx.databindingdemo.R;
import com.dx.databindingdemo.databinding.RepoLayoutBinding;
import com.dx.databindingdemo.viewmodel.RepoDetailViewModel;


public class RepoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_layout);

        RepoLayoutBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.repo_layout);

        String name = getIntent().getStringExtra("name");
        String url = getIntent().getStringExtra("url");

        RepoDetailViewModel viewModel = new RepoDetailViewModel();
        viewModel.setName(name);
        dataBinding.setViewModel(viewModel);

        setSupportActionBar(dataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        WebView webView = (WebView) findViewById(R.id.web_view);

        final ProgressBar progressBar = new ProgressBar(getApplicationContext(),null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setLayoutParams(new WebView.LayoutParams(WebView.LayoutParams.MATCH_PARENT, 3, 0, 0));
        webView.addView(progressBar);


        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
                if(newProgress >= 100){
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        webView.loadUrl(url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
