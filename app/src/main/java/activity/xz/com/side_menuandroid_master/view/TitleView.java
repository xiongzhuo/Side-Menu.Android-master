package activity.xz.com.side_menuandroid_master.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import activity.xz.com.side_menuandroid_master.R;

/**
 * Created by Administrator on 2017/6/29.
 */

public class TitleView extends RelativeLayout {
    private Button mLeftBtn;
    private TextView mTitleTv;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //加载布局
        View view = LayoutInflater.from(context).inflate(R.layout.title_bar, null);
        //获取控件
        mLeftBtn = (Button) view.findViewById(R.id.left_btn);
        mTitleTv = (TextView) view.findViewById(R.id.title_tv);
    }

    // 为左侧返回按钮添加自定义点击事件
    public void setLeftButtonListener(OnClickListener listener) {
        mLeftBtn.setOnClickListener(listener);
    }

    // 设置标题的方法
    public void setTitleText(String title) {
        mTitleTv.setText(title);
    }

    //用来布局子控件
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }

    //用来绘制UI
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}
