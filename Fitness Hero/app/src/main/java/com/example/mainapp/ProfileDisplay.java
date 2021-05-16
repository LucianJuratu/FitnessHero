package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileDisplay extends AppCompatActivity {
    String name;
    String age;
    String gender;
    String height;
    String weight;
    String activity;
    int age2;
    int weight2;
    int height2;
    int activity2;
    TextView editAge;
    TextView editWeight;
    TextView editheight;
    TextView editName;
    TextView editActivity;
    TextView editGender;
    public void onBackPressed() {
        Intent i = new Intent(ProfileDisplay.this, NavigationActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_display);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        name = pref.getString("name", "notfound");
        gender = pref.getString("gender", "notfound");
        age2 = pref.getInt("age", 0);
        height2 = pref.getInt("height", 0);
        weight2 = pref.getInt("weight", 0);
        activity2 = pref.getInt("level", 0);
        age = String.valueOf(age2);
        height = String.valueOf(height2);
        weight = String.valueOf(weight2);
        activity = String.valueOf(activity2);
        editAge = (TextView) findViewById(R.id.displayage);
        editWeight = (TextView) findViewById(R.id.displayweight);
        editheight = (TextView) findViewById(R.id.displayheight);
        editName = (TextView) findViewById(R.id.displayname);
        editGender = (TextView) findViewById(R.id.displaygender);
        editActivity = (TextView) findViewById(R.id.displayactivity);
        editName.setText("Name: " + name);
        editWeight.setText("Weight: " + weight + " kg");
        editheight.setText("Height: " + height + " cm");
        editGender.setText("Gender: " + gender);
        editAge.setText("Age: " + age + " years");
        editActivity.setText("Activity Level: " + activity);
        Button editprofile;
        editprofile = (Button) findViewById(R.id.editprofilebutton);
        editprofile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(ProfileDisplay.this, Profile.class);
                startActivity(i);


            }


        });
    }
}