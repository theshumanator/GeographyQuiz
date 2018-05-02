package com.example.fatoumeh.geographyquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Called from the app. Displays score as toast
    public void submitClicked(View v) {
        int score=getQuizScore(v);

        String userName=((TextView)findViewById(R.id.user_name)).getText().toString();
        if (userName.equalsIgnoreCase("")) {
            userName="Hi";
        }

        Context context = getApplicationContext();
        CharSequence text = userName + ", you scored: " + score + " out of 5!";
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context, text, duration).show();

    }

    //Calculates the score for the different question types and returns score to caller
    private int getQuizScore (View v) {

        int checkBoxScore=0;
        int radioButtonScore=0;
        int freeTextScore=0;

        checkBoxScore=getCheckBoxScore(v);
        radioButtonScore=getRadioButtonScore(v);
        freeTextScore=getFreeTextScore(v);

        int score=checkBoxScore+radioButtonScore+freeTextScore;

        return score;
    }

    //Calculate the score for checkboxes and return to getQuizScore
    private int getCheckBoxScore(View v) {

        CheckBox cbAnswer1=(CheckBox)findViewById(R.id.cb_q4_correct_answer1);
        CheckBox cbAnswer2=(CheckBox)findViewById(R.id.cb_q4_option_b);
        CheckBox cbAnswer3=(CheckBox)findViewById(R.id.cb_q4_option_c);
        CheckBox cbAnswer4=(CheckBox)findViewById(R.id.cb_q4_correct_answer2);

        if ((cbAnswer1.isChecked() && cbAnswer4.isChecked()) && !(cbAnswer2.isChecked() && cbAnswer3.isChecked())) {
            return 1;
        } else {
            return 0;
        }
    }

    //Calculate the score for radio buttons and return to getQuizScore
    private int getRadioButtonScore(View v) {
        int score=0;

        RadioButton q1Answer=(RadioButton) findViewById(R.id.rb_q1_correct_answer);
        RadioButton q2Answer=(RadioButton) findViewById(R.id.rb_q2_correct_answer);
        RadioButton q3Answer=(RadioButton) findViewById(R.id.rb_q3_correct_answer);

        if (q1Answer.isChecked()) {
            score++;
        }

        if (q2Answer.isChecked()) {
            score++;
        }

        if (q3Answer.isChecked()) {
            score++;
        }

        return score;
    }

    //Calculate the score for freetext fields and return to getQuizScore
    private int getFreeTextScore(View v) {

        if (((TextView)findViewById(R.id.text_answer_5)).getText().toString().equalsIgnoreCase("7")) {
            return 1;
        } else {
            return 0;
        }

    }

    //Called from the app - resets the screen
    public void resetClicked(View v) {

        ((TextView) findViewById(R.id.user_name)).setText("");
        ((TextView) findViewById(R.id.text_answer_5)).setText("");

        ((RadioButton)findViewById(R.id.rb_q1_correct_answer)).setChecked(false);
        ((RadioButton)findViewById(R.id.rb_q1_option_a)).setChecked(false);
        ((RadioButton)findViewById(R.id.rb_q1_option_d)).setChecked(false);
        ((RadioButton)findViewById(R.id.rb_q1_option_c)).setChecked(false);

        ((RadioButton)findViewById(R.id.rb_q2_correct_answer)).setChecked(false);
        ((RadioButton)findViewById(R.id.rb_q2_option_a)).setChecked(false);
        ((RadioButton)findViewById(R.id.rb_q2_option_b)).setChecked(false);
        ((RadioButton)findViewById(R.id.rb_q2_option_d)).setChecked(false);

        ((RadioButton)findViewById(R.id.rb_q3_correct_answer)).setChecked(false);
        ((RadioButton)findViewById(R.id.rb_q3_option_a)).setChecked(false);
        ((RadioButton)findViewById(R.id.rb_q3_option_b)).setChecked(false);
        ((RadioButton)findViewById(R.id.rb_q3_option_c)).setChecked(false);

        ((CheckBox)findViewById(R.id.cb_q4_correct_answer1)).setChecked(false);
        ((CheckBox)findViewById(R.id.cb_q4_option_b)).setChecked(false);
        ((CheckBox)findViewById(R.id.cb_q4_option_c)).setChecked(false);
        ((CheckBox)findViewById(R.id.cb_q4_correct_answer2)).setChecked(false);

    }
}
