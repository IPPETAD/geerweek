package ca.ippetad.geerweekapp.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ca.ippetad.geerweekapp.R;

/**
 * Created by James on 2/14/14.
 */
public class CustomTopBar extends LinearLayout {

    private ImageView btn;

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
        setBackground(getResources().getDrawable(R.drawable.topbar));

        /** ICON **/
        btn = new ImageView(getContext());
        btn.setImageDrawable(getResources().getDrawable(R.drawable.ic_drawer));
        LinearLayout.LayoutParams blp = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        blp.gravity = Gravity.CENTER_VERTICAL;
        blp.setMargins(25, 0, 30, 0);
        btn.setLayoutParams(blp);
        btn.setClickable(true);

        /** TITLE **/
        TextView title = new TextView(getContext());
        title.setText("Geer Week");
        title.setTypeface(Typeface.SERIF, Typeface.BOLD);
        title.setTextColor(Color.WHITE);
        title.setTextSize(18f);
        title.setPadding(5,30,5,30);


        addView(btn);
        addView(title);
    }
    public void setOnDrawerClickListener(OnClickListener l) {
        btn.setOnClickListener(l);
    }
}
