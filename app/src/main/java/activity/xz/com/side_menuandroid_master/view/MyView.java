package activity.xz.com.side_menuandroid_master.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/7/10.
 */

public class MyView extends View {
    //绘制画笔
    Paint paint = new Paint();

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画布颜色
//        canvas.drawColor(Color.BLUE);
        canvas.drawPoint(200, 200, paint);//在坐标200.200处绘制一个点
        canvas.drawPoints(new float[]{500, 500, 500, 600, 500, 700}, paint);
        canvas.drawLine(300, 300, 500, 600, paint);//在坐标(300,300)(500,600)之间绘制一条直线
        canvas.drawLines(new float[]{100, 200, 200, 200, 100, 300, 200, 300}, paint); // 绘制一组线 每四数字(两个点的坐标)确定一条线
//        canvas.drawRect(0, 1000, 400, 800, paint);
//        RectF rectF = new RectF(420,1000,820,800);
//        canvas.drawRoundRect(rectF,30,30,paint);//繪製圓角矩形
//        canvas.drawRoundRect(520,1000,500,800,30,30,paint);

//        Rect rect = new Rect(100, 1000, 600, 800);
//        canvas.drawRect(rect, paint);
//        RectF rectF = new RectF(100, 1000, 600, 800);
//        canvas.drawRect(rectF, paint);
        //rect与rectF的突出区别是一个是int整形，一个是float浮点型。
        // 矩形
//        RectF rectF = new RectF(100, 100, 800, 400);
// 绘制背景矩形
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(rectF, paint);
// 绘制圆角矩形
//        paint.setColor(Color.BLUE);
//        canvas.drawRoundRect(rectF, 700, 400, paint);
        /*其中灰色部分是我们所选定的矩形，而里面的圆角矩形则变成了一个椭圆，
 实际上在rx为宽度的一半，ry为高度的一半时，刚好是一个椭圆，通过上面我们分析的原理推算一下就能得到，
 而当rx大于宽度的一半，ry大于高度的一半时，实际上是无法计算出圆弧的，所以drawRoundRect对大于该数值的参数进行了限制(修正)，
 凡是大于一半的参数均按照一半来处理。*/
        // 第一种
//        RectF rectF2 = new RectF(100,100,800,400);
//        canvas.drawOval(rectF2,paint);

       // 第二种
//        canvas.drawOval(100,100,800,400,paint);
//        canvas.drawCircle(500,500,400,paint);// 绘制一个圆心坐标在(500,500)，半径为400 的圆。
//        RectF rectF = new RectF(100,100,600,600);
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(rectF,paint);
//        //繪製圓弧
//        paint.setColor(Color.BLUE);
//        canvas.drawArc(rectF,0,45,true,paint);
//        paint.setColor(Color.BLUE);
//        paint.setStrokeWidth(40);     //为了实验效果明显，特地设置描边宽度非常大

// 描边
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(200,200,100,paint);
//
//// 填充
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(200,500,100,paint);
//
//// 描边加填充
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawCircle(200, 800, 100, paint);
        // 将坐标系原点移动到画布正中心
//        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
//
//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        paint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,paint);
//
//        canvas.scale(0.5f,0.5f);                // 画布缩放
//
//        paint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,paint);
        // 将坐标系原点移动到画布正中心
//        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
//
//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        paint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,paint);
//
//
//        canvas.scale(-0.5f,-0.5f);          // 画布缩放
//
//        paint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,paint);
        // 将坐标系原点移动到画布正中心
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);

        RectF rect = new RectF(-400,-400,400,400);   // 矩形区域

        for (int i=0; i<=20; i++)
        {
            canvas.scale(0.9f,0.9f);
            canvas.drawRect(rect,paint);
        }
    }

    //初始化畫筆
    public void initPaint() {
        paint.setColor(Color.BLACK);//绘制颜色
        paint.setStyle(Paint.Style.FILL);//绘制画笔模式为填充
        paint.setStrokeWidth(10f);//绘制画笔宽度有10px
    }
}
