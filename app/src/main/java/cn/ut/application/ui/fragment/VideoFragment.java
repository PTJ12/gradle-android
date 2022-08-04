package cn.ut.application.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.ut.application.Entity.Video;
import cn.ut.application.R;
import cn.ut.application.adapter.VideoAdapter;


public class VideoFragment extends Fragment {



    private String title;

    public static VideoFragment newInstance(String title) {
        VideoFragment fragment = new VideoFragment();
        fragment.title = title;
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        //线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //设置为垂直排列
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Video> datas = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Video video = new Video();
            video.setTitle("测试数据-" + i + 1);
            datas.add(video);
        }
        VideoAdapter videoAdapter = new VideoAdapter(getActivity(), datas);
        recyclerView.setAdapter(videoAdapter);
        return v;
    }


}