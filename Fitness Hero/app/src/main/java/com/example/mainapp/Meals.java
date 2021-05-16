package com.example.mainapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Meals extends AppCompatActivity {
    List<String> sample=new ArrayList<>();

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(Meals.this, FoodSettings.class);
        startActivity(i);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        ListView listView = (ListView) findViewById(R.id.listofmeals);
        Gson gson = new Gson();
        String json = pref.getString("mymeals", "empty");


        if (!json.equals("empty")) {
            String[] string = gson.fromJson(json, String[].class);

            sample = new ArrayList<String>(Arrays.asList(string));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sample);
            listView.setAdapter(adapter);
            List<String> finalSample = sample;
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    finalSample.remove(i);
                    adapter.notifyDataSetChanged();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    Gson gson = new Gson();
                    String text = gson.toJson(finalSample);
                    editor.putString("mymeals", text);
                    editor.commit();
                    return true;
                }
            });
        } else {
            List<String> sample2 = new ArrayList<>();
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sample2);
            sample2.add("You did not add any meal yet!");
            listView.setAdapter(adapter2);
        }

        Button tosets;
        tosets = (Button) findViewById(R.id.mealback);
        tosets.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(Meals.this, FoodSettings.class);
                startActivity(i);


            }


        });
        Button deleteall;
        deleteall = (Button) findViewById(R.id.removemeal);
        deleteall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Meals.this);
                builder.setTitle("Are you sure you want to remove all the meals?");
                String[] options = {"Yes", "Cancel"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:

                                editor.putString("mymeals", "empty");
                                editor.commit();
                                Intent i = new Intent(Meals.this, Meals.class);
                                startActivity(i);

                                break;

                            case 1:

                                break;


                        }
                    }
                });

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


    public void addItems(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Meals.this);
        builder.setTitle("Enter Meal:");


        final EditText input = new EditText(Meals.this);

        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = input.getText().toString();
                if(text.length()!=0) {
                    if (!sample.contains(text)) {
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        sample.add(text);
                        Gson gson = new Gson();
                        String myexercises = gson.toJson(sample);
                        editor.putString("mymeals", myexercises);
                        editor.commit();
                        Intent i = new Intent(Meals.this, Meals.class);
                        startActivity(i);
                    }


                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }
}