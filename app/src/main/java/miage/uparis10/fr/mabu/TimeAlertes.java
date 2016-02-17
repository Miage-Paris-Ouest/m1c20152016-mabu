package miage.uparis10.fr.mabu;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Philippe on 11/02/2016.
 */
public class TimeAlertes extends BroadcastReceiver {

    NotificationManager notificationManager;

    @Override
    public void onReceive(Context context, Intent intent){

        CharSequence titreNotification = "Alerte - Retour emprunt";
        CharSequence descNotification = "Vous devez bientôt rendre votre document";

        notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new Notification(R.drawable.notification, titreNotification, System.currentTimeMillis());
        PendingIntent contentIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), new Intent(), PendingIntent.FLAG_ONE_SHOT);
        notification.defaults |= Notification.DEFAULT_VIBRATE;

        Notification.Builder builder = new Notification.Builder(context)
                .setWhen(System.currentTimeMillis())
                .setTicker(titreNotification)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle(titreNotification)
                .setContentText(descNotification)
                .setContentIntent(contentIntent);
        builder.setVibrate(new long[] { 0,200,100,200,100,200 });
        notificationManager.notify(1, builder.build());
    }
}
