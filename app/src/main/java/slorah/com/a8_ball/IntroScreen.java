package slorah.com.a8_ball;

import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.Layout;
import android.util.Log;
import android.widget.TextView;
import android.app.PendingIntent;
import android.app.Notification;
import android.app.NotificationManager;
import me.anwarshahriar.calligrapher.Calligrapher;

import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;

public class IntroScreen extends AppCompatActivity {

    private static int TIME_OUT = 6000;
    private Timer timer;
    private TextView swipeTextView;
    private GestureDetector gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.introlayout);

        startTimer();

        //set page font
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "gabriola.ttf", true);

        //get references
        gestureObject = new GestureDetector(this, new LearnGesture());

        //set
        swipeTextView = (TextView) findViewById(R.id.swipeTextView);

        //handler times out the introlayout after TIME_OUT
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(IntroScreen.this, QuestionScreen.class);
                startActivity(i);
                finish();
            }
        },TIME_OUT);
    }//end onCreate

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
        //int interval = 1000 * 60 * 60;       //10 seconds for testing
        //int interval = 1000 * 60 * 60 * 72;   // 72 hour
        int interval = 1000 * 60 * 60 * 24;   // 24 hour test before launch
        timer.schedule(task, delay, interval);
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }//end startTimer

    private void sendNotification(String text) {
        // create the intent for the notification
        Intent notificationIntent = new Intent(this, IntroScreen.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        int flag = PendingIntent.FLAG_UPDATE_CURRENT;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, flag);

        //Create notification
        int icon = R.mipmap.ic_launcher;
        CharSequence tickerText = "Have a hot date coming up?";
        CharSequence noteText = "Have a hot date coming up? Let us predict your night!";


        //Create notification object
        Notification notification = new NotificationCompat.Builder(this)
                // .setSmallIcon(icon)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker(tickerText)
                .setContentTitle("Magic D8-Ball")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(noteText))
                .setContentText(noteText)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        // display the notification
        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        final int NOTIFICATION_ID = 1;
        manager.notify(NOTIFICATION_ID, notification);
    }//end sendNotification


    //start of code for swipe
    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        //SimpleOnGestureListener listens for what we want to do and how

        private TextView swipeTextView;
        private GestureDetector gDetector;

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            if (event2.getX() > event1.getX()) {
                //left to right swipe
                // Start QuestionScreen.class
                Intent myIntent = new Intent(IntroScreen.this, ContentWarningScreen.class);
                finish();
                startActivity(myIntent);
            } else if (event2.getX() < event1.getX()) {
                //right to left swipe

                Intent myIntent = new Intent(IntroScreen.this, QuestionScreen.class);
                finish();
                startActivity(myIntent);
            }
            return true;
        }

    }//end LearnGesture

}