package activity.xz.com.side_menuandroid_master.ui.loging;

import android.content.Context;

import activity.xz.com.side_menuandroid_master.base.OnHttpCallBack;
import activity.xz.com.side_menuandroid_master.bean.TokenResult;
import activity.xz.com.side_menuandroid_master.bean.UserInfo;

/**
 * 登陆关联类
 * Created by Administrator on 2017/7/12.
 */

public class LoginContract {
    interface ILogingView {
        Context getCurCotext();//獲取上下文對象

        void showProgress();//显示对话框

        void hideProgree();//隐藏对话框

        void showInfo(String info);

        void showErrorMsg(String message);//發生錯誤信息

        void toMain();

        void toRegisht();

        UserInfo getUserloginInfo();
    }

    /**
     * P视图与逻辑处理的连接层
     */
    interface ILoginPresenter {
        void login();
    }

    interface ILoginModel {
        void login(UserInfo userInfo, OnHttpCallBack<TokenResult> callBack);

        void saveUserInfo(Context context, UserInfo info, String token);
    }
}
