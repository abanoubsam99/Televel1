package com.example.level1.Quizes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level1.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class QuizT21 extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCORET21 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIST21  = 20000;

    private static final String KEY_SCORET21  = "keyScore";
    private static final String KEY_QUESTION_COUNTT21  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTT21  = "keyMillisLeft";
    private static final String KEY_ANSWEREDT21  = "keyAnswered";
    private static final String KEY_QUESTION_LISTT21  = "keyQuestionList";

    private TextView textViewQuestionT21 ;
    private TextView textViewScoreT21 ;
    private TextView textViewQuestionCountT21 ;
    private TextView textViewCountDownT21 ;
    private RadioGroup rbGroupT21 ;
    private RadioButton rb1T21 ;
    private RadioButton rb2T21 ;
    private RadioButton rb3T21 ;
    private Button buttonConfirmNextT21 ;

    private ColorStateList textColorDefaultRbT21 ;
    private ColorStateList textColorDefaultCdT21 ;

    private CountDownTimer countDownTimerT21 ;
    private long timeLeftInMillisT21 ;

    private ArrayList<QuestionsT21> questionListT21 ;
    private int questionCounterT21 ;
    private int questionCountTotalT21 ;
    private QuestionsT21 currentQuestionT21 ;

    private int scoreT21 ;
    private boolean answeredT21 ;

    private long backPressedTimeT21 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_t21);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionT21 = findViewById(R.id.text_view_questionT21);
        textViewScoreT21 = findViewById(R.id.text_view_scoreT21);
        textViewQuestionCountT21 = findViewById(R.id.text_view_question_countT21);
        textViewCountDownT21 = findViewById(R.id.text_view_countdownT21);
        rbGroupT21 = findViewById(R.id.radio_groupT21);
        rb1T21 = findViewById(R.id.radio_button1T21);
        rb2T21 = findViewById(R.id.radio_button2T21);
        rb3T21= findViewById(R.id.radio_button3T21);
        buttonConfirmNextT21 = findViewById(R.id.button_confirm_nextT21);

        textColorDefaultRbT21= rb1T21.getTextColors();
        textColorDefaultCdT21 = textViewCountDownT21.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListT21 = dbHelper.getAllQuestionsT21();
            questionCountTotalT21 = questionListT21.size();
            Collections.shuffle(questionListT21);

            showNextQuestion();
        } else {
            questionListT21 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTT21);
            questionCountTotalT21 = questionListT21.size();
            questionCounterT21 = savedInstanceState.getInt(KEY_QUESTION_COUNTT21);
            currentQuestionT21 = questionListT21.get(questionCounterT21 - 1);
            scoreT21 = savedInstanceState.getInt(KEY_SCORET21);
            timeLeftInMillisT21 = savedInstanceState.getLong(KEY_MILLIS_LEFTT21);
            answeredT21 = savedInstanceState.getBoolean(KEY_ANSWEREDT21);

            if (!answeredT21) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextT21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredT21) {
                    if (rb1T21.isChecked() || rb2T21.isChecked() || rb3T21.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizT21.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1T21.setTextColor(textColorDefaultRbT21);
        rb2T21.setTextColor(textColorDefaultRbT21);
        rb3T21.setTextColor(textColorDefaultRbT21);
        rbGroupT21.clearCheck();

        if (questionCounterT21 < questionCountTotalT21) {
            currentQuestionT21 = questionListT21.get(questionCounterT21);

            textViewQuestionT21.setText(currentQuestionT21.getQuestionT21());
            rb1T21.setText(currentQuestionT21.getOption1T21());
            rb2T21.setText(currentQuestionT21.getOption2T21());
            rb3T21.setText(currentQuestionT21.getOption3T21());

            questionCounterT21++;
            textViewQuestionCountT21.setText("Question: " + questionCounterT21 + "/" + questionCountTotalT21);
            answeredT21= false;
            buttonConfirmNextT21.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisT21 = COUNTDOWN_IN_MILLIST21;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerT21 = new CountDownTimer(timeLeftInMillisT21, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisT21= millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisT21 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisT21 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisT21 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownT21.setText(timeFormatted);

        if (timeLeftInMillisT21 < 10000) {
            textViewCountDownT21.setTextColor(Color.RED);
        } else {
            textViewCountDownT21.setTextColor(textColorDefaultCdT21);
        }
    }

    private void checkAnswer() {
        answeredT21 = true;

        countDownTimerT21.cancel();

        RadioButton rbSelected = findViewById(rbGroupT21.getCheckedRadioButtonId());
        int answerNr = rbGroupT21.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionT21.getAnswerNrT21()) {
            scoreT21++;
            textViewScoreT21.setText("Score: " + scoreT21);
        }

        showSolution();
    }

    private void showSolution() {
        rb1T21.setTextColor(Color.RED);
        rb2T21.setTextColor(Color.RED);
        rb3T21.setTextColor(Color.RED);

        switch (currentQuestionT21.getAnswerNrT21()) {
            case 1:
                rb1T21.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2T21.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3T21.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterT21 < questionCountTotalT21) {
            buttonConfirmNextT21.setText("التالي ");
        } else {
            buttonConfirmNextT21.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORET21, scoreT21);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizT21.this);
        alert.setMessage( " الدرجة  : "+scoreT21+"\nاعلي درجة  : "+QuizCatalog2.highscoreT21)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizT21.class);
                        startActivity(intent);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        finish();
                    }
                })
                .setNegativeButton("الذهاب للصفحة الرئيسية ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        finish();
                    }
                });

        AlertDialog alertDialog=alert.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTimeT21 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeT21 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerT21 != null) {
            countDownTimerT21.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORET21, scoreT21);
        outState.putInt(KEY_QUESTION_COUNTT21, questionCounterT21);
        outState.putLong(KEY_MILLIS_LEFTT21, timeLeftInMillisT21);
        outState.putBoolean(KEY_ANSWEREDT21, answeredT21);
        outState.putParcelableArrayList(KEY_QUESTION_LISTT21, questionListT21);
    }
}

