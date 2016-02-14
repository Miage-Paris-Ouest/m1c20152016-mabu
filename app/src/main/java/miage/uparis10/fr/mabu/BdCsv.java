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

            InputStream inputStream = getResources().openRawResource(R.raw.bd);
            InputStreamReader ipsr=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            String[] tableau;

            while ((ligne=br.readLine())!=null){
                tableau = ligne.split(";");
                liste.add(Arrays.toString(tableau));
            }

            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return liste;
    }


    public String getBd() {
        return Bd;
    }

    public void setBd(String bd) {
        Bd = bd;
    }


}
