package activity.xz.com.side_menuandroid_master.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import activity.xz.com.side_menuandroid_master.R;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/6/28.
 */

public class LodingActivity extends Activity {
    @BindViews({R.id.btn_side_menu, R.id.btn_titanic, R.id.btn_context_menu, R.id.btn_circlea, R.id.btn_text_input_layout, R.id.btn_fragment_layout, R.id.btn_recycler,R.id.btn_view})
    List<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loding_main);
        ButterKnife.bind(this);
        String[] names = {"曾经", "有", "一份", "真诚", "的", "爱情", "摆在", "我的", "面前", "我", "没有", "好好", "珍惜", "如果", "上天", "能够在给我一次机会的话", "我会对那个女孩说三个字", "“我爱你”", "如果非要在这份爱上加一个期限的话", "我希望是", "一", "万", "年"};
        Observable.from(names)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.d("Action1",s);
                    }
                });
    }

    @OnClick({R.id.btn_side_menu, R.id.btn_titanic, R.id.btn_context_menu, R.id.btn_circlea, R.id.btn_text_input_layout, R.id.btn_fragment_layout, R.id.btn_recycler,R.id.btn_view})
    public void butterknifeOnItemClick(View view) {
        switch (view.getId()) {
            case R.id.btn_view:
                startActivity(new Intent(this, RunningTextViewDemoActivity.class));
                break;
            case R.id.btn_side_menu:
                startActivity(new Intent(this, PowerfulEditTextDemoActivity.class));
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
