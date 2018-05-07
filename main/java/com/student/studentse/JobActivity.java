package com.student.studentse.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JobActivity extends AppCompatActivity {
    JSONArray jsonArray;
    JSONObject jsonObj;
    URL url;
    String baseUrl = "http://jobs.github.com/positions.json?description=", loc, field, jTitle, jLoc, Jtype, Jdescription, jUrl, jCreated;
    EditText locEditText, fieldEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        locEditText = findViewById(R.id.locationEditText);
        fieldEditText = findViewById(R.id.fieldEditText);
        Button jobButton = (Button) findViewById(R.id.btnJobs);
        jobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loc = locEditText.getText().toString();
                field = fieldEditText.getText().toString();
                loc = loc.replace(' ', '+');
                baseUrl += field + "&location=" + loc;
                try {
                    url = new URL(baseUrl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (url != null) {
                    GetJobsTask getJobsTask = new GetJobsTask();
                    getJobsTask.execute(url);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.invalid_url, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }




    private class GetJobsTask extends AsyncTask<URL, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(URL... params) {
            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) params[0].openConnection();
                int response = connection.getResponseCode();

                if (response == HttpURLConnection.HTTP_OK) {
                    StringBuilder builder = new StringBuilder();

                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()))) {

                        String line;

                        while ((line = reader.readLine()) != null) {
                            builder.append(line);
                        }
                    }
                    catch (IOException e) {
                        Toast.makeText(getApplicationContext(),R.string.read_error,Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    return new JSONObject(builder.toString());
                }
                else {
                    Toast.makeText(getApplicationContext(),R.string.connect_error,Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(),R.string.connect_error,Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            finally {
                connection.disconnect();
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject article) {
            convertJSONtoArrayList(article);
        }
    }
    private void newActivityFunction(){
        final Intent i = new Intent (this, JobsDisplayActivity.class);
        i.putExtra("created_at", jCreated);
        i.putExtra("title", jTitle);
        i.putExtra("location", jLoc);
        i.putExtra("type", Jtype);
        i.putExtra("description", Jdescription);
        i.putExtra("url", jUrl);

        startActivity(i);
    }

    private void convertJSONtoArrayList(JSONObject response) {

        try {
            jsonArray = new JSONArray(response);

            jsonObj = (JSONObject) jsonArray.get(0);

            jCreated = jsonObj.getString("created_at");
            jTitle = jsonObj.getString("title");
            jLoc = jsonObj.getString("location");
            Jtype = jsonObj.getString("type");
            Jdescription = jsonObj.getString("description");
            jUrl = jsonObj.getString("url");

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
