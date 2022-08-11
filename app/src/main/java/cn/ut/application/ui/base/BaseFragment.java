package cn.ut.application.ui.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

public abstract class BaseFragment extends Fragment {

    protected View contentView;

    private Unbinder unbinder;

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(getLayoutId(), container, false);
        initView();
        initData();
        unbinder = ButterKnife.bind(this, contentView);
        return contentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected <T extends View> T find(@IdRes int id) {
        return contentView.findViewById(id);
    }

    protected void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void showToastSync(String msg) {
        Looper.prepare();
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    protected void navigateTo(Class cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

    protected void navigateToWithBundle(Class cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void navigateToWithFlag(Class cls, int flags){
        Intent intent = new Intent(getActivity(), cls);
        intent.setFlags(flags);
        startActivity(intent);
    }

    protected void saveStringToSp(String key, String value) {
        SharedPreferences sp = getActivity().getSharedPreferences("sp_ut", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    protected void removeByKey(String key){
        SharedPreferences sp = getActivity().getSharedPreferences("sp_ut", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove("token");
        edit.commit();
    }

    protected String getStringFromSp(String key) {
        SharedPreferences sp = getActivity().getSharedPreferences("sp_ut", MODE_PRIVATE);
        return sp.getString(key, "");

    }

}
