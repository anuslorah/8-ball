package slorah.com.a8_ball;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import me.anwarshahriar.calligrapher.Calligrapher;

import android.view.View.OnTouchListener;

import static android.R.attr.content;

public class ContentWarningScreen extends AppCompatActivity {

    private static int TIME_OUT = 10000;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentwarninglayout);

        //set page font
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "gabriola.ttf", true);

        .setTouchListener(new OnSwipeTouchListener(ContentWarningScreen.this) {
            public void onSwipeLeft() {
                // Start Introscreen.class
                Intent myIntent = new Intent(ContentWarningScreen.this,
                        IntroScreen.class);
                startActivity(myIntent);
            }

            public void onSwipeRight() {
                // Start QuestionScreen.class
                Intent myIntent = new Intent(ContentWarningScreen.this,
                        QuestionScreen.class);
                startActivity(myIntent);
            }
        });

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
}