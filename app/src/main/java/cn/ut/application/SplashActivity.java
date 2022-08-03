package cn.ut.application;

import android.content.Intent;
import android.os.Handler;

import cn.ut.application.ui.HomePageActivity;
import cn.ut.application.ui.LoginActivity;
import cn.ut.application.ui.base.BaseActivity;
import cn.ut.application.util.StringUtils;

public class SplashActivity extends BaseActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        String token = getStringFromSp("token");
        if (!StringUtils.isEmpty(token)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    navigateTo(HomePageActivity.class);
                    SplashActivity.this.finish();
                }
            }, SPLASH_DISPLAY_LENGTH);
        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    navigateTo(LoginActivity.class);
                    SplashActivity.this.finish(); //关闭splashActivity,将其回收，防止按返回键进入到该页面
                }
            }, SPLASH_DISPLAY_LENGTH);
        }



    }
}