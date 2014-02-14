package ca.ippetad.geerweekapp.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by James on 2/14/14.
 */
public class CustomTopBar extends LinearLayout {
    public CustomTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public CustomTopBar(Context context) {
        super(context);
        setup();
    }
    private void setup() {
        setOrientation(HORIZONTAL);
        setBackgroundColor(Color.DKGRAY);

        TextView title = new TextView(getContext());
        title.setText("Geer Week 2015");
        title.setTextColor(Color.WHITE);
        title.setTextSize(18f);
        title.setPadding(5,30,5,30);


        addView(title);
    }
}
