package com.student.studentse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JobsDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs_display);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView createTextView = findViewById(R.id.createdTextView);
        TextView typeTextView = findViewById(R.id.typeTextView);
        TextView locationTextView = findViewById(R.id.locationTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        TextView urlTextView = findViewById(R.id.urlTextView);

        Intent i = getIntent();
        titleTextView.setText(i.getStringExtra("title"));
        createTextView.setText(i.getStringExtra("create_at"));
        typeTextView.setText(i.getStringExtra("type"));
        locationTextView.setText(i.getStringExtra("location"));
        descriptionTextView.setText(i.getStringExtra("description"));
        urlTextView.setText(i.getStringExtra("url"));
    }
}
