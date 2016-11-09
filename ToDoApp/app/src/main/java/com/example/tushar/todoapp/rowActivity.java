package com.example.tushar.todoapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class rowActivity extends FragmentActivity {

    FragmentPagerAdapter adapterViewPager;
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_row);


        mPager = (ViewPager) findViewById(R.id.pager);

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(adapterViewPager);
        mPager.setCurrentItem(MainActivity.position);

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        //   private static int NUM_ITEMS = 10;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return MainActivity.tolist.size();
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {

            return FirstFragment.newInstance(MainActivity.tolist.get(position));
        }


    }
}



