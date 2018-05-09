package com.student.studentse;

import android.annotation.TargetApi;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JobActivity extends AppCompatActivity implements View.OnClickListener {
    JSONArray jsonArray;
    JSONObject jsonObj;
    URL url;
    String baseUrl = "https://jobs.github.com/positions.json?description=", loc, field, jTitle, jLoc, Jtype, Jdescription, jUrl, jCreated;
    EditText locEditText, fieldEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        locEditText = findViewById(R.id.locationEditText);
        fieldEditText = findViewById(R.id.fieldEditText);
        Button jobButton = (Button) findViewById(R.id.buttonJob);
        jobButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        loc = locEditText.getText().toString();
        field = fieldEditText.getText().toString();
        if(!loc.isEmpty()) {
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
    }

    private class GetJobsTask extends AsyncTask<URL, Void, JSONArray> {

        String streamToString(InputStream stream) throws IOException{
            StringBuilder result = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(stream)
                );
                String data;

                while ((data = reader.readLine()) != null) {
                    result.append(data);
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            stream.close();
            return result.toString();
        }

        @Override
        protected JSONArray doInBackground(URL... params) {
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) params[0].openConnection();
                int response = connection.getResponseCode();

                if (response == HttpURLConnection.HTTP_OK) {
                    String responseString = streamToString(connection.getInputStream());
                    return new JSONArray(responseString);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                connection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONArray jArray)
        {
            convertJSONtoArrayList(jArray);
            newActivityFunction();
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

    @TargetApi(19)
    private void convertJSONtoArrayList(JSONArray jArray) {
        try {
            //jsonObj = jArray.getJSONObject(0);
            jsonObj = (JSONObject) jArray.get(0);
            jCreated = jsonObj.optString("created_at");
            jTitle = jsonObj.optString("title");
            jLoc = jsonObj.optString("location");
            Jtype = jsonObj.optString("type");
            Jdescription = jsonObj.optString("description");
            jUrl = jsonObj.optString("url");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}