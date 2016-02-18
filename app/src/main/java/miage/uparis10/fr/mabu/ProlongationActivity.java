package miage.uparis10.fr.mabu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class ProlongationActivity extends AppCompatActivity {

    Button buttonValider;
    EditText editTextDate;
    ListView maListViewPerso;
    private static final String FILENAME = "myFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prolongation);
        Intent intent = getIntent();
        String titre = intent.getStringExtra("titre");
        int indice= intent.getIntExtra("indice", 10);

        TextView textViewLogin = (TextView) findViewById(R.id.textViewTitre);
        textViewLogin.setText("Vous allez prolonger : " + titre);

        buttonValider = (Button) findViewById(R.id.buttonValiderProlongation);

        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intentModifDate = new Intent(getApplicationContext(), ConsulterPretsActivity.class);
                editTextDate = (EditText) findViewById(R.id.editTextDate);
                String nouvelleDate = editTextDate.getText().toString();

                    try {
                        FileWriter fileWriter = new FileWriter("raw/prets.csv");
                        fileWriter.append("test");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    startActivity(intentModifDate);
            }
        });
    }
}
