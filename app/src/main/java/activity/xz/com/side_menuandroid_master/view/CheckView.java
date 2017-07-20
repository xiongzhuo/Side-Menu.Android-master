package activity.xz.com.side_menuandroid_master.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/11.
 */

public class CheckView extends View{
    private static final int ANIMOTION_NULL = 0;//没有
    private static final int ANIMOTION_CHECKED = 1;
    private static final int ANIMOTION_UNCHECKED = 2;
    private Context mContext; //上下文
    private int mWidth,mHeight;//宽高
    private Handler mHandler;
    private Paint mPaint;
    private Bitmap mBitmap;
    private int animCurrent = -1;
    private int animMaxPage = 13;
    private int animDuration = 500;
    private int ainmState = ANIMOTION_NULL;
    private boolean isCheckd = false;


    public CheckView(Context context) {
        super(context);
    }

    public CheckView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
