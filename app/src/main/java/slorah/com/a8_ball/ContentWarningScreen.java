package slorah.com.a8_ball;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by anusl on 8/1/2017.
 */

public class ContentWarningScreen extends AppCompatActivity {

    private static int TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentwarninglayout);

        //handler times out the splashlayout after SPLASH_TIME_OUT
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(ContentWarningScreen.this, IntroScreen.class);
                startActivity(i);
                finish();
            }


        }, TIME_OUT);


    }
}
