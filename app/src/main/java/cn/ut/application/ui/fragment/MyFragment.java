package cn.ut.application.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.ut.application.R;
import cn.ut.application.ui.LoginActivity;
import cn.ut.application.ui.base.BaseFragment;


public class MyFragment extends BaseFragment {


    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.logout_btn)
    Button logoutBtn;

    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
    }

    @OnClick({R.id.textView, R.id.logout_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                break;
            case R.id.logout_btn:
                navigateToWithFlag(LoginActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                removeByKey("token");
                break;
        }
    }
}