package com.example.mainapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class WelcomeNext extends AppCompatActivity {

    String name;
    String regex = "[0-9]+";
    String weight;
    String height;
    String age;
    String gender;
    Button mButton;
    EditText editage;
    EditText editweight;
    EditText editheight;
    EditText editgender;
    boolean allgood=true;
    List valid = Arrays.asList("M","F");

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_next);
        mButton = findViewById(R.id.button2);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        name = pref.getString("name","defaultValue");
        TextView display = findViewById(R.id.textView2);
        display.setText("Welcome "+name);
        mButton.setOnClickListener(view -> {
            editage = findViewById(R.id.age);
            editheight = findViewById(R.id.height);
            editweight = findViewById(R.id.weight);
            editgender = findViewById(R.id.gender);
            age = editage.getText().toString();
            weight = editweight.getText().toString();
            height = editheight.getText().toString();
            gender = editgender.getText().toString();

            if (age.length() == 0) {
                editage.setError("Age is required!");
                allgood = false;
            } else if (!age.matches(regex)) {
                editage.setError("Age must be a number!");
                allgood = false;
            }

            if (height.length() == 0) {
                editheight.setError("Height is required!");
                allgood = false;
            } else if (!height.matches(regex)) {
                editheight.setError("Height must be a number!");
                allgood = false;
            }
            if (weight.length() == 0) {
                editweight.setError("Weight is required!");
                allgood = false;
            } else if (!weight.matches(regex)) {
                editweight.setError("Weight must be a number!");
                allgood = false;
            }

            if (gender.length() == 0) {
                editgender.setError("Gender is required!");
                allgood = false;

            } else if (!valid.contains(gender)) {
                editgender.setError("Gender must be M or F!");
                allgood = false;
            }
            if(allgood)
            {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("gender", gender);
                int age2 = Integer.parseInt(age);
                int height2= Integer.parseInt(height);
                int weight2= Integer.parseInt(weight);
                editor.putInt("age",age2);
                editor.putInt("height",height2);
                editor.putInt("weight",weight2);
                editor.commit();
                Intent i = new Intent(WelcomeNext.this, WelcomeFinal.class);
                startActivity(i);
            }
            else
                allgood=true;



        });


    }
}