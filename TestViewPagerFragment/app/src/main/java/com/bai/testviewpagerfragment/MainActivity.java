package com.bai.testviewpagerfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bai.testviewpagerfragment.Adapter.FragmentAdapter;
import com.bai.testviewpagerfragment.Interface.FragmentMessgeI;
import com.bai.testviewpagerfragment.MainFragment.OneFragment;
import com.bai.testviewpagerfragment.MainFragment.ThreeFragment;
import com.bai.testviewpagerfragment.MainFragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, FragmentMessgeI {

    private ViewPager viewPager;
    private TextView tv_one;
    private TextView tv_two;
    private TextView tv_three;
    private FragmentAdapter fragmentAdapter;
    private OneFragment fg_one;
    private TwoFragment fg_two;
    private ThreeFragment fg_three;
    public List<Fragment> fragmentList;
    private List<TextView> textViewList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        tv_one = findViewById(R.id.tv_one);
        tv_two = findViewById(R.id.tv_two);
        tv_three = findViewById(R.id.tv_three);
        viewPager.addOnPageChangeListener(this);
        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        tv_three.setOnClickListener(this);
        initView();
    }

    private void initView(){
        fragmentList = new ArrayList<>();
        textViewList = new ArrayList<>();
        textViewList.add(tv_one);
        textViewList.add(tv_two);
        textViewList.add(tv_three);
        fg_one = new OneFragment();
        fg_two = new TwoFragment();
        fg_three = new ThreeFragment();

        fragmentList.add(fg_one);
        fragmentList.add(fg_two);
        fragmentList.add(fg_three);

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(2);
        ChooseView(0);
    }


    private void ChooseView(int position){
        for (int i=0;i<textViewList.size();i++){
            if (i==position)
                textViewList.get(i).setTextColor(getResources().getColor(R.color.colorPrimary));
            else
                textViewList.get(i).setTextColor(getResources().getColor(android.R.color.black));
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageSelected(int position) {
        ChooseView(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_one:
                ChooseView(0);
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_two:
                ChooseView(1);
                viewPager.setCurrentItem(1);
                break;
            case R.id.tv_three:
                ChooseView(2);
                viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void transferString(String s,int i) {
        switch (i){
            case 0:
                OneFragment fragment = (OneFragment) fragmentList.get(i);
                fragment.SetText(s);
                break;
            case 1:
                TwoFragment fragment1 = (TwoFragment) fragmentList.get(i);
                fragment1.SetText(s);
                break;
            case 2:
                ThreeFragment fragment2 = (ThreeFragment) fragmentList.get(i);
                fragment2.SetText(s);
                break;
        }
    }
}
