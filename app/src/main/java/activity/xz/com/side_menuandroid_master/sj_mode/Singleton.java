package activity.xz.com.side_menuandroid_master.sj_mode;

import android.view.View;

/**
 * Created by Administrator on 2017/7/6.
 */

public class Singleton {
    //单列模式
//        private static Singleton instance;
//
//    public Singleton() {
//    }
//    public static Singleton getInstance(){
//        if (instance == null)
//            instance = new Singleton();
//        return instance;
//    }
    private volatile static Singleton instance;

    public Singleton() {
    }
    public Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
