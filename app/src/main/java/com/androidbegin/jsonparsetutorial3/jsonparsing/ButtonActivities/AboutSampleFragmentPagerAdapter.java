package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Snikdha on 8/20/2016.
 */
public class AboutSampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "ABOUT ME", "EQUIPMENT","BOOK USED" };

    public AboutSampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    // Returns total number of pages
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
       // return AboutBook_frag.newInstance(position + 1);

        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return AboutMe_frag.newInstance(0);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return AboutEquip_frag.newInstance(1);
          case 2: // Fragment # 1 - This will show SecondFragment
                return AboutBook_frag.newInstance(2);
            default:
                return null;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}




