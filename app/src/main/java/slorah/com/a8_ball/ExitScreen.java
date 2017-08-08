package slorah.com.a8_ball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

import me.anwarshahriar.calligrapher.Calligrapher;

/**
 * Created by anusl on 8/7/2017.
 */

public class ExitScreen extends AppCompatActivity {

    private static int TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.exitlayout);

        //set page font
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "gabriola.ttf", true);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                finishAffinity();
            }
        }, TIME_OUT);

    }
}
