package activity.xz.com.side_menuandroid_master.mvp.view;

import activity.xz.com.side_menuandroid_master.mvp.bean.User;

/**
 * Created by Administrator on 2017/7/19.
 */

public interface IUserLoginView {
    String getUserName();
    String getPassword();
    void clearUserName();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void toMianActicity(User user);
    void showFailedError();
}
