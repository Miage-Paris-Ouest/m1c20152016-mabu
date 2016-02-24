package miage.uparis10.fr.mabu;

import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Orion on 11/02/2016.
 */
public class BdCsv extends AppCompatActivity {
    private String Bd;
    public ArrayList<String> liste = new ArrayList<String>();

    public BdCsv(String bd) {
        Bd = bd;
    }

    public ArrayList<String> lirBd(){
        try{
            InputStream inputStream = getResources().openRawResource(R.raw.prets);

            InputStreamReader ipsr=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;

            while ((ligne=br.readLine())!=null){

                // ON DECOUPE LE TABLEAU A CHAQUE ";"
                String[] tableau=ligne.split(";");

                for(int x=0;x< tableau.length;x++)
                {
                    System.out.println("TROUVER :"+tableau[x]);
                }

                for(String val : tableau)
                {
                    liste.add(val);
                    //i++;
                }

            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return liste;
    }

    public int testLecture(){
        return 2;

    }


    public String getBd() {
        return Bd;
    }

    public void setBd(String bd) {
        Bd = bd;
    }


}
