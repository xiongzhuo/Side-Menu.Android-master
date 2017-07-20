package activity.xz.com.side_menuandroid_master.base;

/**
 * Created by Administrator on 2017/7/12.
 */

public interface OnHttpCallBack<T>{
    void onSuccessful(T t);
    void onFaild(String errorMsg);
}
