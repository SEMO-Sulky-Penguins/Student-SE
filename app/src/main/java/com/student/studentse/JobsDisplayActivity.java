package com.student.studentse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class JobsDisplayActivity extends AppCompatActivity {

    TextView titleTextView, createTextView, typeTextView,
            locationTextView, descriptionTextView, urlTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs_display);

        titleTextView = findViewById(R.id.titleTextView);
        createTextView = findViewById(R.id.createdTextView);
        typeTextView = findViewById(R.id.typeTextView);
        locationTextView = findViewById(R.id.locationTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        urlTextView = findViewById(R.id.urlTextView);

        setStrings();
    }

    protected void setStrings(){
        String title, created, type, location, description, url;
        Intent i = getIntent();

        title = stripHtml(i.getStringExtra("title"));
        created = stripHtml(i.getStringExtra("create_at"));
        type = stripHtml(i.getStringExtra("type"));
        location = stripHtml(i.getStringExtra("location"));
        description = stripHtml(i.getStringExtra("description"));
        url = stripHtml(i.getStringExtra("url"));

        titleTextView.append(title);
        createTextView.append(created);
        typeTextView.append(type);
        locationTextView.append(location);
        descriptionTextView.append(description);
        urlTextView.append(url);
    }

    public String stripHtml(String html)
    {
        return (html != null) ? Html.fromHtml(html).toString() : "";
    }
}
