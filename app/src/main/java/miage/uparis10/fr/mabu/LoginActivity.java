package miage.uparis10.fr.mabu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity{

    Button buttonLogincsv,buttonLoginapi;
    EditText etLogin, etPassword;
    int i=0;
   // EditText etTest;


    public boolean checkLogin(String username) {

        // Lis le CSV et compare username et les données
        // Return true si login trouvé, false sinon

        ArrayList<String> listeLogins = new ArrayList<String>();
        try{
            InputStream inputStream = getResources().openRawResource(R.raw.logins);
            InputStreamReader ipsr=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;

            while ((ligne=br.readLine())!=null){

                // ON DECOUPE LE TABLEAU A CHAQUE ";"
                String[] tableau=ligne.split(";");
                for(String val : tableau)
                {
                    listeLogins.add(val);
                }

                for(int j=0; j<listeLogins.size();j++){
                    if (username.equals(listeLogins.get(j))) {
                        return true;
                    }
                }

            }

            br.close();

        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogincsv = (Button) findViewById(R.id.buttonLogincsv);
        buttonLoginapi = (Button) findViewById(R.id.buttonLoginapi);

        //action bouton CSV
        buttonLogincsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                etLogin = (EditText) findViewById(R.id.etLogin);
                //etPassword = (EditText) findViewById(R.id.etPassword);
                //etTest = (EditText) findViewById(R.id.etTest);

                String login = etLogin.getText().toString();
                boolean logged = checkLogin(login);
                //String password = etPassword.getText().toString();
                //String test = etTest.getText().toString();

                intent.putExtra("login",login);
                //intent.putExtra("password",password);
                //intent.putExtra("test",Integer.parseInt(test));
                intent.putExtra("typeBd",0);
                if(logged==true)
                    startActivity(intent);
                else
                {
                    AlertDialog.Builder adb = new AlertDialog.Builder(LoginActivity.this);
                    //on attribut un titre à notre boite de dialogue
                    adb.setTitle("Erreur Login");
                    //on insère un message à notre boite de dialogue, et ici on affiche le titre de l'item cliqué
                    adb.setMessage("Veuillez entrer un login correct");
                    adb.setPositiveButton("Ok", null);
                    //on affiche la boite de dialogue
                    adb.show();

                }
            }
        });

        //action bouton API
        buttonLoginapi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                etLogin = (EditText) findViewById(R.id.etLogin);
                //etPassword = (EditText) findViewById(R.id.etPassword);
                //etTest = (EditText) findViewById(R.id.etTest);

                String login = etLogin.getText().toString();
                //String password = etPassword.getText().toString();
                //String test = etTest.getText().toString();

                intent.putExtra("login",login);
                //intent.putExtra("password",password);
                //intent.putExtra("test",Integer.parseInt(test));
                intent.putExtra("typeBd",1);
                startActivity(intent);
            }
        });

    }

}
