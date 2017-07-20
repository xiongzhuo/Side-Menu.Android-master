package activity.xz.com.side_menuandroid_master.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import activity.xz.com.side_menuandroid_master.mvp.bean.User;
import activity.xz.com.side_menuandroid_master.mvp.presenter.UserLoginPresenter;
import activity.xz.com.side_menuandroid_master.mvp.view.IUserLoginView;

/**
 * Created by Administrator on 2017/7/19.
 */

public class LodingActivity extends AppCompatActivity implements IUserLoginView{
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;
    UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearPassword() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMianActicity(User user) {

    }

    @Override
    public void showFailedError() {

    }
}
