package activity.xz.com.side_menuandroid_master.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import activity.xz.com.side_menuandroid_master.R;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/28.
 */

public class LodingActivity extends Activity {
    @BindViews({R.id.btn_side_menu, R.id.btn_titanic, R.id.btn_context_menu, R.id.btn_circlea, R.id.btn_text_input_layout, R.id.btn_fragment_layout, R.id.btn_recycler})
    List<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loding_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_side_menu, R.id.btn_titanic, R.id.btn_context_menu, R.id.btn_circlea, R.id.btn_text_input_layout, R.id.btn_fragment_layout, R.id.btn_recycler})
    public void butterknifeOnItemClick(View view) {
        switch (view.getId()) {
            case R.id.btn_side_menu:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btn_titanic:
                startActivity(new Intent(this, TitanisActivity.class));
                break;
            case R.id.btn_context_menu:
                startActivity(new Intent(this, ContextMenuActivity.class));
                break;
            case R.id.btn_circlea:
                startActivity(new Intent(this, CircleAcitivity.class));
                break;
            case R.id.btn_text_input_layout:
                startActivity(new Intent(this, TextInputLayoutActivity.class));
                break;
            case R.id.btn_fragment_layout:
                startActivity(new Intent(this, MainTabActivity.class));
                break;
            case R.id.btn_recycler:
                startActivity(new Intent(this, RecyclerActivity.class));
                break;
        }
    }

}
