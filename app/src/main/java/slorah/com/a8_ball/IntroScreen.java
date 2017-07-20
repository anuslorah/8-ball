package slorah.com.a8_ball;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IntroScreen extends AppCompatActivity {

    private TextView introText;
    private static int TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.introlayout);

        //get references to the widget
        introText = (TextView) findViewById(R.id.introText);

        //handler times out the introlayout after TIME_OUT
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(IntroScreen.this, QuestionScreen.class);
                startActivity(i);
                finish();
            }
        },TIME_OUT);
    }
}
