package slorah.com.a8_ball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by anusl on 7/12/2017.
 */


public class ResultScreen extends AppCompatActivity {

    private Button yesButton;
    private Button noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlayout);

        //get references to the widget
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);
    }
    //clicking yes button transitions to questionlayout and no transitions to exitlayout

    public void goToQuestion(View view) {
        setContentView(R.layout.questionlayout);
    }

    public void goToExit(View view) {
        setContentView(R.layout.exitlayout);
    }

}
