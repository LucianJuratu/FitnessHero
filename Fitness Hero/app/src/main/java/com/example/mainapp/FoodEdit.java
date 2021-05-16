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
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FoodEdit extends ListActivity {
    String m_Text = "";
    String reps = "";
    String[] string=null;
    ArrayList<String> listItems = new ArrayList<String>();
    boolean check = false;
    String mymeals;
    List<String> meals=new ArrayList<>();
    ArrayAdapter<String> adapter;
    int totalcalories;
    String regex = "[0-9]+";
    String pause;
    int i=0;
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_food_edit);
        Button cancelbutton = (Button) findViewById(R.id.cancelmealbutton);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        mymeals=pref.getString("mymeals","empty");
        if(!mymeals.equals("empty")) {
            Gson gson = new Gson();
            string = gson.fromJson(mymeals, String[].class);
            meals =new ArrayList<String>(Arrays.asList(string));
        }

            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    listItems);
            setListAdapter(adapter);
        cancelbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                    startActivity(i);
                }


            }


        );
        FloatingActionButton finishbutton=(FloatingActionButton) findViewById(R.id.finishmealbutton);
        finishbutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                                                SharedPreferences.Editor editor = pref.edit();
                                                int day=pref.getInt("activeday",1);
                                                int activeplan=pref.getInt("activeplan",1);
                                                if(activeplan==1) {
                                                    if (day == 1) {
                                                       Gson gson = new Gson();
                                                       String set= gson.toJson(listItems);

                                                        editor.putString("food1", set);
                                                        editor.putString("calories1",String.valueOf(totalcalories));
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday1",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday1",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 2) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("food2", set);
                                                        editor.putString("calories2",String.valueOf(totalcalories));
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday2",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday2",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 3) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("food3", set);
                                                        editor.putString("calories3",String.valueOf(totalcalories));
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday3",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday3",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 4) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("food4", set);
                                                        editor.putString("calories4",String.valueOf(totalcalories));
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday4",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday4",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 5) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("food5", set);
                                                        editor.putString("calories5",String.valueOf(totalcalories));
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday5",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday5",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 6) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("food6", set);
                                                        editor.putString("calories6",String.valueOf(totalcalories));
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday6",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday6",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 7) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("calories7",String.valueOf(totalcalories));
                                                        editor.putString("food7", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday7",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday7",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                }
                                                if(activeplan==2)
                                                {
                                                    if (day == 1) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("food8", set);
                                                        editor.putString("calories8",String.valueOf(totalcalories));
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday1",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday1",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 2) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("calories9",String.valueOf(totalcalories));
                                                        editor.putString("food9", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday2",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday2",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 3) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("calories10",String.valueOf(totalcalories));
                                                        editor.putString("food10", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday3",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday3",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 4) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("calories11",String.valueOf(totalcalories));
                                                        editor.putString("food11", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday4",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday4",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 5) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("calories2",String.valueOf(totalcalories));
                                                        editor.putString("food12", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday5",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday5",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 6) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("calories3",String.valueOf(totalcalories));
                                                        editor.putString("food13", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday6",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday6",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                    if (day == 7) {
                                                        Gson gson = new Gson();
                                                        String set= gson.toJson(listItems);
                                                        editor.putString("calories14",String.valueOf(totalcalories));
                                                        editor.putString("food14", set);
                                                        editor.commit();
                                                        if(!set.isEmpty())
                                                        {
                                                            editor.putBoolean("foodday7",true);
                                                            editor.commit();
                                                        }
                                                        else
                                                        {
                                                            editor.putBoolean("foodday7",false);
                                                            editor.commit();
                                                        }
                                                        Intent i = new Intent(FoodEdit.this, FoodSettings.class);
                                                        startActivity(i);
                                                    }
                                                }
                                            }


                                        }


        );
        }


        public void addItems (View v){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Meal");


          //  final EditText input = new EditText(this);
            final AutoCompleteTextView input = new AutoCompleteTextView(FoodEdit.this);
            if(string!=null) {
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line, string);
                input.setAdapter(adapter2);
            }

            final EditText input2 = new EditText(this);


            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input2.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setHint("Food");
            input2.setHint("Calories");
            LinearLayout lay = new LinearLayout(this);
            lay.setOrientation(LinearLayout.VERTICAL);
            lay.addView(input);
            lay.addView(input2);
            builder.setView(lay);



            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();
                    reps = input2.getText().toString();
                    if (m_Text.length() != 0 && reps.length() != 0 && reps.matches(regex)) {
                        if(!meals.contains(m_Text))
                        {
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                            SharedPreferences.Editor editor = pref.edit();
                            meals.add(m_Text);
                            Gson gson = new Gson();
                            mymeals= gson.toJson(meals);
                            editor.putString("mymeals", mymeals);
                            editor.commit();
                            String ex=pref.getString("mymeals","empty");
                            string = gson.fromJson(ex, String[].class);
                            meals =new ArrayList<String>(Arrays.asList(string));
                        }
                        adapter.add(m_Text + " = " + reps + "kcal");
                        totalcalories=totalcalories+ Integer.parseInt(reps);
                        String calories=String.valueOf(totalcalories);
                        TextView settotalcalories = (TextView) findViewById(R.id.totalcaloriestext);
                        settotalcalories.setText("Total calories: "+calories);
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
