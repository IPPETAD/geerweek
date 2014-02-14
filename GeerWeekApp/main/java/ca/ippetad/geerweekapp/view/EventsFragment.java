package ca.ippetad.geerweekapp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ca.ippetad.geerweekapp.R;
import ca.ippetad.geerweekapp.model.Event;

import java.util.List;

/**
 * Created by James on 2/8/14.
 */
public class EventsFragment extends Fragment {

    public EventsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.listview);

        return rootView;
    }

    private class CustomArrayAdapter extends ArrayAdapter<Event> {

        public CustomArrayAdapter(Context context, int resource, List<Event> objects) {
            super(context, resource, objects);
        }
    }
}
