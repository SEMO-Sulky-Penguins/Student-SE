package com.student.studentse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set on click listeners for each club button
        Button ACMbutton = (Button) findViewById( R.id.btnACM );
        ACMbutton.setOnClickListener( this );
        Button CSbutton = (Button) findViewById( R.id.btnCS );
        CSbutton.setOnClickListener( this );
        Button CDCbutton = (Button) findViewById( R.id.btnCDC );
        CDCbutton.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        //initialize a new intent to start club page fragment on button click
        Intent intent = new Intent( this, ClubViewActivity.class );

        //switch case to add information to fragment based on the button that was clicked
        switch (v.getId())
        {
            case R.id.btnACM:
                intent.putExtra("club", "ACM");//sending club name through intent
                startActivity(intent);//start the intent
                break;
            case R.id.btnCS:
                intent.putExtra("club", "CS Club");//sending club name through intent
                startActivity(intent);//start intent
                break;
            case R.id.btnCDC:
                intent.putExtra("club", "CDC");//sending club name through intent
                startActivity(intent);//start intent
                break;
        }
    }
}
