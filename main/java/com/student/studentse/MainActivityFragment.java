package com.student.studentse;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.net.Uri;
import android.content.Intent;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends android.app.Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.fragment_main, container, false );

        return view;
    }

    public void SetText(String club) {
        // method used to set text of text boxes and buttons' on click URLs based on club name
        // from parameters
        TextView orgName = getView().findViewById( R.id.textView );
        orgName.setText( club ); //change textview text to club name passed through the parameters

        if (club.equalsIgnoreCase( "acm" )) {
            //if club name is ACM fill the textboxes with the corresponding club information
            //and set on click listeners for the web and chat buttons. On button click, make the
            //buttons go to the club's web and chat pages
            TextView aboutus = getView().findViewById( R.id.txtAbout );
            Button b1 = getView().findViewById( R.id.btnWebsite );
            Button b2 = getView().findViewById( R.id.btnChat );

            aboutus.setText( "ACM-SEMO has dedicated itself to fostering the growth of interest " +
                    "in computing, and also focuses on providing college students with skills " +
                    "that they may not find inside the classroom.\n" );

            b1.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("https://acmsemo.github.io"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            } );
            b2.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("https://discordapp.com/invite/Bhs2zGp"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            } );
        }
        else if (club.equalsIgnoreCase( "cs club" )) {
            //if club name is cs club fill the textboxes with the corresponding club information
            //and set on click listeners for the web and chat buttons. On button click, make the
            //buttons go to the club's web and chat pages
            TextView aboutus = getView().findViewById( R.id.txtAbout );
            Button b1 = getView().findViewById( R.id.btnWebsite );
            Button b2 = getView().findViewById( R.id.btnChat );

            aboutus.setText( "Computer Science Club is a student organization intended to help " +
                    "grow the interest of Computer Science in students from any major and help " +
                    "students learn more about Computer Science outside of the classroom. Our " +
                    "topics vary from theoretical Computer Science and Mathematics to concrete " +
                    "applications.\n" );

            b1.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("https://www.facebook.com/groups/semocsc/"); // missing 'http://' will cause crash
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            } );
            b2.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("https://discord.gg/HcxnAr9"); // missing 'http://' will cause crash
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            } );
        }
        else if (club.equalsIgnoreCase( "cdc" )) {
            //if club name is CDC fill the textboxes with the corresponding club information
            //and set on click listeners for the web and chat buttons. On button click, make the
            //buttons go to the club's web and chat pages
            TextView aboutus = getView().findViewById( R.id.txtAbout );
            Button b1 = getView().findViewById( R.id.btnWebsite );
            Button b2 = getView().findViewById( R.id.btnChat );

            aboutus.setText( "The Cyber Defense Club was founded with the idea that it would be " +
                    "an extension of the classroom, going deeper into topics that are discussed " +
                    "in class.  We also aim to keep members up to date on current events in the " +
                    "field and discuss their direct affects on us personally and on the industry " +
                    "as a whole.\n" );

            b1.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("http://semocdc.com/"); // missing 'http://' will cause crash
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            } );
            b2.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("https://semocdc.slack.com/"); // missing 'http://' will cause crash
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            } );
        }
    }
}
