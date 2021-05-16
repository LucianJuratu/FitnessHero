package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CharacterPage extends AppCompatActivity {
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(CharacterPage.this, NavigationActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_page);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("HP",pref.getInt("charlevel",0)*100);
        editor.commit();
        TextView usernameview;
        TextView classview;
        TextView leveldisplay;
        TextView strength;
        TextView agility;
        TextView endurance;
        TextView power;
        TextView experiencetext;
        int strengthint=pref.getInt("strength",0);
        int agilityint=pref.getInt("agility",0);
        int enduranceint=pref.getInt("endurance",0);
        String strengthprint=String.valueOf(strengthint);
        String agilityprint=String.valueOf(agilityint);
        String enduranceprint2=String.valueOf(enduranceint);
        Button toskills;
        toskills = (Button) findViewById(R.id.toskills);
        toskills.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(CharacterPage.this, SkillsPage.class);
                startActivity(i);


            }


        });
        Button toinventory;
        toinventory = (Button) findViewById(R.id.toinventory);
        toinventory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(CharacterPage.this, Inventory.class);
                startActivity(i);


            }


        });
        Button toshop;
        toshop = (Button) findViewById(R.id.toshop);
        toshop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(CharacterPage.this, Shop.class);
                startActivity(i);


            }


        });
        Button toequipment;
        toequipment = (Button) findViewById(R.id.toequipment);
        toequipment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(CharacterPage.this, Equipment.class);
                startActivity(i);


            }


        });
        Button toarena;
        toarena = (Button) findViewById(R.id.toarena);
        toarena.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(CharacterPage.this, Arena.class);
                startActivity(i);


            }


        });
        Button toquest;
        toquest = (Button) findViewById(R.id.toquests);
        toquest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(CharacterPage.this, Quest.class);
                startActivity(i);


            }


        });
        int level=pref.getInt("charlevel",0);
        int powerint=level+strengthint%10+agilityint%10+enduranceint%10;
        editor.putInt("power",powerint);
        editor.commit();
        String powerprint2=String.valueOf(powerint);
        String levelprint= String.valueOf(level);
        String classdisplay=pref.getString("class",null);
        String usernamedisplay=pref.getString("username",null);
        usernameview = (TextView) findViewById(R.id.usernameshow);
        classview = (TextView) findViewById(R.id.classview);
        leveldisplay = (TextView) findViewById(R.id.levetshow);
        experiencetext = (TextView) findViewById(R.id.experiencetext);
        strength = (TextView) findViewById(R.id.strstat);
        agility = (TextView) findViewById(R.id.agistat);
        endurance = (TextView) findViewById(R.id.endstat);
        power = (TextView) findViewById(R.id.powerstat);
        leveldisplay.setText("Level: "+levelprint);
        strength.setText("Strength: "+strengthprint);
        agility.setText("Agility: "+agilityprint);
        endurance.setText("Endurance: "+enduranceprint2);
        power.setText("Power: "+powerprint2);
        usernameview.setText("Username: "+usernamedisplay);
        classview.setText("Class: "+classdisplay);
        leveldisplay.setText("Level "+levelprint);
        experiencetext.setText("Experience: "+String.valueOf(pref.getInt("experience",0))+" / "+String.valueOf(pref.getInt("neededexperience",0)));

    }
}