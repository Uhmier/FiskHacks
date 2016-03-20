package com.example.uhmier.fiskhacks;

/**
 * Created by Uhmier on 3/19/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created on 10/17/15.
 *
 * @author Upendra Dhakal
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventHolder> {

    List<Event> list;
    Activity activity;

    public EventsAdapter(Activity activity, List<Event> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_event, parent, false);
        return new EventHolder(v);
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        Event currEvent = list.get(position);
        holder.mEventNameView.setText(currEvent.getName());
        holder.mDateView.setText(currEvent.getDate() + "\t" + currEvent.getTime());
        holder.mAuthorView.setText(currEvent.getAuthor());
        holder.mEventLocationView.setText(currEvent.getLocation());
        /**holder.mEventNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, EventActivity.class);
                intent.putExtra("id", currEvent.getObjectId());
                activity.startActivity(intent);
            }
        });
         **/


    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    class EventHolder extends RecyclerView.ViewHolder {
        private TextView mEventNameView;
        private TextView mEventLocationView;
        private TextView mDateView;
        private TextView mAuthorView;

        public EventHolder(View itemView) {
            super(itemView);
            mEventLocationView = (TextView) itemView.findViewById(R.id.textViewEventLocation);
            mEventNameView = (TextView) itemView.findViewById(R.id.textViewEventName);
            mDateView = (TextView) itemView.findViewById(R.id.textViewEventDate);
            mAuthorView = (TextView) itemView.findViewById(R.id.textViewEventAuthor);

        }
    }
}
