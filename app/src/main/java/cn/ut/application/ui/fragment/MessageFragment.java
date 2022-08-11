package cn.ut.application.ui.fragment;


import androidx.fragment.app.Fragment;


import cn.ut.application.R;
import cn.ut.application.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessageFragment extends BaseFragment {

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();

        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}