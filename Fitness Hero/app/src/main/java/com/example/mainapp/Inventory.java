package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inventory extends AppCompatActivity {
TextView gold;
TextView energy;
TextView protein;
   @Override
    public void onBackPressed()
    {
        Intent i = new Intent(Inventory.this, CharacterPage.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        gold = (TextView) findViewById(R.id.displaygold);
        energy = (TextView) findViewById(R.id.displayenergy);
        protein = (TextView) findViewById(R.id.displayprotein);
        gold.setText("Gold: "+String.valueOf(pref.getInt("gold",0)));
        energy.setText("Energy Drinks: "+String.valueOf(pref.getInt("energydrinks",0)));
        protein.setText("Protein Shakes: "+String.valueOf(pref.getInt("proteinshake",0)));
        Button inventoryback;
        inventoryback = (Button) findViewById(R.id.inventoryback);
        inventoryback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent i = new Intent(Inventory.this, CharacterPage.class);
                startActivity(i);


            }


        });
    }
}