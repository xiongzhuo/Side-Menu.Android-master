package activity.xz.com.side_menuandroid_master.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import activity.xz.com.side_menuandroid_master.R;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/3.
 */

public class TextInputLayoutActivity extends Activity {
    @BindView(R.id.btn)
    Button btn;
    @BindViews({R.id.username_wrapper, R.id.password_wrapper})
    List<TextInputLayout> textInputLayouts;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_input_layout);
        ButterKnife.bind(this);
        btn = (Button) findViewById(R.id.btn);
        textInputLayouts.get(0).setHint("Username");
        textInputLayouts.get(1).setHint("Password");
    }

    @OnClick(R.id.btn)
    public void setBtn() {
        hideKeyboard();
        String username = textInputLayouts.get(0).getEditText().getText().toString();
        String password = textInputLayouts.get(1).getEditText().getText().toString();
        if (!validateEmail(username)) {
            textInputLayouts.get(0).setError("Not a valid email address!");
        } else if (!validatePassword(password)) {
            textInputLayouts.get(1).setError("Not a valid password!");
        } else {
            textInputLayouts.get(0).setErrorEnabled(false);
            textInputLayouts.get(1).setErrorEnabled(false);
            doLogin();
        }
    }

    public void doLogin() {
        Toast.makeText(getApplicationContext(), "OK! I'm performing login.", Toast.LENGTH_SHORT).show();
        // TODO: login procedure; not within the scope of this tutorial.
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }
}
