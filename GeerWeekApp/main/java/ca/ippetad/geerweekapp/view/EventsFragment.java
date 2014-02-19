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

        events.add(new Event("Battle of the Bands", "CompE is going to win this.", R.drawable.botb));
        events.add(new Event("Movie Night", "We'll also win this.", R.drawable.movie));
        events.add(new Event("Banquet Night", "bla balb blalblbla blba blabla balblab alblablabl bla bla bla bla", R.drawable.banquet));
        events.add(new Event("Design Competition", "I noticed a bit of lag. Going to reduce image size. Maybe we could load them asynchronously?", R.drawable.design));
        events.add(new Event("Scavenger Hunt", "Update: That definitely reduced lag a bit by storing them smaller. May still want to load them asynchronously..", R.drawable.hunt));
        events.add(new Event("Keg Race", "", R.drawable.kegs));
        events.add(new Event("After party!!", "", R.drawable.party));
        events.add(new Event("Shangria", "", R.drawable.shangria));
        events.add(new Event("Tech Display", "", R.drawable.tech));
        events.add(new Event("Toboggan Race", "Should these icons be a lighter shade of brown?", R.drawable.toboggan));
        events.add(new Event("Tug Of War", "", R.drawable.tow));
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

            eventIcon.setImageResource(items.get(position).resource_icon);
            txtName.setText(items.get(position).name);
            txtDate.setText("sometime..");
            txtSubject.setText(items.get(position).description);
            txtLocation.setText("Somewhere");

            return baseView;
        }
    }
}

