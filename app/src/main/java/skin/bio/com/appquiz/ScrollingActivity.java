package skin.bio.com.appquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {
    EditText answerOneEditText;
    RadioGroup answerTwoRadioGroup,answerFourRadioGroup,answerSixRadioGroup;
    RadioButton radio_answer_2_a,radio_answer_4_a,radio_answer_6_d;
    CheckBox answerThreeCheckBoxOne;
    CheckBox answerThreeCheckBoxTwo;
    CheckBox answerThreeCheckBoxThree;
    CheckBox answerThreeCheckBoxFour;
    ImageView img,img1,mark;
    EditText answerFiveEditText;
    TextView right_answer,right_answer_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        answerOneEditText = findViewById(R.id.text_answer_1);
        answerTwoRadioGroup = findViewById(R.id.radio_group_answer_2);
        radio_answer_2_a = findViewById(R.id.radio_answer_2_a);
        answerThreeCheckBoxOne = findViewById(R.id.check_box_answer_3_a);
        answerThreeCheckBoxTwo = findViewById(R.id.check_box_answer_3_b);
        answerThreeCheckBoxThree = findViewById(R.id.check_box_answer_3_c);
        answerThreeCheckBoxFour = findViewById(R.id.check_box_answer_3_d);
        answerFourRadioGroup = findViewById(R.id.radio_group_answer_4);
        radio_answer_4_a = findViewById(R.id.radio_answer_4_a);
        answerSixRadioGroup = findViewById(R.id.radio_group_answer_6);
        radio_answer_6_d = findViewById(R.id.radio_answer_6_d);
        answerFiveEditText = findViewById(R.id.text_answer_5);
        right_answer = findViewById(R.id.right_answer);
        right_answer_5 = findViewById(R.id.right_answer_5);
        img = findViewById(R.id.img);
        img1 = findViewById(R.id.img1);
        mark = findViewById(R.id.mark);
    }
    //Methode to submit user answers and give score by showing only rights answers in the toast
    public void submitQuiz(View view) {
        int score = 0;
        int total = 6;
        String answer1 = answerOneEditText.getText().toString();
        if (answer1.equalsIgnoreCase(getString(R.string.answer_1))) {
            score += 1;
            answerOneEditText.setBackgroundColor(Color.GREEN);
            mark.setVisibility(View.VISIBLE);
            mark.setBackgroundResource(R.drawable.tick);
        }
        else{
            answerOneEditText.setBackgroundColor(Color.RED);
            mark.setVisibility(View.VISIBLE);
            mark.setBackgroundResource(R.drawable.close);
            right_answer.setVisibility(View.VISIBLE);
            right_answer.setText(R.string.answer_1);
            right_answer.setTextColor(Color.GREEN);
        }
        if (answerTwoRadioGroup.getCheckedRadioButtonId() == R.id.radio_answer_2_a) {
            score += 1;
            radio_answer_2_a.setBackgroundColor(Color.GREEN);
        }
        else{
            radio_answer_2_a.setBackgroundColor(Color.GREEN);
        }
        if (  answerThreeCheckBoxTwo.isChecked()&& answerThreeCheckBoxFour.isChecked() && !(answerThreeCheckBoxOne.isChecked())&&(!answerThreeCheckBoxThree.isChecked())) {
            score += 1;
            answerThreeCheckBoxTwo.setBackgroundColor(Color.GREEN );
            answerThreeCheckBoxFour.setBackgroundColor(Color.GREEN);
        }
        else{
            answerThreeCheckBoxTwo.setBackgroundColor(Color.GREEN );
            answerThreeCheckBoxFour.setBackgroundColor(Color.GREEN);
            answerThreeCheckBoxOne.setBackgroundColor(Color.RED);
            answerThreeCheckBoxThree.setBackgroundColor(Color.RED);
        }

        if (answerFourRadioGroup.getCheckedRadioButtonId() == R.id.radio_answer_4_a) {
            score += 1;
            radio_answer_4_a.setBackgroundColor(Color.GREEN);        }
        else{
            radio_answer_4_a.setBackgroundColor(Color.GREEN);

        }
        String answer5 = answerFiveEditText.getText().toString();
        if (answer5.equalsIgnoreCase(getString(R.string.answer_5))) {
            score += 1;
            answerFiveEditText.setBackgroundColor(Color.GREEN);
        }
        else{
            answerFiveEditText.setBackgroundColor(Color.RED);
            right_answer_5.setVisibility(View.VISIBLE);
            right_answer_5.setText(R.string.answer_5);
            right_answer_5.setTextColor(Color.GREEN);
        }

        if (answerSixRadioGroup.getCheckedRadioButtonId() == R.id.radio_answer_6_d) {
        score += 1;
            radio_answer_6_d.setBackgroundColor(Color.GREEN);
    }
        else{
            radio_answer_6_d.setBackgroundColor(Color.GREEN);
        }
        Toast.makeText(this, getString(R.string.result_score_message, score, total), Toast.LENGTH_LONG).show();
    }
    //Methode to reset to zero all values quiz questions
    public void resetAnswers(View view) {
        answerOneEditText.setText("");
        answerOneEditText.setBackgroundColor(Color.WHITE);
        radio_answer_2_a.setBackgroundColor(Color.WHITE);
        answerThreeCheckBoxTwo.setBackgroundColor(Color.WHITE );
        answerThreeCheckBoxFour.setBackgroundColor(Color.WHITE);
        answerThreeCheckBoxOne.setBackgroundColor(Color.WHITE);
        answerThreeCheckBoxThree.setBackgroundColor(Color.WHITE);
        radio_answer_4_a.setBackgroundColor(Color.WHITE);
        answerFiveEditText.setBackgroundColor(Color.WHITE);
        radio_answer_6_d.setBackgroundColor(Color.WHITE);
        right_answer.setVisibility(View.INVISIBLE);
        right_answer_5.setVisibility(View.INVISIBLE);
        answerTwoRadioGroup.clearCheck();
        answerFourRadioGroup.clearCheck();
        answerThreeCheckBoxOne.setChecked(false);
        answerThreeCheckBoxTwo.setChecked(false);
        answerThreeCheckBoxThree.setChecked(false);
        answerThreeCheckBoxFour.setChecked(false);
        answerFiveEditText.setText("");
        answerSixRadioGroup.clearCheck();
        mark.setVisibility(View.INVISIBLE);
    }
}
