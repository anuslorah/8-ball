package slorah.com.a8_ball;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import me.anwarshahriar.calligrapher.Calligrapher;


public class ContentWarningScreen extends AppCompatActivity {

    private static int TIME_OUT = 10000;
    private AdView mAdView;


    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentwarninglayout);

        //set page font
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "gabriola.ttf", true);
/*
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.contentwarninglayout, null);
*/
        //get references
        gestureObject = new GestureDetectorCompat(this, new ContentWarningScreen.LearnGesture());

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //handler times out the splashlayout after SPLASH_TIME_OUT
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(ContentWarningScreen.this, IntroScreen.class);
                startActivity(i);
                finish();
            }


        }, TIME_OUT);
    }//end onCreate


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    //create gestureObject class

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        //SimpleOnGestureListener listens for what we want to do and how

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            if (event2.getX() > event1.getX()) {
                //left to right swipe
                // Start QuestionScreen.class
                Intent myIntent = new Intent(ContentWarningScreen.this, SplashScreen.class);

                startActivity(myIntent);
                finish();
            } else if (event2.getX() < event1.getX()) {
                //right to left swipe

                Intent myIntent = new Intent(ContentWarningScreen.this, IntroScreen.class);

                startActivity(myIntent);
                finish();
            }
            return true;
        }
    }//end LearnGesture
}