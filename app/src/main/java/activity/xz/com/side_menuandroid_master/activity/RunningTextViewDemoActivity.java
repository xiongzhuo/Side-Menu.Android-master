package activity.xz.com.side_menuandroid_master.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.chaychan.viewlib.NumberRunningTextView;

import activity.xz.com.side_menuandroid_master.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/13.
 */

public class RunningTextViewDemoActivity extends AppCompatActivity{
    @BindView(R.id.srl_root)
     SwipeRefreshLayout srlRoot;
    @BindView(R.id.tv_money)
     NumberRunningTextView tvMoney;
    @BindView(R.id.tv_num)
     NumberRunningTextView tvNum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_text_view_demo);
        ButterKnife.bind(this);
        srlRoot.setColorSchemeColors(Color.parseColor("#ff7300"));
        tvMoney.setContent("144.00");
        tvNum.setContent("30");
    }
    private void initListener() {
        srlRoot.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tvMoney.setContent("1454.00");
                tvNum.setContent("300");
                srlRoot.setRefreshing(false);
            }
        });

    }

}
