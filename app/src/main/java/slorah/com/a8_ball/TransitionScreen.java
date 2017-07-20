package slorah.com.a8_ball;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by anusl on 7/12/2017.
 */


public class TransitionScreen extends AppCompatActivity {

    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionlayout);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(TransitionScreen.this, ResultScreen.class);
                startActivity(intent);
                finish();
            }
        },TIME_OUT);
    }//end onCreate

}//end of TransitionScreen class
