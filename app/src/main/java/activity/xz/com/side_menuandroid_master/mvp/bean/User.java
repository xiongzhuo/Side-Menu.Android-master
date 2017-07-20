package activity.xz.com.side_menuandroid_master.mvp.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/19.
 */
public class User implements Serializable{
      private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}