package com.example.student1.allsaints;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SaintAdapter extends ArrayAdapter<Saint>  {
    private List<Saint> data;
    public SaintAdapter(@NonNull Context context, int resource, List<Saint> data) {
        super(context, resource);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Saint saint = data.get(position);
        View view = convertView;
        Context context = getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        Holder holder = null;
        if(view == null) {
            view = inflater.inflate(R.layout.listviewitem, parent, false);
            holder = new Holder();
            TextView name = (TextView) view.findViewById(R.id.text);
            TextView dob = (TextView) view.findViewById(R.id.dob);
            TextView dod = (TextView) view.findViewById(R.id.dod);
            RatingBar rating = (RatingBar) view.findViewById(R.id.rating);
            holder.name =  name;
            holder.dob =  dob;
            holder.dod =  dod;
            holder.rating =  rating;
            view.setTag(holder);
        }
        holder = (Holder) view.getTag();
        holder.name.setText(saint.getName());
        holder.dob.setText(saint.getDob());
        holder.dod.setText(saint.getDod());
        holder.rating.setRating(saint.getRating());

        return view;
    }

    ///


}
