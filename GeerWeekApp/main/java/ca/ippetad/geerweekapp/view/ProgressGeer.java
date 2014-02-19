package ca.ippetad.geerweekapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import ca.ippetad.geerweekapp.R;

/**
 * Created by James on 2/18/14.
 */
public class ProgressGeer extends ImageView {

    public ProgressGeer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public ProgressGeer(Context context) {
        super(context);
        init(context);
    }
    private void init(Context c) {
        Animation aGeer = AnimationUtils.loadAnimation(c, R.anim.geer_spin);
        setBackgroundResource(R.drawable.geer);
        startAnimation(aGeer);
    }
}
