package activity.xz.com.side_menuandroid_master.ui.loging;

import android.content.Context;
import android.util.Log;

import com.chaychan.viewlib.NumberRunningTextView;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import activity.xz.com.side_menuandroid_master.base.APIService;
import activity.xz.com.side_menuandroid_master.base.OnHttpCallBack;
import activity.xz.com.side_menuandroid_master.bean.TokenResult;
import activity.xz.com.side_menuandroid_master.bean.UserHttpResult;
import activity.xz.com.side_menuandroid_master.bean.UserInfo;
import activity.xz.com.side_menuandroid_master.http.RetrofitUtils;
import retrofit2.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/7/12.
 */

public class LoginModel implements LoginContract.ILoginModel {
    @Override
    public void login(UserInfo userInfo, final OnHttpCallBack<TokenResult> callBack) {
        RetrofitUtils.newInstence("http://192.168.2.153:8080/")
                .create(APIService.class)
                .userLogin(userInfo.getUserName(),userInfo.getPwd())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserHttpResult<TokenResult>>() {
                    @Override
                    public void onCompleted() {
                    //完成時調用
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
//失败的时候调用-----一下可以忽略 直接 callBack.onFaild("请求失败");
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            //httpException.response().errorBody().string()
                            int code = httpException.code();
                            if (code == 500 || code == 404) {
                                callBack.onFaild("服务器出错");
                            }
                        } else if (e instanceof ConnectException) {
                            callBack.onFaild("网络断开,请打开网络!");
                        } else if (e instanceof SocketTimeoutException) {
                            callBack.onFaild("网络连接超时!!");
                        } else {
                            callBack.onFaild("发生未知错误" + e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(UserHttpResult<TokenResult> tokenResultUserHttpResult) {
                        if (tokenResultUserHttpResult.getResultCode() == 0) {
                            callBack.onSuccessful(tokenResultUserHttpResult.getData());//登录成功------获取完数据,返回给P---P获取到数据之后就将数据交回给V
                        } else {
                            callBack.onFaild("用户名或密码错误!");//登录失败
                        }
                    }
                });
    }

    @Override
    public void saveUserInfo(Context context, UserInfo info, String token) {
        context.getSharedPreferences("userinfo", Context.MODE_PRIVATE).edit()
                .putString("userName", info.getUserName())
                .putString("pwd", info.getPwd())
                .putString("address", info.getAddress())
                .putString("phone", info.getPhone())
                .putString("token", token)
                .commit();
    }
}
