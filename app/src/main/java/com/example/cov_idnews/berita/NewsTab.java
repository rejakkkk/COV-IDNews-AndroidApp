package com.example.cov_idnews.berita;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.cov_idnews.HelpTab;
import com.example.cov_idnews.MainActivity;
import com.example.cov_idnews.R;
import com.example.cov_idnews.berita.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class NewsTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_tab);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("All News"));
        tabLayout.addTab(tabLayout.newTab().setText("Case"));
        tabLayout.addTab(tabLayout.newTab().setText("Economy"));
        tabLayout.addTab(tabLayout.newTab().setText("Sciencce"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager pagerr = findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        pagerr.setAdapter(adapter);
        pagerr.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pagerr.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void coba(View view) {
        Intent intent = new Intent(NewsTab.this, MainActivity.class);
        startActivity(intent);
    }
}