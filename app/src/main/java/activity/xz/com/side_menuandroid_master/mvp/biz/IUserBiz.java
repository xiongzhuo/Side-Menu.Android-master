package activity.xz.com.side_menuandroid_master.mvp.biz;

/**
 * Created by Administrator on 2017/7/19.
 */
public interface IUserBiz{
    void login(String userName,String password,OnLoginListener onLoginListener);
}