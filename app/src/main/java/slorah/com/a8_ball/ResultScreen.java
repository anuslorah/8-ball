package slorah.com.a8_ball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by anusl on 7/12/2017.
 */


public class ResultScreen extends AppCompatActivity {

    private Button yesButton;
    private Button noButton;
    public TextView responseText;
    String[] AnswerArray;
    //String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlayout);


        //get references to the widget
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);
        responseText = (TextView) findViewById(R.id.responsetext);
        //get the array
        AnswerArray = getResources().getStringArray(R.array.Answers);
        responseText.setText("gggg");
        //textView.setText(AnswerArray[generatedIndex]);

        //updateTextView();


    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTextView();
    }

    private void updateTextView() {
        TextView textView = (TextView) findViewById(R.id.responsetext);
        Random random = new Random();

        int maxIndex = AnswerArray.length;
        int generatedIndex = random.nextInt(maxIndex);

        //textView.setText("Boo");

        textView.setText(AnswerArray[generatedIndex]);
    }


    //clicking yes button transitions to questionlayout and no transitions to exitlayout
    public void goToQuestion(View view) {
        setContentView(R.layout.questionlayout);
    }

    public void goToExit(View view) {
        setContentView(R.layout.exitlayout);
    }

}
