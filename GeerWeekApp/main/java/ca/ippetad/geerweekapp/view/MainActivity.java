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

package ca.ippetad.geerweekapp.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.view.*;
import android.widget.*;
import ca.ippetad.geerweekapp.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.List;

public class MainActivity extends FragmentActivity {

    private FeedFragment _feed;
    private EventsFragment _events;
    private KidnapFragment _kidnap;
    private GodivaFragment _godiva;
    private MiscFragment _misc;

    private int VISIBLE = 0;
    private int HIDDEN = 1;
    private int MENU_STATE = VISIBLE;

    private FrameLayout _frame;
    private SlidingMenu _slide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /** FRAGMENTS **/
        _frame = (FrameLayout) findViewById(R.id.container);

        _feed = new FeedFragment();
        _events = new EventsFragment();
        _kidnap = new KidnapFragment();
        _godiva = new GodivaFragment();
        _misc = new MiscFragment();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, _feed).commit();
        }


        /** SLIDING MENU **/
        _slide = new SlidingMenu(this);
        _slide.setMode(SlidingMenu.LEFT);
        _slide.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        _slide.setBehindOffset(250);
        _slide.setFadeDegree(.9f);
        _slide.setBackgroundColor(Color.parseColor("#444444"));
        _slide.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        _slide.setMenu(R.layout.layout_menu);

        _slide.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {
            @Override
            public void onOpened() {
                MENU_STATE = HIDDEN;
                invalidateOptionsMenu();
            }
        });
        _slide.setOnClosedListener(new SlidingMenu.OnClosedListener() {
            @Override
            public void onClosed() {
                MENU_STATE = VISIBLE;
                invalidateOptionsMenu();
            }
        });

        ListView sliderList = (ListView) _slide.getRootView().findViewById(R.id.listview);
        CustomArrayAdapter slider_adapter = new CustomArrayAdapter(this, android.R.layout.simple_list_item_1,
                new String[]{"Home", "Events", "Kidnapping", "Godiva", "Misc"});
        sliderList.setAdapter(slider_adapter);
        sliderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, _feed)
                                .addToBackStack(null).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, _events)
                                .addToBackStack(null).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, _kidnap)
                                .addToBackStack(null).commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, _godiva)
                                .addToBackStack(null).commit();
                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, _misc)
                                .addToBackStack(null).commit();
                        break;
                }
                _slide.toggle();
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        if (MENU_STATE == VISIBLE)
            menu.getItem(0).setVisible(true);
        else
            menu.getItem(0).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        _slide.toggle();
        return super.onOptionsItemSelected(item);
    }
}
