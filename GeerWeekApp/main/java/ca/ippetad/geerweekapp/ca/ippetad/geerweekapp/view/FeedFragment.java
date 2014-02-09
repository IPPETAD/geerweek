package ca.ippetad.geerweekapp.ca.ippetad.geerweekapp.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ca.ippetad.geerweekapp.R;

/**
 * Created by James on 2/8/14.
 */
public class FeedFragment extends Fragment{

    public FeedFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter(rootView.getContext(), android.R.layout.simple_list_item_1,
                new String[]{"twitter feed here"}));

        return rootView;
    }

}
