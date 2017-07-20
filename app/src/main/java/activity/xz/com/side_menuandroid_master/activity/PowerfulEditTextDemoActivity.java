package activity.xz.com.side_menuandroid_master.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.chaychan.viewlib.PowerfulEditText;
import com.chaychan.viewlib.utils.UIUtils;

import activity.xz.com.side_menuandroid_master.R;

/**
 * Created by Administrator on 2017/7/13.
 */

public class PowerfulEditTextDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powerful_et_demo);

        PowerfulEditText petUsername = (PowerfulEditText) findViewById(R.id.pet);
        petUsername.setOnRightClickListener(new PowerfulEditText.OnRightClickListener() {
            @Override
            public void onClick(EditText editText) {
                String content = editText.getText().toString().trim();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(PowerfulEditTextDemoActivity.this,"搜索的内容不能为空",Toast.LENGTH_SHORT);
                    return;
                }
                Toast.makeText(PowerfulEditTextDemoActivity.this,"执行搜索逻辑",Toast.LENGTH_SHORT);
            }
        });
    }
}
