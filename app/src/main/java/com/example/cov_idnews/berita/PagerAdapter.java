package com.example.cov_idnews.berita;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int nameFragment;

    public PagerAdapter(@NonNull FragmentManager fm, int nameTab) {
        super(fm);
        nameFragment = nameTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new FragmentAllNews();
            case 1 : return new FragmentCase();
            case 2 : return new FragmentHandling();
            case 3 : return new FragmentTechnology();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return nameFragment;
    }
}
