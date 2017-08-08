package slorah.com.a8_ball;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View.OnKeyListener;

/**
 * Created by anusl on 7/12/2017.
 */

public class QuestionScreen extends AppCompatActivity implements OnKeyListener {

    private Spinner question1Spinner;
    private Spinner question2Spinner;
    private Spinner question3Spinner;
    private Spinner question4Spinner;
    private EditText answer1;
    private EditText answer2;
    private EditText answer3;
    private EditText answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout);

        //get references to the widget
        final Button submitbutton = (Button) findViewById(R.id.submitbutton);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Start Resultscreen.class
                Intent myIntent = new Intent(QuestionScreen.this,
                        ResultScreen.class);
                startActivity(myIntent);
            }
        });

        //get reference to spinners
        question1Spinner = (Spinner) findViewById(R.id.question1Spinner);
        question2Spinner = (Spinner) findViewById(R.id.question2Spinner);
        question3Spinner = (Spinner) findViewById(R.id.question3Spinner);
        question4Spinner = (Spinner) findViewById(R.id.question4Spinner);

        //get references to the input fields
        answer1 = (EditText) findViewById(R.id.answer1);
        answer2 = (EditText) findViewById(R.id.answer2);
        answer3 = (EditText) findViewById(R.id.answer3);
        answer4 = (EditText) findViewById(R.id.answer4);

        //set the listeners
        answer1.setOnKeyListener(this);
        answer2.setOnKeyListener(this);
        answer3.setOnKeyListener(this);
        answer4.setOnKeyListener(this);

        //create array adapter for specified array and layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Questions1,     R.layout.textview);
        question1Spinner.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Questions2,     R.layout.textview);
        question2Spinner.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.Questions3,     R.layout.textview);
        question3Spinner.setAdapter(adapter3);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.Questions4,     R.layout.textview);
        question3Spinner.setAdapter(adapter4);

        //set the layout for the drop-down
        adapter1.setDropDownViewResource(R.layout.textview);
        question1Spinner.setAdapter(adapter1);

        adapter2.setDropDownViewResource(R.layout.textview);
        question2Spinner.setAdapter(adapter2);

        adapter3.setDropDownViewResource(R.layout.textview);
        question3Spinner.setAdapter(adapter3);

        adapter4.setDropDownViewResource(R.layout.textview);
        question4Spinner.setAdapter(adapter4);
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            //hide the soft keyboard
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return false;
    }

}
