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

    private Button ajouterNotification;
    AlarmManager alarmManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recevoir_alerte);

        ajouterNotification = (Button) findViewById(R.id.ajouter_notification);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        ajouterNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ajouterAlarme();
            }
        });
    }

    public void ajouterAlarme() {
        Intent intent = new Intent(RecevoirAlerteActivity.this, TimeAlertes.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(1000*60), pendingIntent);
    }
}
