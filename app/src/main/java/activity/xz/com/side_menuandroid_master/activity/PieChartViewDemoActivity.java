package activity.xz.com.side_menuandroid_master.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.chaychan.viewlib.piechartview.FanItem;
import com.chaychan.viewlib.piechartview.OnFanItemClickListener;
import com.chaychan.viewlib.piechartview.PieChartView;

import activity.xz.com.side_menuandroid_master.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/13.
 */

public class PieChartViewDemoActivity extends AppCompatActivity {
    private boolean fanRoateAniamtionStart; //true:扇形动画已经进行中
    @BindView(R.id.pieChartView)
    PieChartView chartView;
    @BindView(R.id.tv_select_item)
    TextView tvItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart_view_demo);
        ButterKnife.bind(this);
        chartView.setFanClickAbleData(
                new double[]{10,20,30,15,25},
                new int[]{Color.GRAY,Color.GREEN, Color.DKGRAY,Color.GREEN,Color.BLUE},0.08);
        chartView.setOnFanClick(new OnFanItemClickListener() {
            @Override
            public void onFanClick(final FanItem fanItem) {
                if (!fanRoateAniamtionStart) {
                    float to;
                    float center = (fanItem.getStartAngle() * 2 + fanItem.getAngle()) / 2;
                    if (center >= 270) {
                        to = 360 - center + 90;
                    } else {
                        to = 90 - center;
                    }
                    RotateAnimation animation = new RotateAnimation(0, to, chartView.getFanRectF().centerX(), chartView.getFanRectF().centerY());
                    animation.setDuration(800);
//                        animation.setInterpolator(new AccelerateInterpolator());
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            fanRoateAniamtionStart = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            chartView.setToFirst(fanItem);
                            chartView.clearAnimation();
                            chartView.invalidate();
                            fanRoateAniamtionStart = false;
                            tvItem.setText("当前选中："+fanItem.getPercent()+"%");
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    animation.setFillAfter(true);
                    chartView.startAnimation(animation);
                }
            }
        });
    }
}
