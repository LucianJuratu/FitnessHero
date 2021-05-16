package com.example.mainapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quest extends AppCompatActivity {
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(Quest.this, CharacterPage.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        if(pref.getBoolean("quest",false))
        {
            Intent i = new Intent(Quest.this, QuestPrint.class);
            startActivity(i);
        }

        Button questback;
        questback = (Button) findViewById(R.id.backquest);
        questback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(Quest.this, CharacterPage.class);
                startActivity(i);


            }


        });
        Button nextquest;
        nextquest = (Button) findViewById(R.id.nextquest);
        nextquest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               if(pref.getBoolean("allquests",false))
               {
                   AlertDialog.Builder builder = new AlertDialog.Builder(Quest.this);
                   builder.setMessage("You have finished all the quests for now!")
                           .setCancelable(false)
                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   Intent i = new Intent(Quest.this, CharacterPage.class);
                                   startActivity(i);
                               }
                           });
                   AlertDialog alert = builder.create();
                   alert.show();
                }
                else
                {
                    editor.putInt("gold",pref.getInt("gold",0)+3000);
                    editor.putInt("activequest",1);
                    editor.putBoolean("quest",true);
                    editor.commit();
                    Intent i = new Intent(Quest.this, QuestPrint.class);
                    startActivity(i);
                }

            }
        });
    }
}