package miage.uparis10.fr.mabu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.*;
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
        try {
            URLConnexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void URLConnexion()throws Exception{
            URL oracle = new URL("http://www.oracle.com/");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        }
    }
