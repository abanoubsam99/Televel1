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

public class QuizT13 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    public static final String EXTRA_SCORET13 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIST13  = 20000;

    private static final String KEY_SCORET13  = "keyScore";
    private static final String KEY_QUESTION_COUNTT13  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTT13  = "keyMillisLeft";
    private static final String KEY_ANSWEREDT13  = "keyAnswered";
    private static final String KEY_QUESTION_LISTT13  = "keyQuestionList";

    private TextView textViewQuestionT13 ;
    private TextView textViewScoreT13 ;
    private TextView textViewQuestionCountT13 ;
    private TextView textViewCountDownT13 ;
    private RadioGroup rbGroupT13 ;
    private RadioButton rb1T13 ;
    private RadioButton rb2T13 ;
    private RadioButton rb3T13 ;
    private Button buttonConfirmNextT13 ;

    private ColorStateList textColorDefaultRbT13;
    private ColorStateList textColorDefaultCdT13 ;

    private CountDownTimer countDownTimerT13 ;
    private long timeLeftInMillisT13 ;

    private ArrayList<QuestionsT13> questionListT13 ;
    private int questionCounterT13 ;
    private int questionCountTotalT13 ;
    private QuestionsT13 currentQuestionT13 ;

    private int scoreT13 ;
    private boolean answeredT13 ;

    private long backPressedTimeT13 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_t13);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionT13 = findViewById(R.id.text_view_questionT13);
        textViewScoreT13 = findViewById(R.id.text_view_scoreT13);
        textViewQuestionCountT13 = findViewById(R.id.text_view_question_countT13);
        textViewCountDownT13 = findViewById(R.id.text_view_countdownT13);
        rbGroupT13 = findViewById(R.id.radio_groupT13);
        rb1T13= findViewById(R.id.radio_button1T13);
        rb2T13 = findViewById(R.id.radio_button2T13);
        rb3T13= findViewById(R.id.radio_button3T13);
        buttonConfirmNextT13= findViewById(R.id.button_confirm_nextT13);

        textColorDefaultRbT13 = rb1T13.getTextColors();
        textColorDefaultCdT13= textViewCountDownT13.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListT13 = dbHelper.getAllQuestionsT13();
            questionCountTotalT13 = questionListT13.size();
            Collections.shuffle(questionListT13);

            showNextQuestion();
        } else {
            questionListT13 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTT13);
            questionCountTotalT13 = questionListT13.size();
            questionCounterT13 = savedInstanceState.getInt(KEY_QUESTION_COUNTT13);
            currentQuestionT13 = questionListT13.get(questionCounterT13 - 1);
            scoreT13 = savedInstanceState.getInt(KEY_SCORET13);
            timeLeftInMillisT13 = savedInstanceState.getLong(KEY_MILLIS_LEFTT13);
            answeredT13 = savedInstanceState.getBoolean(KEY_ANSWEREDT13);

            if (!answeredT13) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextT13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredT13) {
                    if (rb1T13.isChecked() || rb2T13.isChecked() || rb3T13.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizT13.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1T13.setTextColor(textColorDefaultRbT13);
        rb2T13.setTextColor(textColorDefaultRbT13);
        rb3T13.setTextColor(textColorDefaultRbT13);
        rbGroupT13.clearCheck();

        if (questionCounterT13 < questionCountTotalT13) {
            currentQuestionT13 = questionListT13.get(questionCounterT13);

            textViewQuestionT13.setText(currentQuestionT13.getQuestionT13());
            rb1T13.setText(currentQuestionT13.getOption1T13());
            rb2T13.setText(currentQuestionT13.getOption2T13());
            rb3T13.setText(currentQuestionT13.getOption3T13());

            questionCounterT13++;
            textViewQuestionCountT13.setText("Question: " + questionCounterT13 + "/" + questionCountTotalT13);
            answeredT13 = false;
            buttonConfirmNextT13.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisT13 = COUNTDOWN_IN_MILLIST13;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerT13 = new CountDownTimer(timeLeftInMillisT13, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisT13 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisT13 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisT13 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisT13 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownT13.setText(timeFormatted);

        if (timeLeftInMillisT13 < 10000) {
            textViewCountDownT13.setTextColor(Color.RED);
        } else {
            textViewCountDownT13.setTextColor(textColorDefaultCdT13);
        }
    }

    private void checkAnswer() {
        answeredT13 = true;

        countDownTimerT13.cancel();

        RadioButton rbSelected = findViewById(rbGroupT13.getCheckedRadioButtonId());
        int answerNr = rbGroupT13.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionT13.getAnswerNrT13()) {
            scoreT13++;
            textViewScoreT13.setText("Score: " + scoreT13);
        }

        showSolution();
    }

    private void showSolution() {
        rb1T13.setTextColor(Color.RED);
        rb2T13.setTextColor(Color.RED);
        rb3T13.setTextColor(Color.RED);

        switch (currentQuestionT13.getAnswerNrT13()) {
            case 1:
                rb1T13.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2T13.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3T13.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterT13 < questionCountTotalT13) {
            buttonConfirmNextT13.setText("التالي ");
        } else {
            buttonConfirmNextT13.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORET13, scoreT13);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizT13.this);
        alert.setMessage( " الدرجة  : "+scoreT13+"\nاعلي درجة  : "+QuizCatalog1.highscoreT13)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizT13.class);
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
        if (backPressedTimeT13 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeT13 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerT13 != null) {
            countDownTimerT13.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORET13, scoreT13);
        outState.putInt(KEY_QUESTION_COUNTT13, questionCounterT13);
        outState.putLong(KEY_MILLIS_LEFTT13, timeLeftInMillisT13);
        outState.putBoolean(KEY_ANSWEREDT13, answeredT13);
        outState.putParcelableArrayList(KEY_QUESTION_LISTT13, questionListT13);
    }
}
