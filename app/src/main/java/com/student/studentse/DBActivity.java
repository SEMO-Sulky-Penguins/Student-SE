package com.student.studentse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by stephen on 5/5/2018.
 */

public class DBActivity extends AppCompatActivity {

    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_view);

        this.listView = (ListView) findViewById(R.id.dbListView);
        DBAccessor accessor = DBAccessor.getInstance(this);
        accessor.open();
        try {
            List<String> info = getSelection(accessor);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, info);
            this.listView.setAdapter(adapter);
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
        accessor.close();
    }

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
        return accessor.getJobs();
    }
}
