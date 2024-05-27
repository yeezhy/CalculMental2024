package com.example.calculatriceg1java;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatriceg1java.database.CalculBaseHelper;
import com.example.calculatriceg1java.database.CalculDao;
import com.example.calculatriceg1java.entities.Calcul;

public class HistoriqueActivity extends AppCompatActivity {
    private CalculDao calculDao;
    private TextView textViewNombreCalcul;
    private TextView textViewDernierCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historique);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewNombreCalcul = findViewById(R.id.textview_nombre_calcul);
        textViewDernierCalcul = findViewById(R.id.textview_dernier_calcul);
        calculDao = new CalculDao(new CalculBaseHelper(this,"db",1));
        Integer nombreCalcul = (int) calculDao.count();
        Calcul dernierCalcul = calculDao.lastOrNull();
        if(dernierCalcul != null){
            String calculFormat = dernierCalcul.getPremierElement()
                    +" "+dernierCalcul.getSymbole()
                    +" "+dernierCalcul.getDeuxiemeElement()
                    +" = "
                    + dernierCalcul.getResultat();
            textViewDernierCalcul.setText(String.format(getString(R.string.TEXT_TEXTVIEW_DERNIER_CALCUL),calculFormat));
        }
        textViewNombreCalcul.setText(String.format(getString(R.string.TEXT_TEXTVIEW_NOMBRE_CALCUL),nombreCalcul));



    }
}