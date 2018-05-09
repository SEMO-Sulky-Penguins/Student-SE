package com.student.studentse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by stephen on 5/5/2018.
 */

public class DBActivity extends AppCompatActivity {

    public ListView listView; //we'll be displaying stuff in this

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_view);

        this.listView = (ListView) findViewById(R.id.dbListView);
        DBAccessor accessor = DBAccessor.getInstance(this); //getting a database instance
        accessor.open(); //opening the connection
        try {
            List<String> info = getSelection(accessor); //this grabs our database result in list format
            //using an arrayadapter to communicate between list and listview
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, info);
            //our list info gets displayed in the listview via adapter
            this.listView.setAdapter(adapter);
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
        //cleaning up
        accessor.close();
    }

    //this is used to decide which table of information to get based upon which button the user clicked
    //it then makes a call in DBAccessor to run a query for the requested information in the database
    private List<String> getSelection(DBAccessor accessor) {
        try {
            Intent intent = getIntent();
            String infoToGet = intent.getStringExtra("info");
            if (infoToGet.equals("events")) return accessor.getEvents();
            else if (infoToGet.equals("internships")) return accessor.getInternships();
            else if (infoToGet.equals("research")) return accessor.getResearch();
            else return accessor.getJobs();
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return Collections.<String>emptyList();
        //program couldn't figure it out, just return a bundle of emptiness, crushed hopes, and unfulfillment
    }
}
