package slorah.com.a8_ball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IntroScreen extends AppCompatActivity {

    private TextView introText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introlayout);

        //get references to the widget
         introText = (TextView) findViewById(R.id.introText);
    }


}
