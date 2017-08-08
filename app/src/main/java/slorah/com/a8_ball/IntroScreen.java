package slorah.com.a8_ball;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.app.PendingIntent;
import android.app.Notification;
import android.app.NotificationManager;

import me.anwarshahriar.calligrapher.Calligrapher;

public class IntroScreen extends AppCompatActivity {

    private TextView introText;
    private static int TIME_OUT = 5000;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.introlayout);
        startTimer();

        //set page font
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "gabriola.ttf", true);

        //get references to the widget
        introText = (TextView) findViewById(R.id.introText);

        //handler times out the introlayout after TIME_OUT
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(IntroScreen.this, QuestionScreen.class);
                startActivity(i);
                finish();
            }
        },TIME_OUT);

        //Handler.removeCallback();
    }

    private void startTimer() {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                Log.d("Magic 8 Ball", "Timer task started");

                // display notification
                sendNotification("Select to view see your predicition.");
            }

        };

        timer = new Timer(true);
        int delay = 1000 * 10;           // 50 seconds
        int interval = 1000 * 60 * 60;       //10 seconds for testing
        //int interval = 1000 * 60 * 60 * 72;   // 72 hour
        timer.schedule(task, delay, interval);
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    private void sendNotification(String text) {
        // create the intent for the notification
        Intent notificationIntent = new Intent(this, IntroScreen.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        int flag = PendingIntent.FLAG_UPDATE_CURRENT;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, flag);

        //Create notification
        //needs to be linked to the correct icon once finalized
        int icon = R.mipmap.ic_launcher;
        CharSequence tickerText = "Have a hot date coming up?";
        CharSequence noteText = "Have a hot date coming up?";

        //Create notification object
        Notification notification = new Notification.Builder(this)
                // .setSmallIcon(icon)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker(tickerText)
                .setContentText(noteText)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        // display the notification
        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        final int NOTIFICATION_ID = 1;
        manager.notify(NOTIFICATION_ID, notification);
    }

}