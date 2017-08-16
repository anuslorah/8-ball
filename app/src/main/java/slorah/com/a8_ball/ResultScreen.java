package slorah.com.a8_ball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import me.anwarshahriar.calligrapher.Calligrapher;

public class ResultScreen extends AppCompatActivity {

    public TextView responseText;
    String[] AnswerArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlayout);

        //set page font
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "gabriola.ttf", true);

        //get references to the widget
        final Button yesButton = (Button) findViewById(R.id.yesButton);
        final Button noButton = (Button) findViewById(R.id.noButton);

        yesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Start Resultscreen.class
                Intent myIntent = new Intent(ResultScreen.this,
                        QuestionScreen.class);
                startActivity(myIntent);
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Start Resultscreen.class
                Intent myIntent = new Intent(ResultScreen.this,
                        ExitScreen.class);
                startActivity(myIntent);
            }
        });

        //get references to the widget
        responseText = (TextView) findViewById(R.id.responsetext);
        //get the array
        AnswerArray = getResources().getStringArray(R.array.Answers);
        updateTextView();
    }//end onCreate

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
