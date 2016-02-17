package miage.uparis10.fr.mabu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class InfosActivity extends AppCompatActivity {
    int j=0;
    TextView actualiteTitre;
    TextView actualiteContenu;
    TextView horaires;
    ListView maListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);


        //Récupération de la listview créée dans le fichier main.xml
        maListViewPerso = (ListView) findViewById(R.id.listView);

        //Création de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
        ArrayList<String> listeActus = new ArrayList<String>();

        try{
            InputStream inputStream = getResources().openRawResource(R.raw.infos);
            InputStreamReader ipsr=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;

            while ((ligne=br.readLine())!=null){

                // ON DECOUPE LE TABLEAU A CHAQUE ";"
                String[] tableau=ligne.split(";");
                for(String val : tableau)
                {
                    listeActus.add(val);
                }

                map = new HashMap<String, String>();
                map.put("titre",listeActus.get(j));
                j++;
                map.put("description",listeActus.get(j));
                j++;
                listItem.add(map);
            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.item_liste_actus,
                new String[] {"titre", "description"}, new int[] {R.id.titre, R.id.description});

        //On attribut à notre listView l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(mSchedule);


        // HORAIRES //
        j=0;
        ArrayList<String> listeHoraire= new ArrayList<String>();

        try{
            InputStream inputStream = getResources().openRawResource(R.raw.horaires);
            InputStreamReader ipsr=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;

            while ((ligne=br.readLine())!=null){

                // ON DECOUPE LE TABLEAU A CHAQUE ";"
                String[] tableau=ligne.split(";");
                for(String val : tableau)
                {
                    listeHoraire.add(val);
                }

            }
            horaires = (TextView) findViewById(R.id.textViewHoraires);
            horaires.setText(listeHoraire.get(0) + "\n" + listeHoraire.get(1) + "\n" + listeHoraire.get(2) + "\n" + listeHoraire.get(3)+ "\n" + listeHoraire.get(4)+ "\n" + listeHoraire.get(5));
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }


    }
}
