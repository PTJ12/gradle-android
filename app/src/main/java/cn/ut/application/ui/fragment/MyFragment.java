package cn.ut.application.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.ut.application.Entity.BaseEntity;
import cn.ut.application.Entity.UserInfo;
import cn.ut.application.R;
import cn.ut.application.adapter.MyAdapter;
import cn.ut.application.network.RetrofitClient;
import cn.ut.application.network.service.NetworkService;
import cn.ut.application.ui.LoginActivity;
import cn.ut.application.ui.base.BaseFragment;
import io.reactivex.rxjava3.functions.Consumer;


public class MyFragment extends BaseFragment {



    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    private RecyclerView recyclerView;

    private Button btn_logout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        //线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView = find(R.id.my_recyclerView);
        //设置为垂直排列
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        btn_logout = find(R.id.logout_btn);
    }

    @Override
    protected void initData() {

        NetworkService networkService = RetrofitClient.getInstance().getService(NetworkService.class);
        System.out.println(getStringFromSp("token"));
        networkService.getUserInfo(getStringFromSp("token")).subscribe(new Consumer<BaseEntity<UserInfo>>() {
            @Override
            public void accept(BaseEntity<UserInfo> userInfoBaseEntity) throws Throwable {
                UserInfo userInfo = userInfoBaseEntity.getObject();
                if (userInfo != null){
                    List<UserInfo> datas = new ArrayList<>();
                    datas.add(userInfo);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            MyAdapter myAdapter = new MyAdapter(getActivity(), datas);
                            recyclerView.setAdapter(myAdapter);
                        }
                    });

                }

            }
        });

        //退出登录
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToWithFlag(LoginActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                removeByKey("token");
            }
        });
    }



}