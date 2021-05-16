package com.example.mainapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class CharacterCreation extends AppCompatActivity {
    String selectedclass;
    List valid = Arrays.asList("Bodybuilder","Street Athlete","Regular Athlete");
    EditText userinput2;
    int str;
    int agi;
    int end;
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(CharacterCreation.this, NavigationActivity.class);
        startActivity(i);
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);
        userinput2 = (EditText) findViewById(R.id.testid);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        if(pref.getBoolean("charcreated",false))
        {
            Intent i = new Intent(CharacterCreation.this, CharacterPage.class);
            startActivity(i);
        }

        ImageButton bodybuilderinfo;
        bodybuilderinfo = (ImageButton) findViewById(R.id.bodybuilderinfobutton);

        bodybuilderinfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(CharacterCreation.this).create();
                alertDialog.setTitle("Information");
                alertDialog.setMessage("The bodybuilder class is for those who want to focus on getting bigger and stronger. Strength is the main stat of this class.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


            }


        });
        ImageButton streetinfo;
        streetinfo = (ImageButton) findViewById(R.id.streetathleteinfobutton);

        streetinfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(CharacterCreation.this).create();
                alertDialog.setTitle("Information");
                alertDialog.setMessage("The street athlete class is for those who focus on skills over size. Their main goal is functional strength and an equilibrum between cardio and muscular endurance.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


            }


        });
        ImageButton normalathlete;
        normalathlete = (ImageButton) findViewById(R.id.regularathleteinfobutton);

        normalathlete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(CharacterCreation.this).create();
                alertDialog.setTitle("Information");
                alertDialog.setMessage("The  regular athlete class is for those who only practice sports for their health. They want an equilibrum between strength, cardio and muscular endurance and don't want to excel in any of these.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


            }


        });
        Button bodybuildersetclass;
        bodybuildersetclass = (Button) findViewById(R.id.bodybuilderbutton);

        bodybuildersetclass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                selectedclass="Bodybuilder";
                str=10;
                agi=3;
                end=3;
                AlertDialog alertDialog = new AlertDialog.Builder(CharacterCreation.this).create();
                alertDialog.setTitle("Class Selection");
                alertDialog.setMessage("You have selected the bodybuilder class..");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


            }


        });
        Button streetathletesetclass;
        streetathletesetclass = (Button) findViewById(R.id.streetathletebutton);

        streetathletesetclass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                str=8;
                agi=6;
                end=6;
                selectedclass="Street Athlete";
                AlertDialog alertDialog = new AlertDialog.Builder(CharacterCreation.this).create();
                alertDialog.setTitle("Class Selection");
                alertDialog.setMessage("You have selected the street athlete class..");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


            }


        });
        Button regularathletesetclass;
        regularathletesetclass = (Button) findViewById(R.id.regularathletebutton);

        regularathletesetclass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                selectedclass="Regular Athlete";
                str=6;
                end=6;
                agi=6;
                AlertDialog alertDialog = new AlertDialog.Builder(CharacterCreation.this).create();
                alertDialog.setTitle("Class Selection");
                alertDialog.setMessage("You have selected the regular athlete class..");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();


            }


        });
        Button createbutton;
        createbutton = (Button) findViewById(R.id.createbutton);
        createbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String username=userinput2.getText().toString();
                if (username.length()==0)
                    userinput2.setError("Username is required!");
                else if (!Helper.isStringOnlyAlphabet(username))
                    userinput2.setError("You can only use letters!!");
                else if(!valid.contains(selectedclass))
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(CharacterCreation.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("TPlease select a class..");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

                else {
                    editor.putString("username", username);
                    editor.putString("class",selectedclass);
                    editor.putInt("strength",str);
                    editor.putInt("agility",agi);
                    editor.putInt("endurance",end);
                    editor.putInt("charlevel",1);
                    editor.putBoolean("charcreated",true);
                    editor.putInt("experience",0);
                    editor.putInt("neededexperience",100);
                    editor.putInt("HP",150);
                    editor.commit();
                    Intent i = new Intent(CharacterCreation.this, CharacterPage.class);
                    startActivity(i);
                }


            }


        });
    }

}