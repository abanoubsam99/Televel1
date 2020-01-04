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

public class QuizT23 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    public static final String EXTRA_SCORET23 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIST23  = 20000;

    private static final String KEY_SCORET23  = "keyScore";
    private static final String KEY_QUESTION_COUNTT23  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTT23  = "keyMillisLeft";
    private static final String KEY_ANSWEREDT23  = "keyAnswered";
    private static final String KEY_QUESTION_LISTT23  = "keyQuestionList";

    private TextView textViewQuestionT23 ;
    private TextView textViewScoreT23 ;
    private TextView textViewQuestionCountT23 ;
    private TextView textViewCountDownT23 ;
    private RadioGroup rbGroupT23 ;
    private RadioButton rb1T23 ;
    private RadioButton rb2T23 ;
    private RadioButton rb3T23 ;
    private Button buttonConfirmNextT23 ;

    private ColorStateList textColorDefaultRbT23;
    private ColorStateList textColorDefaultCdT23 ;

    private CountDownTimer countDownTimerT23 ;
    private long timeLeftInMillisT23 ;

    private ArrayList<QuestionsT23> questionListT23 ;
    private int questionCounterT23 ;
    private int questionCountTotalT23 ;
    private QuestionsT23 currentQuestionT23 ;

    private int scoreT23 ;
    private boolean answeredT23 ;

    private long backPressedTimeT23 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_t23);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionT23 = findViewById(R.id.text_view_questionT23);
        textViewScoreT23 = findViewById(R.id.text_view_scoreT23);
        textViewQuestionCountT23 = findViewById(R.id.text_view_question_countT23);
        textViewCountDownT23 = findViewById(R.id.text_view_countdownT23);
        rbGroupT23 = findViewById(R.id.radio_groupT23);
        rb1T23= findViewById(R.id.radio_button1T23);
        rb2T23 = findViewById(R.id.radio_button2T23);
        rb3T23= findViewById(R.id.radio_button3T23);
        buttonConfirmNextT23= findViewById(R.id.button_confirm_nextT23);

        textColorDefaultRbT23 = rb1T23.getTextColors();
        textColorDefaultCdT23= textViewCountDownT23.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListT23 = dbHelper.getAllQuestionsT23();
            questionCountTotalT23 = questionListT23.size();
            Collections.shuffle(questionListT23);

            showNextQuestion();
        } else {
            questionListT23 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTT23);
            questionCountTotalT23 = questionListT23.size();
            questionCounterT23 = savedInstanceState.getInt(KEY_QUESTION_COUNTT23);
            currentQuestionT23 = questionListT23.get(questionCounterT23 - 1);
            scoreT23 = savedInstanceState.getInt(KEY_SCORET23);
            timeLeftInMillisT23 = savedInstanceState.getLong(KEY_MILLIS_LEFTT23);
            answeredT23 = savedInstanceState.getBoolean(KEY_ANSWEREDT23);

            if (!answeredT23) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextT23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredT23) {
                    if (rb1T23.isChecked() || rb2T23.isChecked() || rb3T23.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizT23.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1T23.setTextColor(textColorDefaultRbT23);
        rb2T23.setTextColor(textColorDefaultRbT23);
        rb3T23.setTextColor(textColorDefaultRbT23);
        rbGroupT23.clearCheck();

        if (questionCounterT23 < questionCountTotalT23) {
            currentQuestionT23 = questionListT23.get(questionCounterT23);

            textViewQuestionT23.setText(currentQuestionT23.getQuestionT23());
            rb1T23.setText(currentQuestionT23.getOption1T23());
            rb2T23.setText(currentQuestionT23.getOption2T23());
            rb3T23.setText(currentQuestionT23.getOption3T23());

            questionCounterT23++;
            textViewQuestionCountT23.setText("Question: " + questionCounterT23 + "/" + questionCountTotalT23);
            answeredT23 = false;
            buttonConfirmNextT23.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisT23 = COUNTDOWN_IN_MILLIST23;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerT23 = new CountDownTimer(timeLeftInMillisT23, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisT23 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisT23 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisT23 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisT23 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownT23.setText(timeFormatted);

        if (timeLeftInMillisT23 < 10000) {
            textViewCountDownT23.setTextColor(Color.RED);
        } else {
            textViewCountDownT23.setTextColor(textColorDefaultCdT23);
        }
    }

    private void checkAnswer() {
        answeredT23 = true;

        countDownTimerT23.cancel();

        RadioButton rbSelected = findViewById(rbGroupT23.getCheckedRadioButtonId());
        int answerNr = rbGroupT23.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionT23.getAnswerNrT23()) {
            scoreT23++;
            textViewScoreT23.setText("Score: " + scoreT23);
        }

        showSolution();
    }

    private void showSolution() {
        rb1T23.setTextColor(Color.RED);
        rb2T23.setTextColor(Color.RED);
        rb3T23.setTextColor(Color.RED);

        switch (currentQuestionT23.getAnswerNrT23()) {
            case 1:
                rb1T23.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2T23.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3T23.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterT23 < questionCountTotalT23) {
            buttonConfirmNextT23.setText("التالي ");
        } else {
            buttonConfirmNextT23.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORET23, scoreT23);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizT23.this);
        alert.setMessage( " الدرجة  : "+scoreT23+"\nاعلي درجة  : "+QuizCatalog2.highscoreT23)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizT23.class);
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
        if (backPressedTimeT23 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeT23 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerT23 != null) {
            countDownTimerT23.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORET23, scoreT23);
        outState.putInt(KEY_QUESTION_COUNTT23, questionCounterT23);
        outState.putLong(KEY_MILLIS_LEFTT23, timeLeftInMillisT23);
        outState.putBoolean(KEY_ANSWEREDT23, answeredT23);
        outState.putParcelableArrayList(KEY_QUESTION_LISTT23, questionListT23);
    }
}

