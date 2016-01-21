package miage.uparis10.fr.mabu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ConsulterPretsActivity extends AppCompatActivity {
    ListView maListe;
    String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };
    @Override
    //http://tutos-android-france.com/listview-afficher-une-liste-delements/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_prets);
        maListe = (ListView) findViewById(R.id.listView2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ConsulterPretsActivity.this,
                android.R.layout.simple_list_item_1, prenoms);
        maListe.setAdapter(adapter);
    }
}
