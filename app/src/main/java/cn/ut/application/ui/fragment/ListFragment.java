package cn.ut.application.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.ut.application.R;
import cn.ut.application.adapter.ListAdapter;
import cn.ut.application.adapter.VideoAdapter;
import cn.ut.application.listern.OnItemClickListener;
import cn.ut.application.ui.WebActivity;
import cn.ut.application.ui.base.BaseFragment;


public class ListFragment extends BaseFragment {

    private RecyclerView recyclerView;

    public ListFragment() {

    }


    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();

        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
//        showToast(title);
        recyclerView = find(R.id.list_recyclerView);
        //线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //设置为垂直排列
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            datas.add("title"+i);
        }
        ListAdapter listAdapter = new ListAdapter(getActivity(), datas);
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(String str) {
                showToast(str);
                String url = "https://www.bing.com/";
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                navigateToWithBundle(WebActivity.class, bundle);
            }
        });
    }
}