package activity.xz.com.side_menuandroid_master.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import activity.xz.com.titanic.library.Titanic;

import activity.xz.com.side_menuandroid_master.R;
import activity.xz.com.titanic.library.TitanicTextView;


public class TitanisActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titants_main);

        TitanicTextView tv = (TitanicTextView) findViewById(R.id.my_text_view);

        // set fancy typeface
        tv.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));

        // start animation
        new Titanic().start(tv);
    }

}
