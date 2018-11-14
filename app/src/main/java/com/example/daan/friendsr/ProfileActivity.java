package com.example.daan.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            TextView nameView = findViewById(R.id.name);
            String name = (String) nameView.getText();
            editor.putFloat(name, rating);
            editor.apply();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        RatingBar gv = findViewById(R.id.ratingBar);
        gv.setOnRatingBarChangeListener(new OnRatingBarChangeListener());

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView pp = findViewById(R.id.pp);
        pp.setImageDrawable(getResources().getDrawable(retrievedFriend.getDrawableId()));
        TextView name = findViewById(R.id.name);
        name.setText(retrievedFriend.getName());
        TextView bio = findViewById(R.id.bio);
        bio.setText(retrievedFriend.getBio());

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        String nameText = (String) name.getText();
        Float aStoredString = prefs.getFloat(nameText, 0);

        RatingBar rating = findViewById(R.id.ratingBar);
        rating.setRating(aStoredString);


    }
}
