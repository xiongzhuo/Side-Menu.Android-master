package activity.xz.com.side_menuandroid_master.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import activity.xz.com.side_menuandroid_master.R;

/**
 * Created by Administrator on 2017/6/28.
 */

public class CustomImageView extends View {
    int width, height;
    /**
     * 图片
     */
    Bitmap mImage;
    /**
     * 图片的缩放模式
     */
    private int mImageScale;
    private static final int IMAGE_SCALE_FITXY = 0;
    private static final int IMAGE_SCALE_CENTER = 1;
    /**
     * 文本
     */
    private String mTitleText;
    /**
     * 颜色
     */
    private int mTitleTextColor;
    /**
     * 文字大小
     */
    private int mTitleTextSize;
    Rect mRectText;

    /**
     * 绘制文本范围
     */
    private Rect mBound;//用于获取文字的宽和高
    private Paint mPaint;//画笔

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }


    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获得我们所定义的自定义样式属性
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleColor:
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titileTextSize:
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomTitleView_image:
                    mImage = BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));
                    break;
                case R.styleable.CustomTitleView_imageScaleType:
                    mImageScale = a.getInt(attr, 0);
                    break;
            }
        }
        a.recycle(); //重绘
        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mPaint.setColor(mTitleTextColor);
        mRectText = new Rect();
        mBound = new Rect();
        //计算描绘字体需要范围
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mRectText);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heigthtSize = MeasureSpec.getSize(heightMeasureSpec);
        //MeasureSpec.EXACTLY 一般设置了明确的值或者MATH_PARLUNT
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            // 由图片决定的宽
            int deireByImg = getPaddingLeft() + getPaddingRight() + mImage.getWidth();
            // 由字体决定的宽
            int desireByTitle = getPaddingLeft() + getPaddingRight() + mRectText.width();
            if (widthMode == MeasureSpec.AT_MOST)// wrap_content
            {
                int desire = Math.max(deireByImg, desireByTitle);
                width = Math.min(desire, widthSize);
                Log.e("xxx", "AT_MOST");
            }
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heigthtSize;
        } else {
            int desire = getPaddingTop() + getPaddingBottom() + mImage.getHeight() + mRectText.height();
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(desire, heigthtSize);
            }
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*
         * 画边框
         */
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.CYAN);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mBound.left = getPaddingLeft();
        mBound.right = width - getPaddingRight();
        mBound.top = getPaddingTop();
        mBound.bottom = height = getPaddingBottom();
        mPaint.setColor(mTitleTextColor);
        mPaint.setStyle(Paint.Style.FILL);
        /**
         * 当前设置的宽度小于字体需要的宽度，将字体改为xxx...
         */
        if (mRectText.width() > width) {
            TextPaint paint = new TextPaint(mPaint);
            String msg = TextUtils.ellipsize(mTitleText, paint, (float)
                    width - getPaddingLeft() - getPaddingRight(), TextUtils.TruncateAt.END).toString();
            canvas.drawText(msg, getPaddingLeft(), height - getPaddingBottom(), mPaint);
        } else {
            //正常情况，将字体居中
            canvas.drawText(mTitleText, width / 2 - mRectText.width() * 1.0f / 2, height - getPaddingBottom(), mPaint);
        }
        //取消使用掉的快
        mBound.bottom = mRectText.height();
        if (mImageScale == IMAGE_SCALE_FITXY) {
            canvas.drawBitmap(mImage, null, mBound, mPaint);
        } else {
            //计算居中的矩形范围
            mBound.left = width / 2 - mImage.getWidth() / 2;
            mBound.right = width / 2 + mImage.getWidth() / 2;
            mBound.top = (height - mRectText.height()) / 2 - mImage.getHeight() / 2;
            mBound.bottom = (height - mRectText.height()) / 2 + mImage.getHeight() / 2;

            canvas.drawBitmap(mImage, null, mBound, mPaint);
        }
    }

}
