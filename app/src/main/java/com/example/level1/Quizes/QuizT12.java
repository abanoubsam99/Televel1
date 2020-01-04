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

public class QuizT12 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCORET12 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIST12  = 20000;

    private static final String KEY_SCORET12  = "keyScore";
    private static final String KEY_QUESTION_COUNTT12  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTT12  = "keyMillisLeft";
    private static final String KEY_ANSWEREDT12  = "keyAnswered";
    private static final String KEY_QUESTION_LISTT12  = "keyQuestionList";

    private TextView textViewQuestionT12 ;
    private TextView textViewScoreT12 ;
    private TextView textViewQuestionCountT12 ;
    private TextView textViewCountDownT12 ;
    private RadioGroup rbGroupT12 ;
    private RadioButton rb1T12 ;
    private RadioButton rb2T12 ;
    private RadioButton rb3T12 ;
    private Button buttonConfirmNextT12 ;

    private ColorStateList textColorDefaultRbT12 ;
    private ColorStateList textColorDefaultCdT12 ;

    private CountDownTimer countDownTimerT12 ;
    private long timeLeftInMillisT12 ;

    private ArrayList<QuestionsT12> questionListT12 ;
    private int questionCounterT12 ;
    private int questionCountTotalT12 ;
    private QuestionsT12 currentQuestionT12 ;

    private int scoreT12 ;
    private boolean answeredT12;

    private long backPressedTimeT12 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_t12);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionT12 = findViewById(R.id.text_view_questionT12);
        textViewScoreT12 = findViewById(R.id.text_view_scoreT12);
        textViewQuestionCountT12 = findViewById(R.id.text_view_question_countT12);
        textViewCountDownT12 = findViewById(R.id.text_view_countdownT12);
        rbGroupT12 = findViewById(R.id.radio_groupT12);
        rb1T12 = findViewById(R.id.radio_button1T12);
        rb2T12 = findViewById(R.id.radio_button2T12);
        rb3T12= findViewById(R.id.radio_button3T12);
        buttonConfirmNextT12 = findViewById(R.id.button_confirm_nextT12);

        textColorDefaultRbT12 = rb1T12.getTextColors();
        textColorDefaultCdT12 = textViewCountDownT12.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListT12 = dbHelper.getAllQuestionsT12();
            questionCountTotalT12 = questionListT12.size();
            Collections.shuffle(questionListT12);

            showNextQuestion();
        } else {
            questionListT12 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTT12);
            questionCountTotalT12 = questionListT12.size();
            questionCounterT12 = savedInstanceState.getInt(KEY_QUESTION_COUNTT12);
            currentQuestionT12 = questionListT12.get(questionCounterT12 - 1);
            scoreT12 = savedInstanceState.getInt(KEY_SCORET12);
            timeLeftInMillisT12 = savedInstanceState.getLong(KEY_MILLIS_LEFTT12);
            answeredT12 = savedInstanceState.getBoolean(KEY_ANSWEREDT12);

            if (!answeredT12) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextT12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredT12) {
                    if (rb1T12.isChecked() || rb2T12.isChecked() || rb3T12.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizT12.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1T12.setTextColor(textColorDefaultRbT12);
        rb2T12.setTextColor(textColorDefaultRbT12);
        rb3T12.setTextColor(textColorDefaultRbT12);
        rbGroupT12.clearCheck();

        if (questionCounterT12 < questionCountTotalT12) {
            currentQuestionT12 = questionListT12.get(questionCounterT12);

            textViewQuestionT12.setText(currentQuestionT12.getQuestionT12());
            rb1T12.setText(currentQuestionT12.getOption1T12());
            rb2T12.setText(currentQuestionT12.getOption2T12());
            rb3T12.setText(currentQuestionT12.getOption3T12());

            questionCounterT12++;
            textViewQuestionCountT12.setText("Question: " + questionCounterT12 + "/" + questionCountTotalT12);
            answeredT12 = false;
            buttonConfirmNextT12.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisT12 = COUNTDOWN_IN_MILLIST12;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerT12 = new CountDownTimer(timeLeftInMillisT12, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisT12 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisT12 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisT12 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisT12 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownT12.setText(timeFormatted);

        if (timeLeftInMillisT12 < 10000) {
            textViewCountDownT12.setTextColor(Color.RED);
        } else {
            textViewCountDownT12.setTextColor(textColorDefaultCdT12);
        }
    }

    private void checkAnswer() {
        answeredT12 = true;

        countDownTimerT12.cancel();

        RadioButton rbSelected = findViewById(rbGroupT12.getCheckedRadioButtonId());
        int answerNr = rbGroupT12.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionT12.getAnswerNrT12()) {
            scoreT12++;
            textViewScoreT12.setText("Score: " + scoreT12);
        }

        showSolution();
    }

    private void showSolution() {
        rb1T12.setTextColor(Color.RED);
        rb2T12.setTextColor(Color.RED);
        rb3T12.setTextColor(Color.RED);

        switch (currentQuestionT12.getAnswerNrT12()) {
            case 1:
                rb1T12.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2T12.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3T12.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterT12 < questionCountTotalT12) {
            buttonConfirmNextT12.setText("التالي ");
        } else {
            buttonConfirmNextT12.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORET12, scoreT12);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizT12.this);
        alert.setMessage( " الدرجة  : "+scoreT12+"\nاعلي درجة  : "+QuizCatalog1.highscoreT12)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizT12.class);
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
        if (backPressedTimeT12 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeT12 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerT12 != null) {
            countDownTimerT12.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORET12, scoreT12);
        outState.putInt(KEY_QUESTION_COUNTT12, questionCounterT12);
        outState.putLong(KEY_MILLIS_LEFTT12, timeLeftInMillisT12);
        outState.putBoolean(KEY_ANSWEREDT12, answeredT12);
        outState.putParcelableArrayList(KEY_QUESTION_LISTT12, questionListT12);
    }
}
