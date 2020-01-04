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

public class QuizT31 extends AppCompatActivity {

    private AdView mAdView;

    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCORET31 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS31  = 20000;

    private static final String KEY_SCORET31  = "keyScore";
    private static final String KEY_QUESTION_COUNTT31  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTT31  = "keyMillisLeft";
    private static final String KEY_ANSWEREDT31  = "keyAnswered";
    private static final String KEY_QUESTION_LISTT31  = "keyQuestionList";

    private TextView textViewQuestionT31 ;
    private TextView textViewScoreT31 ;
    private TextView textViewQuestionCountT31 ;
    private TextView textViewCountDownT31 ;
    private RadioGroup rbGroupT31 ;
    private RadioButton rb1T31 ;
    private RadioButton rb2T31 ;
    private RadioButton rb3T31 ;
    private Button buttonConfirmNextT31 ;

    private ColorStateList textColorDefaultRbT31 ;
    private ColorStateList textColorDefaultCdT31 ;

    private CountDownTimer countDownTimerT31 ;
    private long timeLeftInMillisT31 ;

    private ArrayList<QuestionsT31> questionListT31 ;
    private int questionCounterT31 ;
    private int questionCountTotalT31 ;
    private QuestionsT31 currentQuestionT31 ;

    private int scoreT31 ;
    private boolean answeredT31 ;

    private long backPressedTimeT31 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_t31);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionT31 = findViewById(R.id.text_view_questionT31);
        textViewScoreT31 = findViewById(R.id.text_view_scoreT31);
        textViewQuestionCountT31 = findViewById(R.id.text_view_question_countT31);
        textViewCountDownT31 = findViewById(R.id.text_view_countdownT31);
        rbGroupT31 = findViewById(R.id.radio_groupT31);
        rb1T31 = findViewById(R.id.radio_button1T31);
        rb2T31 = findViewById(R.id.radio_button2T31);
        rb3T31= findViewById(R.id.radio_button3T31);
        buttonConfirmNextT31 = findViewById(R.id.button_confirm_nextT31);

        textColorDefaultRbT31= rb1T31.getTextColors();
        textColorDefaultCdT31 = textViewCountDownT31.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListT31 = dbHelper.getAllQuestionsT31();
            questionCountTotalT31 = questionListT31.size();
            Collections.shuffle(questionListT31);

            showNextQuestion();
        } else {
            questionListT31 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTT31);
            questionCountTotalT31 = questionListT31.size();
            questionCounterT31 = savedInstanceState.getInt(KEY_QUESTION_COUNTT31);
            currentQuestionT31 = questionListT31.get(questionCounterT31 - 1);
            scoreT31 = savedInstanceState.getInt(KEY_SCORET31);
            timeLeftInMillisT31 = savedInstanceState.getLong(KEY_MILLIS_LEFTT31);
            answeredT31 = savedInstanceState.getBoolean(KEY_ANSWEREDT31);

            if (!answeredT31) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextT31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredT31) {
                    if (rb1T31.isChecked() || rb2T31.isChecked() || rb3T31.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizT31.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1T31.setTextColor(textColorDefaultRbT31);
        rb2T31.setTextColor(textColorDefaultRbT31);
        rb3T31.setTextColor(textColorDefaultRbT31);
        rbGroupT31.clearCheck();

        if (questionCounterT31 < questionCountTotalT31) {
            currentQuestionT31 = questionListT31.get(questionCounterT31);

            textViewQuestionT31.setText(currentQuestionT31.getQuestionT31());
            rb1T31.setText(currentQuestionT31.getOption1T31());
            rb2T31.setText(currentQuestionT31.getOption2T31());
            rb3T31.setText(currentQuestionT31.getOption3T31());

            questionCounterT31++;
            textViewQuestionCountT31.setText("Question: " + questionCounterT31 + "/" + questionCountTotalT31);
            answeredT31= false;
            buttonConfirmNextT31.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisT31 = COUNTDOWN_IN_MILLIS31;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerT31 = new CountDownTimer(timeLeftInMillisT31, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisT31= millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisT31 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisT31 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisT31 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownT31.setText(timeFormatted);

        if (timeLeftInMillisT31 < 10000) {
            textViewCountDownT31.setTextColor(Color.RED);
        } else {
            textViewCountDownT31.setTextColor(textColorDefaultCdT31);
        }
    }

    private void checkAnswer() {
        answeredT31 = true;

        countDownTimerT31.cancel();

        RadioButton rbSelected = findViewById(rbGroupT31.getCheckedRadioButtonId());
        int answerNr = rbGroupT31.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionT31.getAnswerNrT31()) {
            scoreT31++;
            textViewScoreT31.setText("Score: " + scoreT31);
        }

        showSolution();
    }

    private void showSolution() {
        rb1T31.setTextColor(Color.RED);
        rb2T31.setTextColor(Color.RED);
        rb3T31.setTextColor(Color.RED);

        switch (currentQuestionT31.getAnswerNrT31()) {
            case 1:
                rb1T31.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2T31.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3T31.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterT31 < questionCountTotalT31) {
            buttonConfirmNextT31.setText("التالي ");
        } else {
            buttonConfirmNextT31.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORET31, scoreT31);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizT31.this);
        alert.setMessage( " الدرجة  : "+scoreT31+"\nاعلي درجة  : "+QuizCatalog3.highscoreT31)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizT31.class);
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
        if (backPressedTimeT31 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeT31 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerT31 != null) {
            countDownTimerT31.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORET31, scoreT31);
        outState.putInt(KEY_QUESTION_COUNTT31, questionCounterT31);
        outState.putLong(KEY_MILLIS_LEFTT31, timeLeftInMillisT31);
        outState.putBoolean(KEY_ANSWEREDT31, answeredT31);
        outState.putParcelableArrayList(KEY_QUESTION_LISTT31, questionListT31);
    }
}
