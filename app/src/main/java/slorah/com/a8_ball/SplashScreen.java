package slorah.com.a8_ball;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by anusl on 7/12/2017.
 */

public class SplashScreen extends AppCompatActivity{

    private static int TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashlayout);

        //handler times out the splashlayout after SPLASH_TIME_OUT
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, IntroScreen.class);
                startActivity(i);
                finish();
            }
        },TIME_OUT);
    }
}
