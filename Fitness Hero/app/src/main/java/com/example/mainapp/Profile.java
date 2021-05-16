package com.example.mainapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.text.InputType;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.TextView;



import java.util.Arrays;
import java.util.List;

public class Profile extends AppCompatActivity {
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
    ImageButton namebutton;
    String regex = "[0-9]+";

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Profile.this, ProfileDisplay.class);
        startActivity(i);
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
        editAge = (TextView) findViewById(R.id.textage);
        editWeight = (TextView) findViewById(R.id.textweight);
        editheight = (TextView) findViewById(R.id.textheight);
        editName = (TextView) findViewById(R.id.textname);
        editGender = (TextView) findViewById(R.id.textgender);
        editActivity = (TextView) findViewById(R.id.textactivity);
        editName.setText("Name: " + name);
        editWeight.setText("Weight: " + weight + " kg");
        editheight.setText("Height: " + height + " cm");
        editGender.setText("Gender: " + gender);
        editAge.setText("Age: " + age + " years");
        editActivity.setText("Activity Level: " + activity);


        namebutton = (ImageButton) findViewById(R.id.editnamebutton);
        namebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                builder.setTitle("Enter new name:");


                final EditText input = new EditText(Profile.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String m_Text = input.getText().toString();
                        name = m_Text;
                        if (name.length() == 0) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else if (!Helper.isStringOnlyAlphabet(name)) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else {
                            editor.putString("name", name);
                            editor.commit();
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
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


        });
        ImageButton ageeditbutton = (ImageButton) findViewById(R.id.editagebutton);
        ageeditbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                builder.setTitle("Enter new age:");


                final EditText input = new EditText(Profile.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String inputage = input.getText().toString();
                        age = inputage;
                        age2 = Integer.parseInt(inputage);
                        if (age.length() == 0) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else if (!age.matches(regex)) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else {
                            editor.putInt("age", age2);
                            editor.commit();
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
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


        });
        ImageButton heighteditbutton = (ImageButton) findViewById(R.id.editheightbutton);
        heighteditbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                builder.setTitle("Enter new height:");


                final EditText input = new EditText(Profile.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String inputheight = input.getText().toString();
                        height = inputheight;
                        height2 = Integer.parseInt(inputheight);
                        if (age.length() == 0) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else if (!age.matches(regex)) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else {
                            editor.putInt("height", height2);
                            editor.commit();
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
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


        });
        ImageButton weighteditbutton = (ImageButton) findViewById(R.id.editweightbutton);
        weighteditbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                builder.setTitle("Enter new weight:");


                final EditText input = new EditText(Profile.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String inputweight = input.getText().toString();
                        weight = inputweight;
                        weight2 = Integer.parseInt(inputweight);
                        if (age.length() == 0) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else if (!age.matches(regex)) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else {
                            editor.putInt("weight", weight2);
                            editor.commit();
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
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


        });
        ImageButton genderbutton = (ImageButton) findViewById(R.id.editgenderbutton);
        genderbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                builder.setTitle("Enter new name:");


                final EditText input = new EditText(Profile.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String genderinput = input.getText().toString();
                        gender = genderinput;
                        List valid = Arrays.asList("M", "F");
                        if (gender.length() == 0) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else if (!valid.contains(gender)) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else {
                            editor.putString("gender", genderinput);
                            editor.commit();
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
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


        });
        ImageButton activitybutton = (ImageButton) findViewById(R.id.activityeditbutton);
        activitybutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                builder.setTitle("Enter new weight:");


                final EditText input = new EditText(Profile.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String inputactivity = input.getText().toString();
                        activity = inputactivity;
                        int activity2 = Integer.parseInt(inputactivity);
                        if (activity.length() == 0) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else if (activity2 < 0 || activity2 > 6) {
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
                        } else {
                            editor.putInt("level", activity2);
                            editor.commit();
                            Intent i = new Intent(Profile.this, Profile.class);
                            startActivity(i);
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


        });
        Button donebutton;
        donebutton = (Button) findViewById(R.id.profileeditdone);
        donebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(Profile.this, ProfileDisplay.class);
                startActivity(i);


            }


        });
    }


}