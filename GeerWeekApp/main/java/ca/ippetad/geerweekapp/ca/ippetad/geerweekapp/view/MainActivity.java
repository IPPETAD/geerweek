/*
 * Copyright (c) 2014 Andrew Fontaine, James Finlay, Jesse Tucker, Jacob Viau, and Evan DeGraff
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package ca.ippetad.geerweekapp.ca.ippetad.geerweekapp.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import ca.ippetad.geerweekapp.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.List;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   /*     if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new FeedFragment())
                    .commit();
        }*/


        /** FRAGMENTS **/
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter pager_adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pager_adapter);

        /** SLIDING MENU **/
        SlidingMenu slide = new SlidingMenu(this);
        slide.setMode(SlidingMenu.LEFT);
        slide.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slide.setBehindOffset(250);
        slide.setFadeDegree(.9f);
        slide.setBackgroundColor(Color.parseColor("#444444"));
        slide.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slide.setMenu(R.layout.layout_menu);

        ListView sliderList = (ListView) slide.getRootView().findViewById(R.id.listview);
        CustomArrayAdapter slider_adapter = new CustomArrayAdapter(this, android.R.layout.simple_list_item_1,
                new String[]{"Home", "Events", "Kidnapping", "Godiva", "Misc"});
        sliderList.setAdapter(slider_adapter);
        sliderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        // Home
                    case 1:
                        // Events
                    case 2:
                        // Kidnapping
                    case 3:
                        // Godiva
                    case 4:
                        // Misc
                }
            }
        });

    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private FeedFragment _feed;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);

            _feed = new FeedFragment();
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return _feed;

            }
            return null;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
    public class CustomArrayAdapter<String> extends ArrayAdapter<String> {


        public CustomArrayAdapter(Context context, int resource, List<String> items) {
            super(context, resource, items);
        }
        public CustomArrayAdapter(Context context, int resource, String[] items) {
            super(context, resource, items);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getView(position, convertView, parent);
            view.setTextColor(Color.WHITE);
            return view;
        }

    }
}
