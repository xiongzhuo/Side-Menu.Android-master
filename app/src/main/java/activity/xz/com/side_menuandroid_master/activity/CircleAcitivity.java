package activity.xz.com.side_menuandroid_master.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import activity.xz.com.side_menuandroid_master.R;
import activity.xz.com.side_menuandroid_master.view.CircleBar;

/**
 * Created by Administrator on 2017/6/30.
 */

public class CircleAcitivity extends Activity {
    private CircleBar circleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_main);
        circleBar = (CircleBar) findViewById(R.id.circle);
        circleBar.setSweepAngle(120);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                circleBar.setText("270");
            }
        }, 2000);
        //渐变透明度动画效果
//        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
//        circleBar.startAnimation(alphaAnimation);

        //代码实现渐变透明度效果
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);//设置动画持续时间
        alphaAnimation.setFillAfter(false);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
        circleBar.startAnimation(alphaAnimation);
        //scale渐变尺寸缩放动画效果
        Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setFillAfter(true);//如果fillAfter的值为true,则动画执行后，控件将停留在执行结束的状态
        scaleAnimation.setFillBefore(false);//如果fillBefore的值为true，则动画执行后，控件将回到动画执行之前的状态
        scaleAnimation.setRepeatCount(3);//设置循环次数
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setStartOffset(0);
//        scaleAnimation.setInterpolator();  设置动画插入器
//        imageView.startAnimation(scaleAnimation);
        //rotate画面旋转动画效果
        Animation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setFillAfter(false);
        rotateAnimation.setInterpolator(this, android.R.anim.accelerate_decelerate_interpolator);//设置动画插入器
        circleBar.startAnimation(alphaAnimation);
        //translate画面位置移动动画效果
        /*fromXDelta, fromYDelta 起始时X，Y座标, 屏幕右下角的座标是X:320, Y:480
        toXDelta，toYDelta 动画结束时X, Y的座标*/
        Animation translate = new TranslateAnimation(0, 100, 0, 0);
        translate.setDuration(500);
        translate.setInterpolator(this, android.R.anim.cycle_interpolator);
        translate.setFillAfter(true);
        circleBar.startAnimation(translate);
        //组合动画
//        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.anim_set);
//        circleBar.startAnimation(animationSet);
        AnimationSet animationSet = new AnimationSet(true);
        Animation alphaSetAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaSetAnimation.setDuration(500);
        Animation scaleSetAnimation = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleSetAnimation.setDuration(500);
        scaleSetAnimation.setRepeatMode(Animation.REVERSE);
        scaleSetAnimation.setStartOffset(0);
        scaleSetAnimation.setInterpolator(this, android.R.anim.cycle_interpolator);
        animationSet.addAnimation(alphaSetAnimation);
        animationSet.addAnimation(scaleSetAnimation);
        circleBar.startAnimation(animationSet);

        animationSet.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始时调用
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束时调用
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复时调用
            }
        });
    }

}
