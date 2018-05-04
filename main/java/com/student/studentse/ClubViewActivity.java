package com.student.studentse;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by simoneruffin on 3/2/18.
 */

public class ClubViewActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_page_view);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String club = intent.getStringExtra( "club" );
        MainActivityFragment fragment = (MainActivityFragment) getFragmentManager().findFragmentById( R.id.fragmentClub );
        fragment.SetText(club);
    }
}
