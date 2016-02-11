package miage.uparis10.fr.mabu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AfficherLivreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_livre);

        Intent intent = getIntent();
        String caracteristique = intent.getStringExtra("caracteristique");

        String valeur = intent.getStringExtra("valeur");

        TextView textViewLogin = (TextView) findViewById(R.id.textViewCaracteristique);
        textViewLogin.setText(valeur + " : " + caracteristique);
    }
}
