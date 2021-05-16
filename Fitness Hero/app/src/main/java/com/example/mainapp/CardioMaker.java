package com.example.mainapp;

import androidx.appcompat.app.AlertDialog;


import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CardioMaker extends ListActivity {
    String[] string=null;
    String text="";
    String pause="";
    String worktime;
    ArrayList<String> listItems=new ArrayList<String>();
    boolean check=false;
    ArrayAdapter<String> adapter;
   String myexercises;
   List<String> exercises =new ArrayList<String>();
    String regex = "[0-9]+";
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(CardioMaker.this, WorkoutSettings.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        myexercises=pref.getString("myexercises","empty");
        if(!myexercises.equals("empty")) {
            Gson gson = new Gson();
             string = gson.fromJson(myexercises, String[].class);
            exercises =new ArrayList<String>(Arrays.asList(string));
        }
        setContentView(R.layout.activity_cardio_maker);
        adapter=new ArrayAdapter<String>(CardioMaker.this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please enter time of work and rest");

        final EditText input = new EditText(this);
        final EditText input2= new EditText(this);

        input.setInputType(InputType.TYPE_CLASS_TEXT );
        input2.setInputType(InputType.TYPE_CLASS_TEXT );
        input.setHint("Work:");
        input2.setHint("Rest:");
        LinearLayout lay = new LinearLayout(this);
        lay.setOrientation(LinearLayout.VERTICAL);
        lay.addView(input);
        lay.addView(input2);
        builder.setView(lay);



        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                worktime = input.getText().toString();
                pause=input2.getText().toString();
                    if (worktime.length()!=0 && pause.length()!=0 && pause.matches(regex) && worktime.matches(regex))
                    {

                    }
                    else
                        {
                            Intent intent = new Intent(CardioMaker.this, CardioMaker.class);
                            startActivity(intent);
                    }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Intent intent = new Intent(CardioMaker.this, WorkoutSettings.class);
                startActivity(intent);
            }
        });

        builder.show();
        Button cancelbutton = (Button) findViewById(R.id.cardiocancelbutton);
        cancelbutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                Intent i = new Intent(CardioMaker.this, WorkoutSettings.class);
                                                startActivity(i);
                                            }


                                        }


        );
        FloatingActionButton finishbutton=(FloatingActionButton) findViewById(R.id.cardiodonebutton);
        finishbutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                                                SharedPreferences.Editor editor = pref.edit();
                                                int day=pref.getInt("workday",0);
                                    
                                             
                                                    if (day == 1) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("workout1", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("workoutday1",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("workoutday1",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(CardioMaker.this, WorkoutSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 2) {

                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("workout2", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("workoutday2",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("workoutday2",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(CardioMaker.this, WorkoutSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 3) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("workout3", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("workoutday3",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("workoutday3",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(CardioMaker.this, WorkoutSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 4) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("workout4", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("workoutday4",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("workoutday4",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(CardioMaker.this, WorkoutSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 5) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("workout5", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("workoutday5",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("workoutday5",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(CardioMaker.this, WorkoutSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 6) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("workout6", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("workoutday6",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("workoutday6",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(CardioMaker.this, WorkoutSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 7) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("workout7", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("workoutday7",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("workoutday7",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(CardioMaker.this, WorkoutSettings.class);
                                                        startActivity(i);
                                                    }
                                                
                                          
                                            }


                                        }


        );
    }


    public void addItems(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(CardioMaker.this);
        builder.setTitle("Enter Exercise:");


      //     final EditText input = new EditText(CardioMaker.this);


           final AutoCompleteTextView input = new AutoCompleteTextView(CardioMaker.this);
           if(string!=null) {
               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                       android.R.layout.simple_dropdown_item_1line, string);
               input.setAdapter(adapter2);
           }
           input.setInputType(InputType.TYPE_CLASS_TEXT);
           builder.setView(input);



        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 text = input.getText().toString();
                if(text.length()!=0) {
                    if (!exercises.contains(text)) {
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();
                        exercises.add(text);
                        Gson gson = new Gson();
                        myexercises = gson.toJson(exercises);
                        editor.putString("myexercises", myexercises);
                        editor.commit();
                        String ex=pref.getString("myexercises","empty");
                        string = gson.fromJson(ex, String[].class);
                        exercises =new ArrayList<String>(Arrays.asList(string));
                    }
                    adapter.add(text + " x " + worktime + " s");
                    adapter.add("break " + pause + " s");

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