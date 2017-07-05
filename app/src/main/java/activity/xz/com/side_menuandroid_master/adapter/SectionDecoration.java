package activity.xz.com.side_menuandroid_master.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

import java.util.List;

import activity.xz.com.mylibrary.interfaces.Resourceble;
import activity.xz.com.side_menuandroid_master.R;
import activity.xz.com.side_menuandroid_master.bean.NameBean;
import activity.xz.com.side_menuandroid_master.utils.DensityUtil;

/**
 * Created by Administrator on 2017/7/4.
 */

public class SectionDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "SectionDecoration";
    List<NameBean> dataList;
    DecorationCallback callback;
    //设置悬浮栏的画笔---paint
    Paint paint;
    private TextPaint textPaint;
    private int topGop;
    private int alignBottom;
    private Paint.FontMetrics fontMetrics;

    public SectionDecoration(List<NameBean> dataList, Context context, DecorationCallback callback) {
        Resources res = context.getResources();
        this.dataList = dataList;
        this.callback = callback;
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, android.R.color.darker_gray));
        //设置悬浮栏中文本的画笔
        textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(DensityUtil.dip2px(context, 14));
        textPaint.setColor(Color.DKGRAY);
        textPaint.setTextAlign(Paint.Align.LEFT);
        fontMetrics = new Paint.FontMetrics();
        topGop = res.getDimensionPixelSize(R.dimen.sectioned_top);
        //决定文本的显示位置等
        alignBottom = res.getDimensionPixelSize(R.dimen.sectioned_alignBottom);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildAdapterPosition(view);
        String groupId = callback.getGroupId(pos);
        if (groupId.equals("-1")) return;
        if (pos == 0 || isFirstInGroup(pos)) {
            outRect.top = topGop;
            if (TextUtils.isEmpty(dataList.get(pos).getName())) {
                outRect.top = 0;
            }
        } else {
            outRect.top = 0;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            String groupId = callback.getGroupId(position);
            if (groupId.equals("-1")) return;
            String textLine = callback.getGroupFristLine(position).toUpperCase();
            if (TextUtils.isEmpty(textLine)) {
                float top = view.getTop();
                float buttom = view.getTop();
                c.drawRect(left, top, right, buttom, paint);
                return;
            } else {
                if (position == 0 || isFirstInGroup(position)) {
                    float top = view.getTop() - topGop;
                    float buttom = view.getTop();
                    //绘制悬浮栏
                    c.drawRect(left, top - topGop, right, buttom, paint);
                    //绘制文本
                    c.drawText(textLine, left, buttom, textPaint);
                }
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int itemCount = state.getItemCount();
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        float lineHight = textPaint.getTextSize() + fontMetrics.descent;
        String preGroupId = "";
        String groupId = "-1";
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);

            preGroupId = groupId;
            groupId = callback.getGroupId(position);
            if (groupId.equals("-1") || groupId.equals(preGroupId)) continue;
            String textLine = callback.getGroupFristLine(position).toUpperCase();
            if (TextUtils.isEmpty(textLine)) continue;
            int viewButtom = view.getBottom();
            float textY = Math.max(topGop, view.getTop());
            //下一个和当前不一样移动当前
            if (position + 1 < itemCount) {
                String nextGroupId = callback.getGroupId(position + 1);
                //组内最后一个view进入了header
                if (nextGroupId != groupId && viewButtom < textY) {
                    textY = viewButtom;
                }
            }
            //textY - topGap决定了悬浮栏绘制的高度和位置
            c.drawRect(left, textY - topGop, right, textY, paint);
            //left+2*alignBottom 决定了文本往左偏移的多少（加-->向左移）
            //textY-alignBottom  决定了文本往右偏移的多少  (减-->向上移)
            c.drawText(textLine, left + 2 * alignBottom, textY - alignBottom, textPaint);
        }
    }

    private boolean isFirstInGroup(int pos) {
        if (pos == 0) {
            return true;
        } else {
            // 因为是根据 字符串内容的相同与否 来判断是不是同意组的，所以此处的标记id 要是String类型
            // 如果你只是做联系人列表，悬浮框里显示的只是一个字母，则标记id直接用 int 类型就行了
            String prevGroupId = callback.getGroupId(pos - 1);
            String groupId = callback.getGroupId(pos);
            if (prevGroupId.equals(groupId)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public interface DecorationCallback {
        String getGroupId(int position);

        String getGroupFristLine(int position);

    }
}
