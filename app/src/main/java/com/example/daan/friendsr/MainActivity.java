package com.example.daan.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RatingBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Friend> friends = new ArrayList<>();
        GridView gv = findViewById(R.id.grid);
        gv.setOnItemClickListener(new GridItemClickListener());


        Friend jon = new Friend("Jon", "i know nothing",
                getResources().getIdentifier("jon",
                "drawable",
                getPackageName()));

        Friend sansa = new Friend("Sansa", "Winter is comming",
                getResources().getIdentifier("sansa",
                        "drawable",
                        getPackageName()));

        Friend tyrion = new Friend("Tyrion", "paying debts",
                getResources().getIdentifier("tyrion",
                        "drawable",
                        getPackageName()));

        Friend arya = new Friend("Arya", "a girl has no name",
                    getResources().getIdentifier("arya",
                        "drawable",
                        getPackageName()));

        Friend cersei = new Friend("Cersei", "paying debts",
                getResources().getIdentifier("cersei",
                        "drawable",
                        getPackageName()));

        Friend daenerys = new Friend("Daenerys", "salty AF",
                getResources().getIdentifier("daenerys",
                        "drawable",
                        getPackageName()));

        Friend jaime = new Friend("Jaime", "paying debts",
                getResources().getIdentifier("jaime",
                        "drawable",
                        getPackageName()));

        Friend jorah = new Friend("Jorah", "never love again",
                getResources().getIdentifier("jorah",
                        "drawable",
                        getPackageName()));

        Friend margaery = new Friend("Margaery", "paying debts",
                getResources().getIdentifier("margaery",
                        "drawable",
                        getPackageName()));

        Friend melisandre = new Friend("Melisandre", "paying debts",
                getResources().getIdentifier("melisandre",
                        "drawable",
                        getPackageName()));

        friends.add(jon);
        friends.add(sansa);
        friends.add(tyrion);
        friends.add(margaery);
        friends.add(melisandre);
        friends.add(jorah);
        friends.add(jaime);
        friends.add(daenerys);
        friends.add(cersei);
        friends.add(arya);
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(adapter);
    }
}
