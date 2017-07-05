package activity.xz.com.side_menuandroid_master.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activity.xz.com.side_menuandroid_master.R;
import activity.xz.com.side_menuandroid_master.adapter.MyFragmentPagerAdapter;
import activity.xz.com.side_menuandroid_master.fragment.ContactFragment;
import activity.xz.com.side_menuandroid_master.fragment.FindFragment;
import activity.xz.com.side_menuandroid_master.fragment.SelfFragment;
import activity.xz.com.side_menuandroid_master.fragment.WeChatFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/3.
 */

public class MainTabActivity extends AppCompatActivity {
    //声明存储Fragment的集合
    private ArrayList<Fragment> fragments;
    //声明4个导航Fragment
    WeChatFragment weChatFragment;
    FindFragment findFragment;
    ContactFragment contactFragment;
    SelfFragment selfFragment;
    //声明ViewPager
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    FragmentManager fragmentManager;//声明Fragment管理器
    //声明导航栏中的对应布局
    @BindViews({R.id.contact, R.id.self, R.id.weixin, R.id.find})
    List<LinearLayout> linearLayouts;
    //声明导航栏中包含的imageview和textview
    @BindViews({R.id.contact_txt, R.id.self_txt, R.id.weixin_txt, R.id.find_txt})
    List<TextView> textViews;
    @BindViews({R.id.contact_img, R.id.self_img, R.id.weixin_img, R.id.find_img})
    List<ImageView> imageViews;
    MyFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_activity);
        ButterKnife.bind(this);
        //初始化加载首页布局
        initView();
        //调用自定义initListener方法，为各个组件添加监听事件
        initListener();
        viewPager.setCurrentItem(0);
        textViews.get(2).setSelected(true);
        imageViews.get(2).setSelected(true);
    }

    private void initView() {
        weChatFragment = new WeChatFragment();
        findFragment = new FindFragment();
        contactFragment = new ContactFragment();
        selfFragment = new SelfFragment();
        fragments = new ArrayList<>();
        //添加Fragment到fragments集合中
        fragments.add(weChatFragment);
        fragments.add(contactFragment);
        fragments.add(findFragment);
        fragments.add(selfFragment);
        fragmentManager = getSupportFragmentManager();
        //为ViewPager设置适配器用于部署fragments
        adapter = new MyFragmentPagerAdapter(fragmentManager, fragments);
        viewPager.setAdapter(adapter);
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //根据位置直接决定显示哪个fragment
                viewPager.setCurrentItem(position);
                switch (position) {
                    case 0:
                        imageViews.get(2).setSelected(true);
                        textViews.get(2).setSelected(true);
                        imageViews.get(0).setSelected(false);
                        textViews.get(0).setSelected(false);
                        textViews.get(1).setSelected(false);
                        imageViews.get(1).setSelected(false);
                        imageViews.get(3).setSelected(false);
                        textViews.get(3).setSelected(false);
                        break;
                    case 1:
                        imageViews.get(0).setSelected(true);
                        textViews.get(0).setSelected(true);
                        imageViews.get(1).setSelected(false);
                        textViews.get(1).setSelected(false);
                        textViews.get(3).setSelected(false);
                        imageViews.get(3).setSelected(false);
                        imageViews.get(2).setSelected(false);
                        textViews.get(2).setSelected(false);
                        break;
                    case 2:
                        imageViews.get(3).setSelected(true);
                        textViews.get(3).setSelected(true);
                        imageViews.get(0).setSelected(false);
                        textViews.get(0).setSelected(false);
                        textViews.get(1).setSelected(false);
                        imageViews.get(1).setSelected(false);
                        imageViews.get(2).setSelected(false);
                        textViews.get(2).setSelected(false);
                        break;
                    case 3:
                        imageViews.get(1).setSelected(true);
                        textViews.get(1).setSelected(true);
                        imageViews.get(0).setSelected(false);
                        textViews.get(0).setSelected(false);
                        textViews.get(3).setSelected(false);
                        imageViews.get(3).setSelected(false);
                        imageViews.get(2).setSelected(false);
                        textViews.get(2).setSelected(false);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.contact, R.id.self, R.id.weixin, R.id.find})
    void buttfllOnclick(View view) {
        switch (view.getId()) {
            case R.id.contact:
                viewPager.setCurrentItem(1);
                imageViews.get(0).setSelected(true);
                textViews.get(0).setSelected(true);
                imageViews.get(1).setSelected(false);
                textViews.get(1).setSelected(false);
                textViews.get(2).setSelected(false);
                imageViews.get(3).setSelected(false);
                imageViews.get(2).setSelected(false);
                textViews.get(2).setSelected(false);
                break;
            case R.id.self:
                viewPager.setCurrentItem(3);
                imageViews.get(1).setSelected(true);
                textViews.get(1).setSelected(true);
                imageViews.get(0).setSelected(false);
                textViews.get(0).setSelected(false);
                textViews.get(3).setSelected(false);
                imageViews.get(3).setSelected(false);
                imageViews.get(2).setSelected(false);
                textViews.get(2).setSelected(false);
                break;
            case R.id.find:
                viewPager.setCurrentItem(2);
                imageViews.get(3).setSelected(true);
                textViews.get(3).setSelected(true);
                imageViews.get(0).setSelected(false);
                textViews.get(0).setSelected(false);
                textViews.get(1).setSelected(false);
                imageViews.get(1).setSelected(false);
                imageViews.get(2).setSelected(false);
                textViews.get(2).setSelected(false);
                break;
            case R.id.weixin:
                viewPager.setCurrentItem(0);
                imageViews.get(2).setSelected(true);
                textViews.get(2).setSelected(true);
                imageViews.get(0).setSelected(false);
                textViews.get(0).setSelected(false);
                textViews.get(1).setSelected(false);
                imageViews.get(1).setSelected(false);
                imageViews.get(3).setSelected(false);
                textViews.get(3).setSelected(false);
                break;
        }
    }
}
