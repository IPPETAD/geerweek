package ca.ippetad.geerweekapp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import ca.ippetad.geerweekapp.R;
import ca.ippetad.geerweekapp.model.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2/8/14.
 */
public class FeedFragment extends Fragment {
    private static final String TAG = "FeedFragment";

    public FeedFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        List<Tweet> tweets = new ArrayList<Tweet>();
        Tweet t = new Tweet();
        t.name = "Don Iveson";
        t.msg = "I'll totally check out your hackathon! #yoloswag4jesus #compeclubfuckyeah";
        tweets.add(t);
        listView.setAdapter(new CustomArrayAdapter(rootView.getContext(), R.layout.twitter_row, tweets));

        return rootView;
    }

    private class CustomArrayAdapter extends ArrayAdapter<Tweet> {

        private List<Tweet> items;
        private Context context;

        public CustomArrayAdapter(Context context, int resource, List<Tweet> items) {
            super(context, resource, items);
            this.items = items;
            this.context = context;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View baseView = inflater.inflate(R.layout.twitter_row, parent, false);

            /* Layout items */
            ImageView profilePic = (ImageView) baseView.findViewById(R.id.profile_pic);
            TextView txtName = (TextView) baseView.findViewById(R.id.txtName);
            TextView txtSubject = (TextView) baseView.findViewById(R.id.txtMessage);

            txtName.setText(items.get(position).name);
            txtSubject.setText(items.get(position).msg);

            return baseView;
        }
    }
}
