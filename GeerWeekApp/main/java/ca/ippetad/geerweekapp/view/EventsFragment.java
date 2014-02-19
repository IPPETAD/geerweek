package ca.ippetad.geerweekapp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import ca.ippetad.geerweekapp.R;
import ca.ippetad.geerweekapp.model.Event;

import java.util.ArrayList;
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

        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        List<Event> events = new ArrayList<Event>();

        events.add(new Event("Battle of the Bands", "CompE is going to win this."));
        events.add(new Event("Movie Night", "We'll also win this."));
        listView.setAdapter(new CustomArrayAdapter(rootView.getContext(), R.layout.events_row, events));


        ListView listview = (ListView) rootView.findViewById(R.id.listview);
        return rootView;
    }

    private class CustomArrayAdapter extends ArrayAdapter<Event> {

        private List<Event> items;
        private Context context;

        public CustomArrayAdapter(Context context, int resource, List<Event> items) {
            super(context, resource, items);
            this.items = items;
            this.context = context;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View baseView = inflater.inflate(R.layout.events_row, parent, false);

            /* Layout items */
            ImageView eventIcon = (ImageView) baseView.findViewById(R.id.icon);
            TextView txtName = (TextView) baseView.findViewById(R.id.txtName);
            TextView txtDate = (TextView) baseView.findViewById(R.id.date);
            TextView txtSubject = (TextView) baseView.findViewById(R.id.txtDescription);
            TextView txtLocation = (TextView) baseView.findViewById(R.id.location);

            eventIcon.setImageResource(R.drawable.aystafy);
            txtName.setText(items.get(position).name);
            txtDate.setText("sometime..");
            txtSubject.setText(items.get(position).description);
            txtLocation.setText("Somewhere");

            return baseView;
        }
    }
}

