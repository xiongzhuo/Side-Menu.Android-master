package activity.xz.com.side_menuandroid_master.ui.loging;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import activity.xz.com.side_menuandroid_master.R;
import activity.xz.com.side_menuandroid_master.wigit.ClearEditText;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/12.
 */

public class LoginAciticity extends AppCompatActivity {
    @BindViews({R.id.et_login_userName, R.id.et_login_pwd})
    List<ClearEditText> clearEditTexts;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.pb_progress)
    ProgressBar pbProgress;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void click() {

    }
}
