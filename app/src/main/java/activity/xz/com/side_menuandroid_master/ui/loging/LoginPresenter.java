package activity.xz.com.side_menuandroid_master.ui.loging;

import activity.xz.com.side_menuandroid_master.base.OnHttpCallBack;
import activity.xz.com.side_menuandroid_master.bean.TokenResult;

/**
 * Created by Administrator on 2017/7/12.
 */

public class LoginPresenter implements LoginContract.ILoginPresenter {
    private LoginContract.ILogingView mLoginView;
    private LoginContract.ILoginModel mLoginModel;

    public LoginPresenter(LoginContract.ILogingView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginModel = new LoginModel();
    }

    @Override
    public void login() {
        mLoginView.showProgress();
        final int i = 0;
        mLoginModel.login(mLoginView.getUserloginInfo(), new OnHttpCallBack<TokenResult>() {
            @Override
            public void onSuccessful(TokenResult tokenResult) {
                mLoginView.hideProgree();//隐藏进度条
                mLoginView.toMain();//跳转到主页面
                mLoginModel.saveUserInfo(mLoginView.getCurCotext(), mLoginView.getUserloginInfo(), tokenResult.getToken());//保存用户数据
                mLoginView.showInfo("登录成功,您的用户toekn为:" + tokenResult.getToken());//提示用户登录成功
            }

            @Override
            public void onFaild(String errorMsg) {
                mLoginView.hideProgree();//隐藏进度条
                mLoginView.showErrorMsg(errorMsg);//登录失败  显示错误信息
            }
        });
    }
}
