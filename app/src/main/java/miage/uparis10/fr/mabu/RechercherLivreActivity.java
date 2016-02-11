package miage.uparis10.fr.mabu;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RechercherLivreActivity extends AppCompatActivity {

    Spinner spinner_caracteristiques;
    Button btnSubmit;
    EditText etCaracteristique;
    String valeur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher_livre);

        Resources res = getResources();
        String[] caracteristiques = res.getStringArray(R.array.caracteristiques_array);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AfficherLivreActivity.class);
                etCaracteristique = (EditText) findViewById(R.id.etCaracteristique);

                spinner_caracteristiques= (Spinner) findViewById(R.id.spinnerCaracteristiques);

                if (spinner_caracteristiques.getSelectedItem().toString().equals("Titre"))
                    valeur = "titre";
                else if (spinner_caracteristiques.getSelectedItem().toString().equals("Auteur"))
                    valeur = "auteur";
                else if (spinner_caracteristiques.getSelectedItem().toString().equals("Genre"))
                    valeur = "genre";
                else if (spinner_caracteristiques.getSelectedItem().toString().equals("Edition"))
                    valeur = "edition";

                String caracteristique = etCaracteristique.getText().toString();
                intent.putExtra("caracteristique", caracteristique);
                intent.putExtra("valeur", valeur);

                startActivity(intent);
            }
        });
    }
}
