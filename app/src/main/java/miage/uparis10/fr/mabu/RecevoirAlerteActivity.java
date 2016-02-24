package miage.uparis10.fr.mabu;


import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class RecevoirAlerteActivity extends AppCompatActivity {

    private Button notification5m;
    private Button notification1h;
    private Button notification5m_avant;
    private Button notification_prets;
    private EditText choixJour;
    AlarmManager alarmManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recevoir_alerte);

        notification5m = (Button) findViewById(R.id.notification5m);
        notification1h = (Button) findViewById(R.id.notification1h);
        notification5m_avant = (Button) findViewById(R.id.notification5m_avant);
        notification_prets = (Button) findViewById(R.id.notification_prets);

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        notification5m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ajouterAlarme(5, 1, 1);
            }
        });
        notification1h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ajouterAlarme(60, 1, 1);
            }
        });
        notification5m_avant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Calendar calendar = Calendar.getInstance();
                int dateCourante = calendar.get(Calendar.DAY_OF_MONTH);
                int dateRendu = calendar.get(Calendar.DAY_OF_MONTH) + 1;
                int dateRestant = dateRendu - dateCourante;
                ajouterAlarme(1, 1, dateRestant);
            }
        });
        notification_prets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                choixJour = (EditText) findViewById(R.id.choixJour);
                String recup = choixJour.getText().toString();
                if(recup.length() == 0){
                    AlertDialog.Builder adb = new AlertDialog.Builder(RecevoirAlerteActivity.this);
                    adb.setTitle("Alerte");
                    adb.setMessage("Veuillez rentrer un nombre de jours");
                    adb.setPositiveButton("Ok", null);
                    adb.show();
                }
                else {
                    try {
                        int jour = parseInt(recup);
                        ajouterAlarme(1, 1, jour);
                        AlertDialog.Builder adb = new AlertDialog.Builder(RecevoirAlerteActivity.this);
                        adb.setTitle("Info");
                        adb.setMessage("Notification créée avec succès");
                        adb.setPositiveButton("Ok", null);
                        adb.show();
                    }
                    catch(Exception e){
                        AlertDialog.Builder adb = new AlertDialog.Builder(RecevoirAlerteActivity.this);
                        adb.setTitle("Alerte");
                        adb.setMessage("Veuillez rentrer un nombre de jours");
                        adb.setPositiveButton("Ok", null);
                        adb.show();
                    }
                }
            }
        });
    }
    public void ajouterAlarme(int minutes, int heures, int jours){
        Intent intent = new Intent(RecevoirAlerteActivity.this, TimeAlertes.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1000 * 60 * minutes * heures * jours), pendingIntent);
    }

}
