package activity.xz.com.side_menuandroid_master.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activity.xz.com.side_menuandroid_master.R;

/**
 * Created by Administrator on 2017/7/3.
 */

public class SelfFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.seft_fragment, container, false);
        return view;
    }
}