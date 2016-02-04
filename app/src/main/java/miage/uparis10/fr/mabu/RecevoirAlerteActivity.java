package miage.uparis10.fr.mabu;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RecevoirAlerteActivity extends AppCompatActivity {

    private Button ajouterNotification;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recevoir_alerte);

        ajouterNotification = (Button) findViewById(R.id.ajouter_notification);
        ajouterNotification.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                createNotification();
            }
        });
    }

    private final void createNotification(){
        final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        final Intent launchNotifiactionIntent = new Intent(this,RecevoirAlerteActivity.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, launchNotifiactionIntent, PendingIntent.FLAG_ONE_SHOT);

        final String titreNotification = getResources().getString(R.string.titre_notification);
        final String descNotification = getResources().getString(R.string.desc_notification);

        final Notification notification = new Notification(R.drawable.notification, titreNotification, System.currentTimeMillis());
        notification.defaults |= Notification.DEFAULT_VIBRATE;

        Notification.Builder builder = new Notification.Builder(this)
                .setWhen(System.currentTimeMillis())
                .setTicker(titreNotification)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle(titreNotification)
                .setContentText(descNotification)
                .setContentIntent(pendingIntent);
        builder.setVibrate(new long[] { 0,200,100,200,100,200 });

        notificationManager.notify(01, builder.build());
    }
}
