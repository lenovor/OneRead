package com.wu.allen.myone.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import com.wu.allen.myone.R;
import com.wu.allen.myone.ui.fragment.OneImgFragment;
import com.wu.allen.myone.ui.fragment.QaFragment;
import com.wu.allen.myone.ui.fragment.SuJinFragment;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        switchToFragmnent();
    }


    public void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        setSupportActionBar(toolbar);
    }


    public void switchToFragmnent() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new OneImgFragment();
                    case 1:
                        return new SuJinFragment();
                    case 2:
                        return new QaFragment();
                    default:
                        return new OneImgFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.OneImg);
                    case 1:
                        return getString(R.string.SuJin);
                    case 2:
                        return getString(R.string.WenDa);
                    default:
                        return getString(R.string.OneImg);
                }
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}