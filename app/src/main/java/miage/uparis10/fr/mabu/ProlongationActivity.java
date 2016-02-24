package miage.uparis10.fr.mabu;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProlongationActivity extends AppCompatActivity {

    Button buttonValider;
    EditText editTextDate;
    ListView maListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prolongation);
        Intent intent = getIntent();
        String titre = intent.getStringExtra("titre");
        int indice= intent.getIntExtra("indice", 10);

        TextView textViewLogin = (TextView) findViewById(R.id.textViewTitre);
        textViewLogin.setText("Vous allez prolonger : " + titre);


        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator +"BlogData"+File.separator+"MyText.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        if(file.exists()){
            try {
                FileWriter fileWriter  = new FileWriter(file);
                BufferedWriter bfWriter = new BufferedWriter(fileWriter);
                bfWriter.write("Text Data");
                bfWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
/*
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter("/test.csv"), ',');
            // feed in your array (or convert your data to an array)
            String[] entries = "first#second#third".split("#");
            writer.writeNext(entries);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        buttonValider = (Button) findViewById(R.id.buttonValiderProlongation);

        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentModifDate = new Intent(getApplicationContext(), ConsulterPretsActivity.class);
                editTextDate = (EditText) findViewById(R.id.editTextDate);
                String nouvelleDate = editTextDate.getText().toString();


                startActivity(intentModifDate);
            }
        });

    }
}
