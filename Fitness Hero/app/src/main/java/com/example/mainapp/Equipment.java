package com.example.mainapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Equipment extends AppCompatActivity {
    TextView weapon;
    TextView armor;
    TextView damage;
    TextView protection;
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(Equipment.this, CharacterPage.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        weapon = (TextView) findViewById(R.id.weaponcurrent);
        armor = (TextView) findViewById(R.id.armorcurrent);
        damage = (TextView) findViewById(R.id.weapondamage);
        protection = (TextView) findViewById(R.id.armorprotection);
        weapon.setText("Weapon: "+pref.getString("weapon","Nothing"));
        armor.setText("Armor: "+pref.getString("armor","Nothing"));
       damage.setText("Weapon Damage: "+String.valueOf(pref.getInt("currentdamage",0)));
       protection.setText("Armor Protection: "+String.valueOf(pref.getInt("currentprotection",0)));
        Button backequipment;
        backequipment = (Button) findViewById(R.id.equipmentback);
        backequipment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(Equipment.this, CharacterPage.class);
                startActivity(i);


            }


        });
        Button weaponsbutton=(Button) findViewById(R.id.changeweapon);
        weaponsbutton.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View view) {


                                                 AlertDialog.Builder builder = new AlertDialog.Builder(Equipment.this);
                                                 builder.setTitle("What would you like to equip?");
                                                 String[] items = {"Box Gloves","Wrist Wraps ","Nothing"};
                                                 builder.setItems(items, new DialogInterface.OnClickListener() {
                                                     @Override
                                                     public void onClick(DialogInterface dialog, int which) {
                                                         switch (which) {
                                                             case 0: {

                                                                     if(pref.getBoolean("boxinggloves",false)) {
                                                                        editor.putString("weapon","Boxing Gloves");
                                                                        editor.putInt("currentdamage",30);
                                                                        editor.commit();
                                                                     }


                                                                 Intent i = new Intent(Equipment.this, Equipment.class);

                                                                 startActivity(i);
                                                                 break;
                                                             }

                                                             case 1: {
                                                                 if(pref.getBoolean("wristwraps",false)) {
                                                                     editor.putString("weapon","Wrist Wraps");
                                                                     editor.putInt("currentdamage",10);
                                                                     editor.commit();
                                                                 }
                                                                 Intent i = new Intent(Equipment.this, Equipment.class);
                                                                 startActivity(i);
                                                                 break;
                                                             }
                                                             case 2: {
                                                                 editor.putString("weapon","Nothing");
                                                                 editor.putInt("currentdamage",0);
                                                                 editor.commit();
                                                                 Intent i = new Intent(Equipment.this, Equipment.class);

                                                                 startActivity(i);
                                                             }


                                                         }
                                                     }
                                                 });


                                                 AlertDialog dialog = builder.create();
                                                 dialog.show();
                                             }

                                         }





        );
        Button armorbutton=(Button) findViewById(R.id.changearmor);
        armorbutton.setOnClickListener(new View.OnClickListener() {
                                             public void onClick(View view) {


                                                 AlertDialog.Builder builder = new AlertDialog.Builder(Equipment.this);
                                                 builder.setTitle("What would you like to equip?");
                                                 String[] items = {"Gym Suit","Tank Top ","Nothing"};
                                                 builder.setItems(items, new DialogInterface.OnClickListener() {
                                                     @Override
                                                     public void onClick(DialogInterface dialog, int which) {
                                                         switch (which) {
                                                             case 0: {

                                                                 if(pref.getBoolean("gymsuit",false)) {
                                                                     editor.putString("armor","Gym Suit");
                                                                     editor.putInt("currentprotection",30);
                                                                     editor.commit();
                                                                 }


                                                                 Intent i = new Intent(Equipment.this, Equipment.class);

                                                                 startActivity(i);
                                                                 break;
                                                             }

                                                             case 1: {
                                                                 if(pref.getBoolean("tanktop",false)) {
                                                                     editor.putString("armor","Tank Top");
                                                                     editor.putInt("currentprotection",10);
                                                                     editor.commit();
                                                                 }
                                                                 Intent i = new Intent(Equipment.this, Equipment.class);
                                                                 startActivity(i);
                                                                 break;
                                                             }
                                                             case 2: {
                                                                 editor.putString("armor","Nothing");
                                                                 editor.putInt("currentprotection",0);
                                                                 editor.commit();
                                                                 Intent i = new Intent(Equipment.this, Equipment.class);

                                                                 startActivity(i);
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