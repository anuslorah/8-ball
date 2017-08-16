package slorah.com.a8_ball;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import java.util.Random;
import me.anwarshahriar.calligrapher.Calligrapher;

public class QuestionScreen extends AppCompatActivity implements OnKeyListener {

    private EditText answer1;
    private EditText answer2;
    private EditText answer3;

    private TextView Question1;
    private TextView Question2;
    private TextView Question3;

    String[] QuestionArray1;
    String[] QuestionArray2;
    String[] QuestionArray3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout);

        //set page font
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "gabriola.ttf", true);

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

        //get references to the widget
        Question1 = (TextView) findViewById(R.id.Question1);
        Question2 = (TextView) findViewById(R.id.Question2);
        Question3 = (TextView) findViewById(R.id.Question3);

        //get the array
        QuestionArray1 = getResources().getStringArray(R.array.Questions1);
        updateTextView1();
        QuestionArray2 = getResources().getStringArray(R.array.Questions2);
        updateTextView2();
        QuestionArray3 = getResources().getStringArray(R.array.Questions3);
        updateTextView3();

        //get references to the input fields
        answer1 = (EditText) findViewById(R.id.answer1);
        answer1.setImeOptions(EditorInfo.IME_ACTION_DONE);

        answer2 = (EditText) findViewById(R.id.answer2);
        answer2.setImeOptions(EditorInfo.IME_ACTION_DONE);

        answer3 = (EditText) findViewById(R.id.answer3);
        answer3.setImeOptions(EditorInfo.IME_ACTION_DONE);

        //set the listeners
        answer1.setOnKeyListener(this);
        answer2.setOnKeyListener(this);
        answer3.setOnKeyListener(this);
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
    }//end onKey

    /*
        @Override
        protected void onResume() {
            super.onResume();
            updateTextView1();
            updateTextView2();
            updateTextView3();
        }//end onResume
    */
    private void updateTextView1() {
        TextView textView1 = (TextView) findViewById(R.id.Question1);
        Random random = new Random();

        int maxIndex1 = QuestionArray1.length;
        int generatedIndex1 = random.nextInt(maxIndex1);
        textView1.setText(QuestionArray1[generatedIndex1]);
    }

    private void updateTextView2() {
        TextView textView2 = (TextView) findViewById(R.id.Question2);
        Random random = new Random();

        int maxIndex2 = QuestionArray2.length;
        int generatedIndex2 = random.nextInt(maxIndex2);
        textView2.setText(QuestionArray2[generatedIndex2]);
    }

    private void updateTextView3() {

        TextView textView3 = (TextView) findViewById(R.id.Question3);
        Random random = new Random();

        int maxIndex3 = QuestionArray3.length;
        int generatedIndex3 = random.nextInt(maxIndex3);
        textView3.setText(QuestionArray3[generatedIndex3]);
    }
}
