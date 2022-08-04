package cn.ut.application.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import cn.ut.application.R;
import cn.ut.application.adapter.HomeAdapter;
import cn.ut.application.ui.base.BaseFragment;
import cn.ut.application.view.FixedViewPage;

public class HomeFragment extends Fragment {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    private SlidingTabLayout slidingTabLayout;

    private FixedViewPage viewPage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        slidingTabLayout = v.findViewById(R.id.slidingTabLayout);
        viewPage = v.findViewById(R.id.fixedViewPage);
        return v;
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (String title : mTitles) {
            mFragments.add(VideoFragment.newInstance(title));
        }
        viewPage.setOffscreenPageLimit(mFragments.size());
        viewPage.setAdapter(new HomeAdapter(getFragmentManager(), mTitles, mFragments));
        slidingTabLayout.setViewPager(viewPage);
    }
}