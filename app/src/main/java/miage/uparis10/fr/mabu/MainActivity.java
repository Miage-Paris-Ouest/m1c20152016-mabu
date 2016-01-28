package miage.uparis10.fr.mabu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String login = intent.getStringExtra("login");
        String password = intent.getStringExtra("password");

        //int test= intent.getIntExtra("test",10);


        TextView textViewLogin = (TextView) findViewById(R.id.textLogin);
        textViewLogin.setText("Bonjour " + login);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listView);

        // Defined Array values to show in ListView
        String[] values = new String[] {
                "Rechercher un livre",
                "Consulter les prêts",
                "Recevoir des alertes",
                "Informations pratiques",
                "Contacter"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.listitem, R.id.list_item, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String  itemValue = (String) listView.getItemAtPosition(position);

                switch(position) {
                    case 0:
                        Intent intentRechercherLivre = new Intent(getApplicationContext(), RechercherLivreActivity.class);
                        startActivity(intentRechercherLivre);
                        break;
                    case 1:
                        Intent intentConsulterPrets = new Intent(getApplicationContext(), ConsulterPretsActivity.class);
                        startActivity(intentConsulterPrets);
                        break;
                    case 2:
                        Intent intentRecevoirAlerte = new Intent(getApplicationContext(), RecevoirAlerteActivity.class);
                        startActivity(intentRecevoirAlerte);
                        break;
                    case 3:
                        Intent intentInfos = new Intent(getApplicationContext(), InfosActivity.class);
                        startActivity(intentInfos);
                        break;
                    case 4:
                        Intent intentContact = new Intent(getApplicationContext(), ContactActivity.class);
                        startActivity(intentContact);
                        break;
                }

            }

        });

    }
}
