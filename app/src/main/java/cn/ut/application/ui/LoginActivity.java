package cn.ut.application.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.ut.application.Entity.BaseEntity;
import cn.ut.application.Entity.Token;
import cn.ut.application.R;
import cn.ut.application.network.RetrofitClient;
import cn.ut.application.network.service.NetworkService;
import cn.ut.application.ui.base.BaseActivity;
import cn.ut.application.util.StringUtils;
import io.reactivex.rxjava3.functions.Consumer;

public class LoginActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPassword;
    private Button btnLogin;
    private TextView btnRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        etAccount = find(R.id.login_username);
        etPassword = find(R.id.login_password);
        btnLogin = find(R.id.login_btn);
        btnRegister = find(R.id.register_btn);
    }

    @Override
    protected void initData() {
        btnLogin.setOnClickListener((v) -> {
            String account = etAccount.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            login(account, password);
        });

        btnRegister.setOnClickListener((v) -> {
            navigateTo(RegisterActivity.class);
        });
    }

    private void login(String account, String password) {

        if (StringUtils.isEmpty(account)){
            showToast("请输入账号");
            return;
        }
        if (StringUtils.isEmpty(password)){
            showToast("请输入密码");
            return;
        }

        NetworkService loginService = RetrofitClient.getInstance().getService(NetworkService.class);
        loginService.login(account, password).subscribe(new Consumer<BaseEntity<Token>>() {
            @Override
            public void accept(BaseEntity<Token> tokenBaseEntity) throws Throwable {
                if (tokenBaseEntity.getCode() == 200){
                    String token = tokenBaseEntity.getObject().getTokenHead() + " " + tokenBaseEntity.getObject().getToken();
                    //将token存到sp_ut.xml文件
                    saveStringToSp("token", token);
                    navigateTo(HomePageActivity.class);
                    LoginActivity.this.finish();
                    showToastSync("登录成功");
                }else {
                    showToastSync("登录失败");
                }

            }
        });
    }

}