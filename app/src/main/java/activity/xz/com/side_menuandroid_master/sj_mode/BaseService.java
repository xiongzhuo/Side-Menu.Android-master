package activity.xz.com.side_menuandroid_master.sj_mode;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/7/7.
 */

public class BaseService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }
}
