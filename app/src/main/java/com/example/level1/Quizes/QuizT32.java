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

public class QuizT32 extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    public static final String EXTRA_SCORET32 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIST32  = 20000;

    private static final String KEY_SCORET32  = "keyScore";
    private static final String KEY_QUESTION_COUNTT32  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTT32  = "keyMillisLeft";
    private static final String KEY_ANSWEREDT32  = "keyAnswered";
    private static final String KEY_QUESTION_LISTT32  = "keyQuestionList";

    private TextView textViewQuestionT32 ;
    private TextView textViewScoreT32 ;
    private TextView textViewQuestionCountT32 ;
    private TextView textViewCountDownT32 ;
    private RadioGroup rbGroupT32 ;
    private RadioButton rb1T32 ;
    private RadioButton rb2T32 ;
    private RadioButton rb3T32 ;
    private Button buttonConfirmNextT32 ;

    private ColorStateList textColorDefaultRbT32 ;
    private ColorStateList textColorDefaultCdT32 ;

    private CountDownTimer countDownTimerT32 ;
    private long timeLeftInMillisT32 ;

    private ArrayList<QuestionsT32> questionListT32 ;
    private int questionCounterT32 ;
    private int questionCountTotalT32 ;
    private QuestionsT32 currentQuestionT32 ;

    private int scoreT32 ;
    private boolean answeredT32;

    private long backPressedTimeT32 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_t32);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionT32 = findViewById(R.id.text_view_questionT32);
        textViewScoreT32 = findViewById(R.id.text_view_scoreT32);
        textViewQuestionCountT32 = findViewById(R.id.text_view_question_countT32);
        textViewCountDownT32 = findViewById(R.id.text_view_countdownT32);
        rbGroupT32 = findViewById(R.id.radio_groupT32);
        rb1T32 = findViewById(R.id.radio_button1T32);
        rb2T32 = findViewById(R.id.radio_button2T32);
        rb3T32= findViewById(R.id.radio_button3T32);
        buttonConfirmNextT32 = findViewById(R.id.button_confirm_nextT32);

        textColorDefaultRbT32 = rb1T32.getTextColors();
        textColorDefaultCdT32 = textViewCountDownT32.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListT32 = dbHelper.getAllQuestionsT32();
            questionCountTotalT32 = questionListT32.size();
            Collections.shuffle(questionListT32);

            showNextQuestion();
        } else {
            questionListT32 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTT32);
            questionCountTotalT32 = questionListT32.size();
            questionCounterT32 = savedInstanceState.getInt(KEY_QUESTION_COUNTT32);
            currentQuestionT32 = questionListT32.get(questionCounterT32 - 1);
            scoreT32 = savedInstanceState.getInt(KEY_SCORET32);
            timeLeftInMillisT32 = savedInstanceState.getLong(KEY_MILLIS_LEFTT32);
            answeredT32 = savedInstanceState.getBoolean(KEY_ANSWEREDT32);

            if (!answeredT32) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextT32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredT32) {
                    if (rb1T32.isChecked() || rb2T32.isChecked() || rb3T32.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizT32.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1T32.setTextColor(textColorDefaultRbT32);
        rb2T32.setTextColor(textColorDefaultRbT32);
        rb3T32.setTextColor(textColorDefaultRbT32);
        rbGroupT32.clearCheck();

        if (questionCounterT32 < questionCountTotalT32) {
            currentQuestionT32 = questionListT32.get(questionCounterT32);

            textViewQuestionT32.setText(currentQuestionT32.getQuestionT32());
            rb1T32.setText(currentQuestionT32.getOption1T32());
            rb2T32.setText(currentQuestionT32.getOption2T32());
            rb3T32.setText(currentQuestionT32.getOption3T32());

            questionCounterT32++;
            textViewQuestionCountT32.setText("Question: " + questionCounterT32 + "/" + questionCountTotalT32);
            answeredT32 = false;
            buttonConfirmNextT32.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisT32 = COUNTDOWN_IN_MILLIST32;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerT32 = new CountDownTimer(timeLeftInMillisT32, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisT32 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisT32 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisT32 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisT32 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownT32.setText(timeFormatted);

        if (timeLeftInMillisT32 < 10000) {
            textViewCountDownT32.setTextColor(Color.RED);
        } else {
            textViewCountDownT32.setTextColor(textColorDefaultCdT32);
        }
    }

    private void checkAnswer() {
        answeredT32 = true;

        countDownTimerT32.cancel();

        RadioButton rbSelected = findViewById(rbGroupT32.getCheckedRadioButtonId());
        int answerNr = rbGroupT32.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionT32.getAnswerNrT32()) {
            scoreT32++;
            textViewScoreT32.setText("Score: " + scoreT32);
        }

        showSolution();
    }

    private void showSolution() {
        rb1T32.setTextColor(Color.RED);
        rb2T32.setTextColor(Color.RED);
        rb3T32.setTextColor(Color.RED);

        switch (currentQuestionT32.getAnswerNrT32()) {
            case 1:
                rb1T32.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2T32.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3T32.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterT32 < questionCountTotalT32) {
            buttonConfirmNextT32.setText("التالي ");
        } else {
            buttonConfirmNextT32.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORET32, scoreT32);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizT32.this);
        alert.setMessage( " الدرجة  : "+scoreT32+"\nاعلي درجة  : "+QuizCatalog3.highscoreT32)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizT32.class);
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
        if (backPressedTimeT32 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeT32 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerT32 != null) {
            countDownTimerT32.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORET32, scoreT32);
        outState.putInt(KEY_QUESTION_COUNTT32, questionCounterT32);
        outState.putLong(KEY_MILLIS_LEFTT32, timeLeftInMillisT32);
        outState.putBoolean(KEY_ANSWEREDT32, answeredT32);
        outState.putParcelableArrayList(KEY_QUESTION_LISTT32, questionListT32);
    }
}
