package miage.uparis10.fr.mabu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

        // Recuperer contenu de la vrais page

//TEST 1
/*
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL("http://scd.u-paris10.fr/").openConnection();
            conn.connect();

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

            byte[] bytes = new byte[1024];
            int tmp ;
            while( (tmp = bis.read(bytes) ) != -1 ) {
                String chaine = new String(bytes,0,tmp);
                System.out.print(chaine);
            }

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


//Test 2
  /*          String toreturn = null;
            try {
                //Creation d'un objet URL
                URL url = new URL("http://scd.u-paris10.fr/");
                //on etablie une connection a cette url
                URLConnection uc = url.openConnection();
                //on y cree un flux de lecture
                InputStream in = uc.getInputStream();
                //on lit le premier bit
                int c = in.read();
                //on cree un StringBuilder pour par la suite y ajouter tout les bit lus
                StringBuilder build = new StringBuilder();
                //tant que c n'est pas egale au bit indiquant la fin d'un flux...
                while (c != -1) {
                    build.append((char) c);
                //...on l'ajoute dasn le StringBuilder...
                    c = in.read();
                //...on lit le suivant
                }
                //on retourne le code de la page
                toreturn = build.toString();

            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
            System.out.print(toreturn);

*/
//TEST 3
/*
        URL oracle = null;
        try {
            oracle = new URL("http://www.oracle.com/");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


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
