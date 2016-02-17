package miage.uparis10.fr.mabu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProlongationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prolongation);
        Intent intent = getIntent();
        String titre = intent.getStringExtra("titre");

        TextView textViewLogin = (TextView) findViewById(R.id.textViewTitre);
        textViewLogin.setText("Vous allez prolonger : " + titre);

    }
}
