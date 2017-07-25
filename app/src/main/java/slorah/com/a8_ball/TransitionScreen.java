package slorah.com.a8_ball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by anusl on 7/12/2017.
 */

public class TransitionScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    //private static int TIME_OUT = 3000;
    //private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionlayout);

        //get references to the widget
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //startTimer();
    }//end onCreate
/*
    private void startTimer(){

        //Log.d("tag","inside timer");
        //create task
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                setContentView(R.layout.resultlayout);
            }
        };

        //create and start timer
        timer = new Timer(true);
        timer.schedule(task, TIME_OUT);
    }
 */
}//end of TransitionScreen class
