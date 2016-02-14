package miage.uparis10.fr.mabu;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ConsulterPretsActivity extends AppCompatActivity {
    ListView maListViewPerso;
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

//Récupération de la listview créée dans le fichier main.xml
        maListViewPerso = (ListView) findViewById(R.id.listView);

        //Création de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;

        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView

        ArrayList<String> liste = new ArrayList<String>();
        /*
        // CHERCHER DANS LE FICHIER CSV LES ELEMENT


        try{
            InputStream inputStream = getResources().openRawResource(R.raw.bd);
            InputStreamReader ipsr=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;


            while ((ligne=br.readLine())!=null){
                // ON DECOUPE LE TABLEAU A CHAQUE ;
                String[] tableau=ligne.split(";");
                for(String val : tableau)
                {
                    // ON AJOUTE A L'arrayListe
                    liste.add(val);
                }


            }



            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        // FIN CHERCHER DANS LE FICHIER CSV
        */

        // LISTIG DE TOUS LES EMPRUNT EN COUR
        try{
            InputStream inputStream = getResources().openRawResource(R.raw.bd);
            InputStreamReader ipsr=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;



            while ((ligne=br.readLine())!=null){
                int i=0;
                // ON DECOUPE LE TABLEAU A CHAQUE ";"
                String[] tableau=ligne.split(";");
                for(String val : tableau)
                {
                    liste.add(val);
                    i++;
                }

                map = new HashMap<String, String>();
                map.put("titre", "Titre : "+liste.get(0));
                map.put("description","Resuer : "+liste.get(2));
                map.put("img", String.valueOf(R.drawable.icone_book));
                listItem.add(map);
            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }


/*
        map = new HashMap<String, String>();
        map.put("titre", "Le titre");
        map.put("description", "Le resume ");
        map.put("img", String.valueOf(R.drawable.icone_book));
        listItem.add(map);*/




        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.item_liste_prets,
                new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});

        //On attribut à notre listView l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(mSchedule);

        //Enfin on met un écouteur d'évènement sur notre listView
        maListViewPerso.setOnItemClickListener(new OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                //on récupère la HashMap contenant les infos de notre item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                //on créer une boite de dialogue
                AlertDialog.Builder adb = new AlertDialog.Builder(ConsulterPretsActivity.this);
                //on attribut un titre à notre boite de dialogue
                adb.setTitle("Sélection Item");
                //on insère un message à notre boite de dialogue, et ici on affiche le titre de l'item cliqué
                adb.setMessage("Votre choix : "+map.get("titre"));
                //on indique que l'on veut le bouton ok à notre boite de dialogue
                adb.setPositiveButton("Ok", null);
                //on affiche la boite de dialogue
                adb.show();
            }
        });

    }
}
