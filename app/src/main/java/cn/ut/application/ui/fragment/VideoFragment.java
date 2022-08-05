package cn.ut.application.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.ut.application.Entity.BaseEntity;
import cn.ut.application.Entity.UserInfo;
import cn.ut.application.Entity.Video;
import cn.ut.application.R;
import cn.ut.application.adapter.VideoAdapter;
import cn.ut.application.network.RetrofitClient;
import cn.ut.application.network.service.NetworkService;
import cn.ut.application.ui.base.BaseFragment;
import io.reactivex.rxjava3.functions.Consumer;

import static android.content.Context.MODE_PRIVATE;


public class VideoFragment extends BaseFragment {


    private String title;

    public static VideoFragment newInstance(String title) {
        VideoFragment fragment = new VideoFragment();
        fragment.title = title;
        return fragment;
    }

    private RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
//        showToast(title);
        recyclerView = find(R.id.recyclerView);
        //线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //设置为垂直排列
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        NetworkService networkService = RetrofitClient.getInstance().getService(NetworkService.class);
        String token = getActivity().getSharedPreferences("sp_ut", MODE_PRIVATE).getString("token", "");
        System.out.println(token);
        networkService.getUserInfo(token).subscribe(new Consumer<BaseEntity<UserInfo>>() {
            @Override
            public void accept(BaseEntity<UserInfo> userInfoBaseEntity) throws Throwable {
                UserInfo userInfo = userInfoBaseEntity.getObject();
                if (userInfo != null) {

                    String username = userInfo.getUsername();


                    List<Video> datas = new ArrayList<>();
                    for (int i = 0; i < 8; i++) {
                        Video video = new Video();
                        video.setTitle(username);
                        datas.add(video);
                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            VideoAdapter videoAdapter = new VideoAdapter(getActivity(), datas);
                            recyclerView.setAdapter(videoAdapter);
                        }
                    });

                }


            }
        });
    }


}