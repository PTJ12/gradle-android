package cn.ut.application.ui;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

import cn.ut.application.Entity.BaseEntity;
import cn.ut.application.Entity.InsertUser;
import cn.ut.application.R;
import cn.ut.application.network.RetrofitClient;
import cn.ut.application.network.service.NetworkService;
import cn.ut.application.ui.base.BaseActivity;
import cn.ut.application.util.StringUtils;
import io.reactivex.rxjava3.functions.Consumer;

public class RegisterActivity extends BaseActivity {

    private Button btn_register;
    private EditText etAccount;
    private EditText etPassword;
    private EditText etPhone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        btn_register = find(R.id.register_btn);
        etAccount = find(R.id.register_username);
        etPhone = find(R.id.register_phone);
        etPassword = find(R.id.register_password);
    }

    @Override
    protected void initData() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etAccount.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                register(username, phone, password);
            }
        });
    }

    private void register(String username, String phone, String password) {
        System.out.println(username+""+phone+""+password);
        if (StringUtils.isEmpty(username)){
            showToast("输入账号");
            return;
        }
        if (StringUtils.isEmpty(phone)){
            showToast("输入电话号码");
            return;
        }
        if (!Pattern.matches("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", phone)){
            showToast("请输入正确的电话号码");
            return;
        }
        if (StringUtils.isEmpty(password)){
            showToast("输入密码");
            return;
        }
        InsertUser user = new InsertUser();
        user.setUsername(username);
        user.setPhone(Long.parseLong(phone));
        user.setPassword(password);
        NetworkService registerService = RetrofitClient.getInstance().getService(NetworkService.class);
        registerService.insertUser(user).subscribe(new Consumer<BaseEntity>() {
            @Override
            public void accept(BaseEntity baseEntity) throws Throwable {
                Log.i("onSuccess", "登录成功");
                showToastSync("注册成功，请返回登录");
            }
        });
    }

}