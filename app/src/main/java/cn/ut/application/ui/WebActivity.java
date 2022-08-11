package cn.ut.application.ui;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;

import cn.ut.application.R;
import cn.ut.application.jsbridge.BridgeWebView;
import cn.ut.application.ui.base.BaseActivity;

@SuppressLint("SetJavaScriptEnabled")
public class WebActivity extends BaseActivity {

    private BridgeWebView bridgeWebView;
    private String url;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        bridgeWebView  = find(R.id.bridgeWebView);
    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            url = bundle.getString("url");
        }
        initWebView();
    }

    private void initWebView() {
        WebSettings settings = bridgeWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        bridgeWebView.loadUrl(url);
    }
}