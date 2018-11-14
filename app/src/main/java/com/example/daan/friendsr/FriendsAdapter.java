package com.example.daan.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private String context;
    private ArrayList<Friend> friends;

    public FriendsAdapter( Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        this.friends = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        TextView name = convertView.findViewById(R.id.name);
        name.setText(friends.get(position).getName());
        ImageView pp = convertView.findViewById(R.id.pp);
        pp.setImageResource(friends.get(position).getDrawableId());
        return convertView;
    }
}
