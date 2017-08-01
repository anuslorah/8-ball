package com.example.zbrinlee.magic8ball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by anusl on 7/12/2017.
 */

public class QuestionScreen extends AppCompatActivity {

    private Spinner question1Spinner;
    private Spinner question2Spinner;
    private Spinner question3Spinner;
    private Spinner question4Spinner;

    private Button submitbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout);

        //get references to the widget
        submitbutton = (Button) findViewById(R.id.submitbutton);

        //get reference to spinners
        question1Spinner = (Spinner) findViewById(R.id.question1Spinner);
        question2Spinner = (Spinner) findViewById(R.id.question2Spinner);
        question3Spinner = (Spinner) findViewById(R.id.question3Spinner);
        question4Spinner = (Spinner) findViewById(R.id.question4Spinner);

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
    //clicking the button transitions to transitionlayout
    public void goToTransition(View view){
        setContentView(R.layout.transitionlayout);
    }

}
