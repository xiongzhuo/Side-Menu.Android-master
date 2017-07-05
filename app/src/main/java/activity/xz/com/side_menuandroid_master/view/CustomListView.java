package activity.xz.com.side_menuandroid_master.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import activity.xz.com.side_menuandroid_master.R;

/**
 * Created by Administrator on 2017/6/29.
 */

public class CustomListView extends ListView implements GestureDetector.OnGestureListener, View.OnTouchListener {
    // 手势动作探测器
    GestureDetector mGestureDeltctor;

    //删除事件监听器
    public interface OnDeleteListener {
        void onDelete(int index);
    }


    private OnDeleteListener mOnDeleteListener;

    //删除按钮
    private View mDeleteBtn;
    //列表项布局
    private ViewGroup mItemLayout;
    //选择的列表项
    private int mSelectedItem;
    //当前删除按钮是否显示出来了
    private boolean isDeleteShown;

    public CustomListView(Context context) {
        super(context);
    }

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //创建手势监听对象
        mGestureDeltctor = new GestureDetector(getContext(), this);
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isDeleteShown) {
            hideDelete();
            return false;
        } else {
            return mGestureDeltctor.onTouchEvent(event);
        }
    }

    private void hideDelete() {
        mItemLayout.removeView(mDeleteBtn);
        mDeleteBtn = null;
        isDeleteShown = false;
    }

    /*触发顺序：
    onDown->onShowPress->onLongPress*/
   /* 滑屏，用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
    参数解释：
    e1：第1个ACTION_DOWN MotionEvent
    e2：最后一个ACTION_MOVE MotionEvent
    velocityX：X轴上的移动速度，像素/秒
    velocityY：Y轴上的移动速度，像素/秒*/
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        // 如果当前删除按钮没有显示出来，并且x方向滑动的速度大于y方向的滑动速度
        if (!isDeleteShown && Math.abs(velocityX) > Math.abs(velocityY)) {
            mDeleteBtn = LayoutInflater.from(getContext()).inflate(R.layout.delete_btn, null);
            mDeleteBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemLayout.removeView(mDeleteBtn);
                    mDeleteBtn = null;
                    isDeleteShown = false;
                    mOnDeleteListener.onDelete(mSelectedItem);
                }
            });
            mItemLayout = (ViewGroup) getChildAt(mSelectedItem - getFirstVisiblePosition());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_LEFT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            mItemLayout.addView(mDeleteBtn, params);
            isDeleteShown = true;
        }
        return false;
    }

    //用户按下屏幕就会触发
    @Override
    public boolean onDown(MotionEvent e) {
        if (!isDeleteShown) {
            mSelectedItem = pointToPosition((int) e.getX(), (int) e.getY());
        }
        return false;
    }

    public boolean isDeleteShown() {
        return isDeleteShown;
    }

    //如果是按下的时间超过瞬间，而且在按下的时候没有松开或者是拖动的，那么onShowPress就会执行，具体这个瞬间是多久，我也不清楚呃……
    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    /*在屏幕上拖动事件。无论是用手拖动view，或者是以抛的动作滚动，都会多次触发,这个方法       在ACTION_MOVE动作发生时就会触发
    滑屏：手指触动屏幕后，稍微滑动后立即松开
    onDown-----》onScroll----》onScroll----》onScroll----》………----->onFling
            拖动
    onDown------》onScroll----》onScroll------》onFiling
    可见，无论是滑屏，还是拖动，影响的只是中间OnScroll触发的数量多少而已，最终都会触发onFling事件！*/
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    //长按触摸屏，超过一定时长，就会触发这个事件
    @Override
    public void onLongPress(MotionEvent e) {

    }
}
