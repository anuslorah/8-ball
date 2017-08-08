package slorah.com.a8_ball;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import static android.R.id.progress;

import me.anwarshahriar.calligrapher.Calligrapher;

/**
 * Created by anusl on 7/12/2017.
 */

public class TransitionScreen extends AppCompatActivity {

    private static int TIME_OUT = 3000;

    private ProgressBar progressBar;
    //public int n;
    private int progressStatus = 0;
    //private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionlayout);

        //set page font
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "gabriola.ttf", true);

        //get references to the widget
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //handler times out the splashlayout after SPLASH_TIME_OUT
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(TransitionScreen.this, ResultScreen.class);
                startActivity(i);
                progressStatus = 100;
                finish();
            }


        }, TIME_OUT);

        //Random rand = new Random();
        //n = rand.nextInt(50)+1;


        /*
        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 50); // see this max value coming back here, we animale towards that value
        animation.setDuration(500); //in milliseconds
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

        //progressBar.clearAnimation();
        progressBar.setAnimation(null);
        setContentView(R.layout.resultlayout);

        */
    }//end onCreate
}