package activity.xz.com.side_menuandroid_master.mvp.presenter;

import android.content.Context;
import android.os.Handler;

import activity.xz.com.side_menuandroid_master.mvp.bean.User;
import activity.xz.com.side_menuandroid_master.mvp.biz.IUserBiz;
import activity.xz.com.side_menuandroid_master.mvp.biz.OnLoginListener;
import activity.xz.com.side_menuandroid_master.mvp.view.IUserLoginView;

/**
 * Created by Administrator on 2017/7/19.
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(Context context) {
    }

    public UserLoginPresenter(IUserBiz userBiz, IUserLoginView userLoginView) {
        this.userBiz = userBiz;
        this.userLoginView = userLoginView;
    }
    public void login()
    {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener()
        {
            @Override
            public void loginSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMianActicity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }
    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
