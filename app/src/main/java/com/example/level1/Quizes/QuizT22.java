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

public class QuizT22 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCORET22 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIST22  = 20000;

    private static final String KEY_SCORET22  = "keyScore";
    private static final String KEY_QUESTION_COUNTT22  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTT22  = "keyMillisLeft";
    private static final String KEY_ANSWEREDT22  = "keyAnswered";
    private static final String KEY_QUESTION_LISTT22  = "keyQuestionList";

    private TextView textViewQuestionT22 ;
    private TextView textViewScoreT22 ;
    private TextView textViewQuestionCountT22 ;
    private TextView textViewCountDownT22 ;
    private RadioGroup rbGroupT22 ;
    private RadioButton rb1T22 ;
    private RadioButton rb2T22 ;
    private RadioButton rb3T22 ;
    private Button buttonConfirmNextT22 ;

    private ColorStateList textColorDefaultRbT22 ;
    private ColorStateList textColorDefaultCdT22 ;

    private CountDownTimer countDownTimerT22 ;
    private long timeLeftInMillisT22 ;

    private ArrayList<QuestionsT22> questionListT22 ;
    private int questionCounterT22 ;
    private int questionCountTotalT22 ;
    private QuestionsT22 currentQuestionT22 ;

    private int scoreT22 ;
    private boolean answeredT22;

    private long backPressedTimeT22 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_t22);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionT22 = findViewById(R.id.text_view_questionT22);
        textViewScoreT22 = findViewById(R.id.text_view_scoreT22);
        textViewQuestionCountT22 = findViewById(R.id.text_view_question_countT22);
        textViewCountDownT22 = findViewById(R.id.text_view_countdownT22);
        rbGroupT22 = findViewById(R.id.radio_groupT22);
        rb1T22 = findViewById(R.id.radio_button1T22);
        rb2T22 = findViewById(R.id.radio_button2T22);
        rb3T22= findViewById(R.id.radio_button3T22);
        buttonConfirmNextT22 = findViewById(R.id.button_confirm_nextT22);

        textColorDefaultRbT22 = rb1T22.getTextColors();
        textColorDefaultCdT22 = textViewCountDownT22.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListT22 = dbHelper.getAllQuestionsT22();
            questionCountTotalT22 = questionListT22.size();
            Collections.shuffle(questionListT22);

            showNextQuestion();
        } else {
            questionListT22 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTT22);
            questionCountTotalT22 = questionListT22.size();
            questionCounterT22 = savedInstanceState.getInt(KEY_QUESTION_COUNTT22);
            currentQuestionT22 = questionListT22.get(questionCounterT22 - 1);
            scoreT22 = savedInstanceState.getInt(KEY_SCORET22);
            timeLeftInMillisT22 = savedInstanceState.getLong(KEY_MILLIS_LEFTT22);
            answeredT22 = savedInstanceState.getBoolean(KEY_ANSWEREDT22);

            if (!answeredT22) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextT22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredT22) {
                    if (rb1T22.isChecked() || rb2T22.isChecked() || rb3T22.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizT22.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1T22.setTextColor(textColorDefaultRbT22);
        rb2T22.setTextColor(textColorDefaultRbT22);
        rb3T22.setTextColor(textColorDefaultRbT22);
        rbGroupT22.clearCheck();

        if (questionCounterT22 < questionCountTotalT22) {
            currentQuestionT22 = questionListT22.get(questionCounterT22);

            textViewQuestionT22.setText(currentQuestionT22.getQuestionT22());
            rb1T22.setText(currentQuestionT22.getOption1T22());
            rb2T22.setText(currentQuestionT22.getOption2T22());
            rb3T22.setText(currentQuestionT22.getOption3T22());

            questionCounterT22++;
            textViewQuestionCountT22.setText("Question: " + questionCounterT22 + "/" + questionCountTotalT22);
            answeredT22 = false;
            buttonConfirmNextT22.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisT22 = COUNTDOWN_IN_MILLIST22;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerT22 = new CountDownTimer(timeLeftInMillisT22, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisT22 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisT22 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisT22 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisT22 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownT22.setText(timeFormatted);

        if (timeLeftInMillisT22 < 10000) {
            textViewCountDownT22.setTextColor(Color.RED);
        } else {
            textViewCountDownT22.setTextColor(textColorDefaultCdT22);
        }
    }

    private void checkAnswer() {
        answeredT22 = true;

        countDownTimerT22.cancel();

        RadioButton rbSelected = findViewById(rbGroupT22.getCheckedRadioButtonId());
        int answerNr = rbGroupT22.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionT22.getAnswerNrT22()) {
            scoreT22++;
            textViewScoreT22.setText("Score: " + scoreT22);
        }

        showSolution();
    }

    private void showSolution() {
        rb1T22.setTextColor(Color.RED);
        rb2T22.setTextColor(Color.RED);
        rb3T22.setTextColor(Color.RED);

        switch (currentQuestionT22.getAnswerNrT22()) {
            case 1:
                rb1T22.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2T22.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3T22.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterT22 < questionCountTotalT22) {
            buttonConfirmNextT22.setText("التالي ");
        } else {
            buttonConfirmNextT22.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORET22, scoreT22);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizT22.this);
        alert.setMessage( " الدرجة  : "+scoreT22+"\nاعلي درجة  : "+QuizCatalog2.highscoreT22)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizT22.class);
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
        if (backPressedTimeT22 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeT22 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerT22 != null) {
            countDownTimerT22.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORET22, scoreT22);
        outState.putInt(KEY_QUESTION_COUNTT22, questionCounterT22);
        outState.putLong(KEY_MILLIS_LEFTT22, timeLeftInMillisT22);
        outState.putBoolean(KEY_ANSWEREDT22, answeredT22);
        outState.putParcelableArrayList(KEY_QUESTION_LISTT22, questionListT22);
    }
}

