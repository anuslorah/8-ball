package slorah.com.a8_ball;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import static android.R.id.progress;


/**
 * Created by anusl on 7/12/2017.
 */

public class TransitionScreen extends AppCompatActivity {

    private ProgressBar progressBar = null;
    //private int progressStatus = 0;
    //private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionlayout);

        //get references to the widget
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 50); // see this max value coming back here, we animale towards that value
        animation.setDuration(500); //in milliseconds
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

        //progressBar.clearAnimation();
        progressBar.setAnimation(null);
        setContentView(R.layout.resultlayout);


    }//end onCreate
}