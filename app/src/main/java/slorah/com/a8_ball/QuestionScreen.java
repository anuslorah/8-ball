package slorah.com.a8_ball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by anusl on 7/12/2017.
 */

public class QuestionScreen extends AppCompatActivity {

    private Button submitbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout);

        //get references to the widget
        submitbutton = (Button) findViewById(R.id.submitbutton);

    }
    //clicking the button transitions to transitionlayout
    public void goToTransition(View view){
        setContentView(R.layout.transitionlayout);
    }

}
