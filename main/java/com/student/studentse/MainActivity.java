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

        Button ACMbutton = (Button) findViewById( R.id.btnACM );
        ACMbutton.setOnClickListener( this );
        Button CSbutton = (Button) findViewById( R.id.btnCS );
        CSbutton.setOnClickListener( this );
        Button CDCbutton = (Button) findViewById( R.id.btnCDC );
        CDCbutton.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent( this, ClubViewActivity.class );

        switch (v.getId())
        {
            case R.id.btnACM:
                intent.putExtra("club", "ACM");
                startActivity(intent);
                break;
            case R.id.btnCS:
                intent.putExtra("club", "CS Club");
                startActivity(intent);
                break;
            case R.id.btnCDC:
                intent.putExtra("club", "CDC");
                startActivity(intent);
                break;
        }
    }
}
