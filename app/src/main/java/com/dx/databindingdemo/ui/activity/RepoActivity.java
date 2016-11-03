package com.dx.databindingdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.dx.databindingdemo.R;


public class RepoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repo_layout);

        String url = getIntent().getStringExtra("url");

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
}
