package com.example.calculatriceg1java;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button boutonCalcul;
    private Button boutonHistorique;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonCalcul=findViewById(R.id.bouton_calcul);
        boutonHistorique=findViewById(R.id.bouton_historique);


        boutonCalcul.setOnClickListener(view ->{
            Intent intent =new Intent(this,CalculActivity.class);
            startActivity(intent);
        });

        boutonHistorique.setOnClickListener(view ->{
            boutonCalcul.setText("JEAN PAUL");
        });






//        boutonCalcul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

//        boutonCalcul.setOnClickListener(view ->{
//                Toast.makeText(this,"J'appuie sur le bouton",Toast.LENGTH_LONG).show();
//        });

        ///To do: quand appuie sur 2eme bouton change texte premier bouton

//        boutonHistorique.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });




    }
}