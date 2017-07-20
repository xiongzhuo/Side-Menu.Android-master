package activity.xz.com.side_menuandroid_master.mvp.biz;

import activity.xz.com.side_menuandroid_master.mvp.bean.User;

/**
 * Created by Administrator on 2017/7/19.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
