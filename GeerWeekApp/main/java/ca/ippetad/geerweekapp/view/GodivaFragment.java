package ca.ippetad.geerweekapp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ca.ippetad.geerweekapp.R;

/**
 * Created by James on 2/8/14.
 */
public class GodivaFragment extends Fragment {

    public GodivaFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_godiva, container, false);


        return rootView;
    }
}

