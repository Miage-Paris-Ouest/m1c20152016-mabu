package miage.uparis10.fr.mabu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InfosActivity extends AppCompatActivity {
        String test = "200 Avenue de la République, 92000 Nanterre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);
        TextView adresse = (TextView) findViewById(R.id.textViewAdresse);
        adresse.setText(test);

        TextView horaires = (TextView) findViewById(R.id.textViewHoraires);
        horaires.setText("Lundi 9h30 - 19h\nMardi 9h30 - 19h\nMercredi 9h30 - 19h\nJeudi 9h30 - 19h\nVendredi 9h30 - 19h\nSamedi 9h30 - 19h\n ");
    }
}
