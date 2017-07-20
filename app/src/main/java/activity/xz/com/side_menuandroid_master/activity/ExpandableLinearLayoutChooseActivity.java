package activity.xz.com.side_menuandroid_master.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import activity.xz.com.side_menuandroid_master.R;

/**
 * Created by Administrator on 2017/7/13.
 */

public class ExpandableLinearLayoutChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_linear_layout_choose);
    }

    //使用默认底部
    public void useDefaultBottom(View view){
        Intent intent = new Intent(this, EllDefaultBottomDemoActivity.class);
        startActivity(intent);
    }

    //使用自定义底部
    public void useCustomBottom(View view){
        Intent intent = new Intent(this, EllCustomBottomDemoActivity.class);
        startActivity(intent);
    }
}
