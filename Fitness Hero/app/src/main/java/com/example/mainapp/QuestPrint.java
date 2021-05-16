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

public class QuestPrint extends AppCompatActivity {
    TextView title;
    TextView description;

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(QuestPrint.this, CharacterPage.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_print);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        if(pref.getInt("activequest",0)==1)
        {
            title = (TextView) findViewById(R.id.questname);
            description = (TextView) findViewById(R.id.questdescription);
            title.setText("The Arena");
            description.setText("It's time for you to pay a visit to the arena.\n I will give you some gold so you can visit the shop first. \n Objectives: \n Buy some equipment \n Train all the skills \n Win the first battle in the arena");

        }
        Button questprintback;
        questprintback = (Button) findViewById(R.id.questprintback);
        questprintback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(QuestPrint.this, CharacterPage.class);
                startActivity(i);


            }


        });
        Button questfinish;
        questfinish = (Button) findViewById(R.id.questfinishbutton);
        questfinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(pref.getBoolean("finishquest1",false))
                {
                    editor.putBoolean("allquests",true);
                    editor.putInt("gold",pref.getInt("gold",0)+1000);
                    editor.putBoolean("quest",false);
                    editor.commit();
                    Intent i = new Intent(QuestPrint.this, Quest.class);
                    startActivity(i);
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(QuestPrint.this);
                    builder.setMessage("You did not finish the quest yet!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent i = new Intent(QuestPrint.this, QuestPrint.class);
                                    startActivity(i);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }

            }
        });
    }
}