package miage.uparis10.fr.mabu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity{

    Button buttonLogincsv,buttonLoginapi;
    EditText etLogin, etPassword;
   // EditText etTest;

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
                //String password = etPassword.getText().toString();
                //String test = etTest.getText().toString();

                intent.putExtra("login",login);
                //intent.putExtra("password",password);
                //intent.putExtra("test",Integer.parseInt(test));
                intent.putExtra("typeBd",0);
                startActivity(intent);
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
