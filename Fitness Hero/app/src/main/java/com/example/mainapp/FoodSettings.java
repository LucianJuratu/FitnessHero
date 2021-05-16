package com.example.mainapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FoodSettings extends AppCompatActivity {
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(FoodSettings.this, FoodPrint.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_settings);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        Button tomeals;
        tomeals = (Button) findViewById(R.id.tomeals);
        tomeals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(FoodSettings.this, Meals.class);
                startActivity(i);


            }
        });
        int plan=pref.getInt("activeplan",1);
        Button plan1button=(Button) findViewById(R.id.plan1button);
        plan1button.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                AlertDialog alertDialog = new AlertDialog.Builder(FoodSettings.this).create();
                                                alertDialog.setTitle("Plan selected");
                                                alertDialog.setMessage("You have selected plan 1.");
                                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                        new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                dialog.dismiss();
                                                            }
                                                        });
                                                alertDialog.show();
                                                editor.putInt("activeplan",1);
                                                editor.commit();
                                            }


                                        }


        );
        Button plan2button=(Button) findViewById(R.id.plan2button);
        plan2button.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View view) {
                                               AlertDialog alertDialog = new AlertDialog.Builder(FoodSettings.this).create();
                                               alertDialog.setTitle("Plan selected");
                                               alertDialog.setMessage("You have selected plan 2.");
                                               alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                       new DialogInterface.OnClickListener() {
                                                           public void onClick(DialogInterface dialog, int which) {
                                                               dialog.dismiss();
                                                           }
                                                       });
                                               alertDialog.show();
                                               editor.putInt("activeplan",2);
                                               editor.commit();
                                           }


                                       }


        );
        Button mondaybutton=(Button) findViewById(R.id.mondaybutton);
        mondaybutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {

                                               editor.putInt("activeday",1);
                                               editor.commit();
                                                Intent i = new Intent(FoodSettings.this, FoodEdit.class);
                                                startActivity(i);
                                            }


                                        }


        );
        Button tuesdaybutton=(Button) findViewById(R.id.tuesdaybutton);
        tuesdaybutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {

                                                editor.putInt("activeday",2);
                                                editor.commit();
                                                Intent i = new Intent(FoodSettings.this, FoodEdit.class);
                                                startActivity(i);
                                            }


                                        }


        );
        Button wednesdaybutton=(Button) findViewById(R.id.wednesdaybutton);
        wednesdaybutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {

                                                editor.putInt("activeday",3);
                                                editor.commit();
                                                Intent i = new Intent(FoodSettings.this, FoodEdit.class);
                                                startActivity(i);
                                            }


                                        }


        );
        Button thursdaybutton=(Button) findViewById(R.id.thursdaybutton);
        thursdaybutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {

                                                editor.putInt("activeday",4);
                                                editor.commit();
                                                Intent i = new Intent(FoodSettings.this, FoodEdit.class);
                                                startActivity(i);
                                            }


                                        }


        );
        Button fridaybutton=(Button) findViewById(R.id.fridaybutton);
        fridaybutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {

                                                editor.putInt("activeday",5);
                                                editor.commit();
                                                Intent i = new Intent(FoodSettings.this, FoodEdit.class);
                                                startActivity(i);
                                            }


                                        }


        );
        Button saturdaybutton=(Button) findViewById(R.id.saturdaybutton);
        saturdaybutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {

                                                editor.putInt("activeday",6);
                                                editor.commit();
                                                Intent i = new Intent(FoodSettings.this, FoodEdit.class);
                                                startActivity(i);
                                            }


                                        }


        );
        Button sundaybutton=(Button) findViewById(R.id.sundaybutton);
        sundaybutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {

                                                editor.putInt("activeday",7);
                                                editor.commit();
                                                Intent i = new Intent(FoodSettings.this, FoodEdit.class);
                                                startActivity(i);
                                            }


                                        }


        );

        Button donebutton=(Button) findViewById(R.id.fooddonebutton);
        donebutton.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {

                                                Intent i = new Intent(FoodSettings.this, FoodPrint.class);
                                                startActivity(i);
                                            }


                                        }


        );
        ImageButton day1delete=(ImageButton) findViewById(R.id.delete1);
        day1delete.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View view) {
                                               AlertDialog alertDialog = new AlertDialog.Builder(FoodSettings.this).create();
                                               alertDialog.setTitle("Remove plan");
                                               alertDialog.setMessage("You have removed the plan for monday.");
                                               alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                       new DialogInterface.OnClickListener() {
                                                           public void onClick(DialogInterface dialog, int which) {
                                                               dialog.dismiss();
                                                           }
                                                       });
                                               alertDialog.show();
                                             if(plan==1) {
                                                 editor.putString("food1", "empty");
                                                 editor.putString("calories1","0");
                                                 editor.putBoolean("foodday1",false);
                                                 editor.commit();
                                             }
                                             else
                                             {
                                                 editor.putString("food8","empty");
                                                 editor.putString("calories8","0");
                                                 editor.putBoolean("foodday1",false);
                                                 editor.commit();
                                             }

                                           }


                                       }


        );
        ImageButton day2delete=(ImageButton) findViewById(R.id.delete2);
        day2delete.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View view) {
                                              AlertDialog alertDialog = new AlertDialog.Builder(FoodSettings.this).create();
                                              alertDialog.setTitle("Remove plan");
                                              alertDialog.setMessage("You have removed the plan for tuesday.");
                                              alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                      new DialogInterface.OnClickListener() {
                                                          public void onClick(DialogInterface dialog, int which) {
                                                              dialog.dismiss();
                                                          }
                                                      });
                                              alertDialog.show();
                                              if(plan==1) {
                                                  editor.putString("food2", "empty");
                                                  editor.putBoolean("foodday2",false);
                                                  editor.putString("calories2","0");
                                                  editor.commit();
                                              }
                                              else
                                              {
                                                  editor.putBoolean("foodday2",false);
                                                  editor.putString("food9","empty");
                                                  editor.putString("calories9","0");
                                                  editor.commit();
                                              }

                                          }


                                      }



        );
        ImageButton deleteday3=(ImageButton) findViewById(R.id.delete3);
        deleteday3.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View view) {
                                              AlertDialog alertDialog = new AlertDialog.Builder(FoodSettings.this).create();
                                              alertDialog.setTitle("Remove plan");
                                              alertDialog.setMessage("You have removed the plan for wednesday.");
                                              alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                      new DialogInterface.OnClickListener() {
                                                          public void onClick(DialogInterface dialog, int which) {
                                                              dialog.dismiss();
                                                          }
                                                      });
                                              alertDialog.show();
                                              if(plan==1) {
                                                  editor.putString("food3", "empty");
                                                  editor.putString("calories3","0");
                                                  editor.putBoolean("foodday3",false);
                                                  editor.commit();
                                              }
                                              else
                                              {
                                                  editor.putBoolean("foodday3",false);
                                                  editor.putString("calories10","0");
                                                  editor.putString("food10","empty");
                                                  editor.commit();
                                              }

                                          }


                                      }



        );
        ImageButton deleteday4=(ImageButton) findViewById(R.id.delete4);
        deleteday4.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View view) {
                                              AlertDialog alertDialog = new AlertDialog.Builder(FoodSettings.this).create();
                                              alertDialog.setTitle("Remove plan");
                                              alertDialog.setMessage("You have removed the plan for thursday.");
                                              alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                      new DialogInterface.OnClickListener() {
                                                          public void onClick(DialogInterface dialog, int which) {
                                                              dialog.dismiss();
                                                          }
                                                      });
                                              alertDialog.show();
                                              if(plan==1) {
                                                  editor.putBoolean("foodday4",false);
                                                  editor.putString("calories4","0");
                                                  editor.putString("food4", "empty");
                                                  editor.commit();
                                              }
                                              else
                                              {
                                                  editor.putBoolean("foodday4",false);
                                                  editor.putString("calories11","0");
                                                  editor.putString("food11","empty");
                                                  editor.commit();
                                              }

                                          }


                                      }



        );
        ImageButton deleteday5=(ImageButton) findViewById(R.id.delete5);
        deleteday5.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View view) {
                                              AlertDialog alertDialog = new AlertDialog.Builder(FoodSettings.this).create();
                                              alertDialog.setTitle("Remove plan");
                                              alertDialog.setMessage("You have removed the plan for friday.");
                                              alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                      new DialogInterface.OnClickListener() {
                                                          public void onClick(DialogInterface dialog, int which) {
                                                              dialog.dismiss();
                                                          }
                                                      });
                                              alertDialog.show();
                                              if(plan==1) {
                                                  editor.putBoolean("foodday5",false);
                                                  editor.putString("calories5","0");
                                                  editor.putString("food5", "empty");
                                                  editor.commit();
                                              }
                                              else
                                              {
                                                  editor.putBoolean("foodday5",false);
                                                  editor.putString("calories12","0");
                                                  editor.putString("food12","empty");
                                                  editor.commit();
                                              }

                                          }


                                      }



        );
        ImageButton deleteday6=(ImageButton) findViewById(R.id.delete6);
        deleteday6.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View view) {
                                              AlertDialog alertDialog = new AlertDialog.Builder(FoodSettings.this).create();
                                              alertDialog.setTitle("Remove plan");
                                              alertDialog.setMessage("You have removed the plan for saturday.");
                                              alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                      new DialogInterface.OnClickListener() {
                                                          public void onClick(DialogInterface dialog, int which) {
                                                              dialog.dismiss();
                                                          }
                                                      });
                                              alertDialog.show();
                                              if(plan==1) {
                                                  editor.putBoolean("foodday6",false);
                                                  editor.putString("calories6","0");
                                                  editor.putString("food6", "empty");
                                                  editor.commit();
                                              }
                                              else
                                              {
                                                  editor.putBoolean("foodday6",false);
                                                  editor.putString("calories13","0");
                                                  editor.putString("food13","empty");
                                                  editor.commit();
                                              }

                                          }


                                      }



        );
        ImageButton deleteday7=(ImageButton) findViewById(R.id.delete7);
        deleteday7.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View view) {
                                              AlertDialog alertDialog = new AlertDialog.Builder(FoodSettings.this).create();
                                              alertDialog.setTitle("Remove plan");
                                              alertDialog.setMessage("You have removed the plan for sunday.");
                                              alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                                      new DialogInterface.OnClickListener() {
                                                          public void onClick(DialogInterface dialog, int which) {
                                                              dialog.dismiss();
                                                          }
                                                      });
                                              alertDialog.show();
                                              if(plan==1) {
                                                  editor.putBoolean("foodday7",false);
                                                  editor.putString("calories7","0");
                                                  editor.putString("food7", "empty");
                                                  editor.commit();
                                              }
                                              else
                                              {
                                                  editor.putBoolean("foodday7",false);
                                                  editor.putString("calories14","0");
                                                  editor.putString("food14","empty");
                                                  editor.commit();
                                              }

                                          }


                                      }



        );
    }
}