package cn.ut.application.ui.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.ut.application.Entity.BaseEntity;
import cn.ut.application.Entity.Token;
import cn.ut.application.Entity.UserInfo;
import cn.ut.application.R;
import cn.ut.application.network.RetrofitClient;
import cn.ut.application.network.service.NetworkService;
import cn.ut.application.ui.LoginActivity;
import cn.ut.application.ui.base.BaseFragment;
import io.reactivex.rxjava3.functions.Consumer;


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

    @Override
    protected void initData() {
//        NetworkService networkService = RetrofitClient.getInstance().getService(NetworkService.class);
//        System.out.println(getStringFromSp("token"));
//        networkService.getUserInfo(getStringFromSp("token")).subscribe(new Consumer<BaseEntity<UserInfo>>() {
//            @Override
//            public void accept(BaseEntity<UserInfo> userInfoBaseEntity) throws Throwable {
//                UserInfo userInfo = userInfoBaseEntity.getObject();
//                showToastSync(userInfo.getNickname());
//            }
//        });
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