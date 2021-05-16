package com.example.mainapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class BattleScreen extends AppCompatActivity {
TextView username;
TextView userHP;
TextView enemyname;
TextView enemyHP;
TextView energy;
ListView battlelog;
int hp;
int currenthp;
int enemyhp;
int enemycurrenthp;
int damage;
int enemydamage;
int protection;
int enemyprotection;
int userenergy;
int protein;
int energydrink;
ArrayList<String> log = new ArrayList<>();
ArrayAdapter<String>adapter;
    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(BattleScreen.this, Arena.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_screen);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
       protein=pref.getInt("proteinshake",0);
       energydrink=pref.getInt("energydrinks",0);
        userenergy=10;
        energy = (TextView) findViewById(R.id.userenergy);
        username = (TextView) findViewById(R.id.battlename);
        userHP = (TextView) findViewById(R.id.userhp);
        enemyname = (TextView) findViewById(R.id.battlenemy);
        enemyHP = (TextView) findViewById(R.id.enemyhp);
        battlelog = findViewById(R.id.battlelog);
        adapter=new ArrayAdapter<String>(BattleScreen.this,
                android.R.layout.simple_list_item_1,
                log);
        battlelog.setAdapter(adapter);
        username.setText(pref.getString("username",null));;
        hp=pref.getInt("HP",0);
         currenthp=hp;
         energy.setText("Energy: "+String.valueOf(userenergy)+"/10");
        userHP.setText(String.valueOf(currenthp)+"/"+String.valueOf(hp));
        enemyname.setText(pref.getString("enemy",null));
         enemyhp=pref.getInt("enemyhp",0);
        enemycurrenthp=enemyhp;
        enemyHP.setText(String.valueOf(enemycurrenthp)+"/"+String.valueOf(enemyhp));
         damage=pref.getInt("currentdamage",0)+pref.getInt("power",0);
         enemydamage=pref.getInt("enemydamage",0);
         protection=pref.getInt("currentprotection",0);
         enemyprotection=pref.getInt("enemyprotection",0);
        Button attackbutton;
        attackbutton = (Button) findViewById(R.id.attackbutton);
        attackbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            int userattack=getRandomNumber(damage-15,damage+15);
            enemycurrenthp=enemycurrenthp-userattack+enemyprotection;
            adapter.add(pref.getString("username",null)+" has attacked "+ pref.getString("enemy",null)+" for "+String.valueOf(userattack-enemyprotection)+" damage.");
            enemyHP.setText(String.valueOf(enemycurrenthp)+"/"+String.valueOf(enemyhp));
            int enemyattack=getRandomNumber(enemydamage-15,enemydamage+15);
            currenthp=currenthp-enemyattack+protection;
            adapter.add(pref.getString("enemy",null)+" has attacked "+pref.getString("username",null)+" for "+String.valueOf(enemyattack-protection)+" damage.");
            userHP.setText(String.valueOf(currenthp)+"/"+String.valueOf(hp));
            if(currenthp<=0)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                    builder.setMessage("You have lost the battle!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                    startActivity(i);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                if(enemycurrenthp<=0)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                    builder.setMessage("You have won the battle!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    editor.putInt("gold",pref.getInt("gold",0)+500);
                                    editor.putBoolean("finishquest1",true);
                                    editor.commit();
                                    Intent i = new Intent(BattleScreen.this, Arena.class);
                                    startActivity(i);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }


        });
        Button runbutton;
        runbutton = (Button) findViewById(R.id.runbutton);
        runbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                new AlertDialog.Builder(BattleScreen.this)
                        .setTitle("Run")
                        .setMessage("Are you sure you want to run?")


                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(BattleScreen.this, Arena.class);
                                startActivity(i);
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();



            }


        });
        Button blockbutton;
        blockbutton = (Button) findViewById(R.id.blockbutton);
        blockbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

              adapter.add(pref.getString("username",null)+" has blocked the attack.");


            }


        });
        Button useitem=(Button) findViewById(R.id.itemsbutton);
        useitem.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View view) {


                                               AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                               builder.setTitle("What would you like to do?");
                                               String energydrinks="Energy Drinks- "+String.valueOf(energydrink);
                                               String proteinshakes="Protein Shakes- "+String.valueOf(protein);
                                               String[] items = {energydrinks,proteinshakes,"Cancel"};
                                               builder.setItems(items, new DialogInterface.OnClickListener() {
                                                   @Override
                                                   public void onClick(DialogInterface dialog, int which) {
                                                       switch (which) {
                                                           case 0: {
                                                               if (energydrink>0)
                                                               {
                                                                   energydrink=energydrink-1;
                                                                   if(userenergy+5<=10)
                                                                   {
                                                                       userenergy=userenergy+5;
                                                                   }
                                                                   else
                                                                   {
                                                                       userenergy=10;
                                                                   }
                                                                   int enemyattack=getRandomNumber(enemydamage-15,enemydamage+15);
                                                                   currenthp=currenthp-enemyattack+protection;
                                                                   adapter.add(pref.getString("enemy",null)+" has attacked "+pref.getString("username",null)+" for "+String.valueOf(enemyattack-protection)+" damage.");
                                                                   userHP.setText(String.valueOf(currenthp)+"/"+String.valueOf(hp));
                                                                   energy.setText("Energy: "+String.valueOf(userenergy)+"/10");
                                                                   editor.putInt("energydrinks",energydrink);
                                                                   editor.commit();
                                                                   adapter.add(pref.getString("username",null)+" has used an energy drink.");
                                                                   if(currenthp<=0)
                                                                   {
                                                                       AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                       builder.setMessage("You have lost the battle!")
                                                                               .setCancelable(false)
                                                                               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                   public void onClick(DialogInterface dialog, int id) {
                                                                                       Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                       startActivity(i);
                                                                                   }
                                                                               });
                                                                       AlertDialog alert = builder.create();
                                                                       alert.show();
                                                                   }
                                                               }
                                                               break;
                                                           }

                                                           case 1: {
                                                               if (protein>0)
                                                               {
                                                                   protein=protein-1;
                                                                   if(currenthp+20<=hp)
                                                                   {
                                                                       currenthp=currenthp+20;
                                                                   }
                                                                   else
                                                                   {
                                                                       currenthp=hp;
                                                                   }
                                                                   int enemyattack=getRandomNumber(enemydamage-15,enemydamage+15);
                                                                   currenthp=currenthp-enemyattack+protection;
                                                                   adapter.add(pref.getString("enemy",null)+" has attacked "+pref.getString("username",null)+" for "+String.valueOf(enemyattack-protection)+" damage.");
                                                                   userHP.setText(String.valueOf(currenthp)+"/"+String.valueOf(hp));
                                                                   editor.putInt("proteinshake",protein);
                                                                   editor.commit();
                                                                   adapter.add(pref.getString("username",null)+" has used a protein shake.");
                                                                   if(currenthp<=0)
                                                                   {
                                                                       AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                       builder.setMessage("You have lost the battle!")
                                                                               .setCancelable(false)
                                                                               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                   public void onClick(DialogInterface dialog, int id) {
                                                                                       Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                       startActivity(i);
                                                                                   }
                                                                               });
                                                                       AlertDialog alert = builder.create();
                                                                       alert.show();
                                                                   }
                                                               }
                                                               break;
                                                           }
                                                           case 2: {
                                                               break;
                                                           }


                                                       }
                                                   }
                                               });


                                               AlertDialog dialog = builder.create();
                                               dialog.show();
                                           }

                                       }





        );
        Button useskill=(Button) findViewById(R.id.skillsbutton);
        useskill.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View view) {


                                           AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                           builder.setTitle("What would you like to do?");
                                           String[] items = {"Kick- 5 energy","Punch- 3 energy","Heal- 10 energy","Push- 7 energy","Cancel"};
                                           builder.setItems(items, new DialogInterface.OnClickListener() {
                                               @Override
                                               public void onClick(DialogInterface dialog, int which) {
                                                   switch (which) {
                                                       case 0: {
                                                           if (userenergy-5>=0)
                                                           {
                                                               userenergy=userenergy-5;
                                                               int kickdamage=pref.getInt("kicklevel",0)*5 + 50;
                                                               int userattack=getRandomNumber(kickdamage-15,kickdamage+15);
                                                               enemycurrenthp=enemycurrenthp-userattack+enemyprotection;
                                                               adapter.add(pref.getString("username",null)+" has kicked "+ pref.getString("enemy",null)+" for "+String.valueOf(userattack-enemyprotection)+" damage.");
                                                               enemyHP.setText(String.valueOf(enemycurrenthp)+"/"+String.valueOf(enemyhp));
                                                               int enemyattack=getRandomNumber(enemydamage-15,enemydamage+15);
                                                               currenthp=currenthp-enemyattack+protection;
                                                               adapter.add(pref.getString("enemy",null)+" has attacked "+pref.getString("username",null)+" for "+String.valueOf(enemyattack-protection)+" damage.");
                                                               userHP.setText(String.valueOf(currenthp)+"/"+String.valueOf(hp));
                                                               energy.setText("Energy: "+String.valueOf(userenergy)+"/10");

                                                               if(currenthp<=0)
                                                               {
                                                                   AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                   builder.setMessage("You have lost the battle!")
                                                                           .setCancelable(false)
                                                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                               public void onClick(DialogInterface dialog, int id) {
                                                                                   Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                   startActivity(i);
                                                                               }
                                                                           });
                                                                   AlertDialog alert = builder.create();
                                                                   alert.show();
                                                               }
                                                               if(enemycurrenthp<=0)
                                                               {
                                                                   AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                   builder.setMessage("You have won the battle!")
                                                                           .setCancelable(false)
                                                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                               public void onClick(DialogInterface dialog, int id) {
                                                                                   editor.putInt("gold",pref.getInt("gold",0)+500);
                                                                                   editor.putBoolean("finishquest1",true);
                                                                                   editor.commit();
                                                                                   Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                   startActivity(i);
                                                                               }
                                                                           });
                                                                   AlertDialog alert = builder.create();
                                                                   alert.show();
                                                               }
                                                           }
                                                           break;
                                                       }

                                                       case 1: {
                                                           if (userenergy-3>=0)
                                                           {
                                                               userenergy=userenergy-3;
                                                               int punchdamage=pref.getInt("punchlevel",0)*5 + 35;
                                                               int userattack=getRandomNumber(punchdamage-15,punchdamage+15);
                                                               enemycurrenthp=enemycurrenthp-userattack+enemyprotection;
                                                               adapter.add(pref.getString("username",null)+" has punched "+ pref.getString("enemy",null)+" for "+String.valueOf(userattack-enemyprotection)+" damage.");
                                                               enemyHP.setText(String.valueOf(enemycurrenthp)+"/"+String.valueOf(enemyhp));
                                                               int enemyattack=getRandomNumber(enemydamage-15,enemydamage+15);
                                                               currenthp=currenthp-enemyattack+protection;
                                                               adapter.add(pref.getString("enemy",null)+" has attacked "+pref.getString("username",null)+" for "+String.valueOf(enemyattack-protection)+" damage.");
                                                               userHP.setText(String.valueOf(currenthp)+"/"+String.valueOf(hp));
                                                               energy.setText("Energy: "+String.valueOf(userenergy)+"/10");

                                                               if(currenthp<=0)
                                                               {
                                                                   AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                   builder.setMessage("You have lost the battle!")
                                                                           .setCancelable(false)
                                                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                               public void onClick(DialogInterface dialog, int id) {
                                                                                   Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                   startActivity(i);
                                                                               }
                                                                           });
                                                                   AlertDialog alert = builder.create();
                                                                   alert.show();
                                                               }
                                                               if(enemycurrenthp<=0)
                                                               {
                                                                   AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                   builder.setMessage("You have won the battle!")
                                                                           .setCancelable(false)
                                                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                               public void onClick(DialogInterface dialog, int id) {
                                                                                   editor.putInt("gold",pref.getInt("gold",0)+500);
                                                                                   editor.putBoolean("finishquest1",true);
                                                                                   editor.commit();
                                                                                   Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                   startActivity(i);
                                                                               }
                                                                           });
                                                                   AlertDialog alert = builder.create();
                                                                   alert.show();
                                                               }
                                                           }
                                                           break;
                                                       }
                                                       case 2: {
                                                           if (userenergy-10>=0)
                                                           {
                                                               userenergy=userenergy-10;
                                                               int heal=pref.getInt("heallevel",0)*5 + 100;

                                                               adapter.add(pref.getString("username",null)+" has healed for "+String.valueOf(heal)+" HP");
                                                              if(currenthp+heal<=hp)
                                                              {
                                                                  currenthp=currenthp+heal;
                                                              }
                                                              else
                                                              {
                                                                  currenthp=hp;
                                                              }
                                                               int enemyattack=getRandomNumber(enemydamage-15,enemydamage+15);
                                                               currenthp=currenthp-enemyattack+protection;
                                                               adapter.add(pref.getString("enemy",null)+" has attacked "+pref.getString("username",null)+" for "+String.valueOf(enemyattack-protection)+" damage.");
                                                               userHP.setText(String.valueOf(currenthp)+"/"+String.valueOf(hp));
                                                               energy.setText("Energy: "+String.valueOf(userenergy)+"/10");

                                                               if(currenthp<=0)
                                                               {
                                                                   AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                   builder.setMessage("You have lost the battle!")
                                                                           .setCancelable(false)
                                                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                               public void onClick(DialogInterface dialog, int id) {
                                                                                   Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                   startActivity(i);
                                                                               }
                                                                           });
                                                                   AlertDialog alert = builder.create();
                                                                   alert.show();
                                                               }
                                                               if(enemycurrenthp<=0)
                                                               {
                                                                   AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                   builder.setMessage("You have won the battle!")
                                                                           .setCancelable(false)
                                                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                               public void onClick(DialogInterface dialog, int id) {
                                                                                   editor.putInt("gold",pref.getInt("gold",0)+500);
                                                                                   editor.putBoolean("finishquest1",true);
                                                                                   editor.commit();
                                                                                   Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                   startActivity(i);
                                                                               }
                                                                           });
                                                                   AlertDialog alert = builder.create();
                                                                   alert.show();
                                                               }
                                                           }
                                                           break;
                                                       }
                                                       case 3: {
                                                           if (userenergy-7>=0)
                                                           {
                                                               userenergy=userenergy-7;
                                                               int pushdamage=pref.getInt("pushlevel",0)*5 + 200;
                                                               int userattack=getRandomNumber(pushdamage-15,pushdamage+15);
                                                               enemycurrenthp=enemycurrenthp-userattack+enemyprotection;
                                                               adapter.add(pref.getString("username",null)+" has pushed "+ pref.getString("enemy",null)+" for "+String.valueOf(userattack-enemyprotection)+" damage.");
                                                               enemyHP.setText(String.valueOf(enemycurrenthp)+"/"+String.valueOf(enemyhp));
                                                               int enemyattack=getRandomNumber(enemydamage-15,enemydamage+15);
                                                               currenthp=currenthp-enemyattack+protection;
                                                               adapter.add(pref.getString("enemy",null)+" has attacked "+pref.getString("username",null)+" for "+String.valueOf(enemyattack-protection)+" damage.");
                                                               userHP.setText(String.valueOf(currenthp)+"/"+String.valueOf(hp));
                                                               energy.setText("Energy: "+String.valueOf(userenergy)+"/10");

                                                               if(currenthp<=0)
                                                               {
                                                                   AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                   builder.setMessage("You have lost the battle!")
                                                                           .setCancelable(false)
                                                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                               public void onClick(DialogInterface dialog, int id) {
                                                                                   Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                   startActivity(i);
                                                                               }
                                                                           });
                                                                   AlertDialog alert = builder.create();
                                                                   alert.show();
                                                               }
                                                               if(enemycurrenthp<=0)
                                                               {
                                                                   AlertDialog.Builder builder = new AlertDialog.Builder(BattleScreen.this);
                                                                   builder.setMessage("You have won the battle!")
                                                                           .setCancelable(false)
                                                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                               public void onClick(DialogInterface dialog, int id) {
                                                                                   editor.putInt("gold",pref.getInt("gold",0)+500);
                                                                                   editor.putBoolean("finishquest1",true);
                                                                                   editor.commit();
                                                                                   Intent i = new Intent(BattleScreen.this, Arena.class);
                                                                                   startActivity(i);
                                                                               }
                                                                           });
                                                                   AlertDialog alert = builder.create();
                                                                   alert.show();
                                                               }
                                                           }
                                                           break;
                                                       }
                                                       case 4: {
                                                           break;
                                                       }


                                                   }
                                               }
                                           });


                                           AlertDialog dialog = builder.create();
                                           dialog.show();
                                       }

                                   }





        );


    }
}