package miage.uparis10.fr.mabu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity{

    Button buttonLogin;
    EditText etLogin, etPassword;
   // EditText etTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                etLogin = (EditText) findViewById(R.id.etLogin);
                etPassword = (EditText) findViewById(R.id.etPassword);
                //etTest = (EditText) findViewById(R.id.etTest);

                String login = etLogin.getText().toString();
                String password = etPassword.getText().toString();
                //String test = etTest.getText().toString();

                intent.putExtra("login",login);
                intent.putExtra("password",password);
                //intent.putExtra("test",Integer.parseInt(test));

                startActivity(intent);
            }
        });
    }

}
