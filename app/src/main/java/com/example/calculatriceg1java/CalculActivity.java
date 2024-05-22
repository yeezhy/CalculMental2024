package com.example.calculatriceg1java;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculActivity extends AppCompatActivity {

    private TextView textViewCalcul;
    private TextView textViewResultat;
    private Button bouton0;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Button boutonPlus;
    private Button boutonSubstract;
    private Button boutonMultiply;
    private Button boutonDivide;

    private Integer premierElement=0;
    private Integer deuxiemeElement=0;
    private TypeOperation typeOperation;
    private Integer resultat;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcul);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewCalcul= findViewById(R.id.textView_Calcul);
        textViewResultat= findViewById(R.id.textView_resultat);
        bouton0= findViewById(R.id.button_0);
        bouton1= findViewById(R.id.button_1);
        bouton2= findViewById(R.id.button_2);
        bouton3= findViewById(R.id.button_3);
        bouton4= findViewById(R.id.button_4);
        bouton5= findViewById(R.id.button_5);
        bouton6= findViewById(R.id.button_6);
        bouton7= findViewById(R.id.button_7);
        bouton8= findViewById(R.id.button_8);
        bouton9= findViewById(R.id.button_9);
        boutonDivide= findViewById(R.id.button_divide);
        boutonSubstract= findViewById(R.id.button_difference);
        boutonPlus= findViewById(R.id.button_plus);
        boutonMultiply= findViewById(R.id.button_multiply);

        bouton0.setOnClickListener(view -> appuieBoutonChiffre("0"));
        bouton1.setOnClickListener(view -> appuieBoutonChiffre("1"));
        bouton2.setOnClickListener(view -> appuieBoutonChiffre("2"));
        bouton3.setOnClickListener(view -> appuieBoutonChiffre("3"));
        bouton4.setOnClickListener(view -> appuieBoutonChiffre("4"));
        bouton5.setOnClickListener(view -> appuieBoutonChiffre("5"));
        bouton6.setOnClickListener(view -> appuieBoutonChiffre("6"));
        bouton7.setOnClickListener(view -> appuieBoutonChiffre("7"));
        bouton8.setOnClickListener(view -> appuieBoutonChiffre("8"));
        bouton9.setOnClickListener(view -> appuieBoutonChiffre("9"));
        boutonDivide.setOnClickListener(view -> appuieBoutonOperation("/"));
        boutonSubstract.setOnClickListener(view -> appuieBoutonOperation("-"));
        boutonPlus.setOnClickListener(view -> appuieBoutonOperation("+"));
        boutonMultiply.setOnClickListener(view -> appuieBoutonOperation("x"));

    }
    
    
    private void appuieBoutonChiffre(String valeur){
        ajouterCharactere(valeur);
        modifieElement(Integer.valueOf(valeur));
    }

    private void appuieBoutonOperation(String symbole){
        if (typeOperation==null){
            ajouterCharactere(symbole);
            modifieTypeOperation(symbole);
        }else {
           Toast.makeText(this, getString(R.string.ERROR_TYPE_OPERATION), Toast.LENGTH_LONG).show();
        }

    }

    private void modifieTypeOperation(String symbole){
        switch (symbole){
            case "+":
                typeOperation=TypeOperation.ADD;
                break;
            case "-":
                typeOperation=TypeOperation.SUBSTRAST;
                break;
            case "/":
                typeOperation=TypeOperation.DIVIDE;
                break;
            case "x":
                typeOperation=TypeOperation.MULTIPLY;
                break;
                
        }

    }

    private void modifieElement(Integer aAjouter){
        if(typeOperation==null){
            premierElement=10*premierElement+aAjouter;
        }else {
            deuxiemeElement=10*deuxiemeElement+aAjouter;
        }
    }


    private void ajouterCharactere(String chiffreAAjouter){
        textViewCalcul.setText(textViewCalcul.getText()+chiffreAAjouter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.monmenu,menu);
        MenuItem boutonReset = menu.findItem(R.id.clear_item);
        boutonReset.setOnMenuItemClickListener(MenuItem -> effacerLaTextView());
        MenuItem boutonCalculer = menu.findItem(R.id.button_calculer);
        boutonCalculer.setOnMenuItemClickListener(MenuItem -> calculerEtAfficher());


        return super.onCreateOptionsMenu(menu);
    }

    private Boolean calculerEtAfficher(){
        calculer();
        modifieResultat();
        return true;
    }

    private void modifieResultat() {
        textViewResultat.setText(String.valueOf(resultat));
    }

    private void calculer() {
        switch (typeOperation){
            case ADD:
                resultat=premierElement+deuxiemeElement;
                break;
            case DIVIDE:
                resultat=premierElement/deuxiemeElement;
                break;
            case MULTIPLY:
                resultat=premierElement*deuxiemeElement;
                break;
            case SUBSTRAST:
                resultat=premierElement-deuxiemeElement;
                break;
        }
    }

    private Boolean effacerLaTextView(){
        premierElement=0;
        deuxiemeElement=0;
        typeOperation=null;
        resultat=0;
        textViewCalcul.setText("");
        textViewResultat.setText("");
        return true;
    }


}