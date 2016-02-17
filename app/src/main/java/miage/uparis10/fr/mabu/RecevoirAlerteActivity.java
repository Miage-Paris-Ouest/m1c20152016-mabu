package miage.uparis10.fr.mabu;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.Calendar;

public class RecevoirAlerteActivity extends AppCompatActivity {

    private Button notification5m;
    private Button notification1h;
    private Button notification1j;
    private Button notification7j;
    AlarmManager alarmManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recevoir_alerte);

        notification5m = (Button) findViewById(R.id.notification5m);
        notification1h = (Button) findViewById(R.id.notification1h);
        notification1j = (Button) findViewById(R.id.notification1j);
        notification7j = (Button) findViewById(R.id.notification7j);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        notification5m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ajouterAlarme(5,1,1);
            }
        });
        notification1h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ajouterAlarme(60,1,1);
            }
        });
        notification1j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ajouterAlarme(60,24,1);
            }
        });
        notification7j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ajouterAlarme(60,24,7);
            }
        });
    }

    public void ajouterAlarme(int minutes, int heures, int jours) {
        /*Calendar calendar = Calendar.getInstance();
        calendar.set(2016,02,11,12,43);*/
        Intent intent = new Intent(RecevoirAlerteActivity.this, TimeAlertes.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(1000*60*minutes*heures*jours), pendingIntent);
    }
}
