package cn.ut.application;

import org.junit.Test;

import java.util.regex.Pattern;

import cn.ut.application.Entity.BaseEntity;
import cn.ut.application.Entity.InsertUser;
import cn.ut.application.Entity.Token;
import cn.ut.application.network.RetrofitClient;
import cn.ut.application.network.service.NetworkService;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void regex() {
        String phone = "12391493308";
        boolean matches = Pattern.matches("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", phone);

        if (!matches){
            System.out.println(phone);
        }
    }

    @Test
    public void name() {

        NetworkService service = RetrofitClient.getInstance().getService(NetworkService.class);
        service.login("ut", "123123").subscribe(new Consumer<BaseEntity<Token>>() {
            @Override
            public void accept(BaseEntity<Token> tokenBaseBean) throws Throwable {
                System.out.println(tokenBaseBean);
            }
        });
        while (true);

//        InsertUser user = new InsertUser();
//        user.setUsername("ccc");
//        user.setPhone(15391493308L);
//        user.setPassword("123123");
//
//
//        service.insertUser(user).subscribe(new Consumer<BaseEntity>() {
//            @Override
//            public void accept(BaseEntity baseEntity) throws Throwable {
//                System.out.println(baseEntity);
//            }
//        });
//        while (true);
    }
}