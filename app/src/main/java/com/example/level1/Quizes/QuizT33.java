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

public class QuizT33 extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCORET33 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIST33  = 20000;

    private static final String KEY_SCORET33  = "keyScore";
    private static final String KEY_QUESTION_COUNTT33  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTT33  = "keyMillisLeft";
    private static final String KEY_ANSWEREDT33  = "keyAnswered";
    private static final String KEY_QUESTION_LISTT33  = "keyQuestionList";

    private TextView textViewQuestionT33 ;
    private TextView textViewScoreT33 ;
    private TextView textViewQuestionCountT33 ;
    private TextView textViewCountDownT33 ;
    private RadioGroup rbGroupT33 ;
    private RadioButton rb1T33 ;
    private RadioButton rb2T33 ;
    private RadioButton rb3T33 ;
    private Button buttonConfirmNextT33 ;

    private ColorStateList textColorDefaultRbT33;
    private ColorStateList textColorDefaultCdT33 ;

    private CountDownTimer countDownTimerT33 ;
    private long timeLeftInMillisT33 ;

    private ArrayList<QuestionsT33> questionListT33 ;
    private int questionCounterT33 ;
    private int questionCountTotalT33 ;
    private QuestionsT33 currentQuestionT33 ;

    private int scoreT33 ;
    private boolean answeredT33 ;

    private long backPressedTimeT33 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_t33);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionT33 = findViewById(R.id.text_view_questionT33);
        textViewScoreT33 = findViewById(R.id.text_view_scoreT33);
        textViewQuestionCountT33 = findViewById(R.id.text_view_question_countT33);
        textViewCountDownT33 = findViewById(R.id.text_view_countdownT33);
        rbGroupT33 = findViewById(R.id.radio_groupT33);
        rb1T33= findViewById(R.id.radio_button1T33);
        rb2T33 = findViewById(R.id.radio_button2T33);
        rb3T33= findViewById(R.id.radio_button3T33);
        buttonConfirmNextT33= findViewById(R.id.button_confirm_nextT33);

        textColorDefaultRbT33 = rb1T33.getTextColors();
        textColorDefaultCdT33= textViewCountDownT33.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListT33 = dbHelper.getAllQuestionsT33();
            questionCountTotalT33 = questionListT33.size();
            Collections.shuffle(questionListT33);

            showNextQuestion();
        } else {
            questionListT33 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTT33);
            questionCountTotalT33 = questionListT33.size();
            questionCounterT33 = savedInstanceState.getInt(KEY_QUESTION_COUNTT33);
            currentQuestionT33 = questionListT33.get(questionCounterT33 - 1);
            scoreT33 = savedInstanceState.getInt(KEY_SCORET33);
            timeLeftInMillisT33 = savedInstanceState.getLong(KEY_MILLIS_LEFTT33);
            answeredT33 = savedInstanceState.getBoolean(KEY_ANSWEREDT33);

            if (!answeredT33) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextT33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredT33) {
                    if (rb1T33.isChecked() || rb2T33.isChecked() || rb3T33.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizT33.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1T33.setTextColor(textColorDefaultRbT33);
        rb2T33.setTextColor(textColorDefaultRbT33);
        rb3T33.setTextColor(textColorDefaultRbT33);
        rbGroupT33.clearCheck();

        if (questionCounterT33 < questionCountTotalT33) {
            currentQuestionT33 = questionListT33.get(questionCounterT33);

            textViewQuestionT33.setText(currentQuestionT33.getQuestionT33());
            rb1T33.setText(currentQuestionT33.getOption1T33());
            rb2T33.setText(currentQuestionT33.getOption2T33());
            rb3T33.setText(currentQuestionT33.getOption3T33());

            questionCounterT33++;
            textViewQuestionCountT33.setText("Question: " + questionCounterT33 + "/" + questionCountTotalT33);
            answeredT33 = false;
            buttonConfirmNextT33.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisT33 = COUNTDOWN_IN_MILLIST33;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerT33 = new CountDownTimer(timeLeftInMillisT33, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisT33 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisT33 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisT33 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisT33 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownT33.setText(timeFormatted);

        if (timeLeftInMillisT33 < 10000) {
            textViewCountDownT33.setTextColor(Color.RED);
        } else {
            textViewCountDownT33.setTextColor(textColorDefaultCdT33);
        }
    }

    private void checkAnswer() {
        answeredT33 = true;

        countDownTimerT33.cancel();

        RadioButton rbSelected = findViewById(rbGroupT33.getCheckedRadioButtonId());
        int answerNr = rbGroupT33.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionT33.getAnswerNrT33()) {
            scoreT33++;
            textViewScoreT33.setText("Score: " + scoreT33);
        }

        showSolution();
    }

    private void showSolution() {
        rb1T33.setTextColor(Color.RED);
        rb2T33.setTextColor(Color.RED);
        rb3T33.setTextColor(Color.RED);

        switch (currentQuestionT33.getAnswerNrT33()) {
            case 1:
                rb1T33.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2T33.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3T33.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterT33 < questionCountTotalT33) {
            buttonConfirmNextT33.setText("التالي ");
        } else {
            buttonConfirmNextT33.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORET33, scoreT33);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizT33.this);
        alert.setMessage( " الدرجة  : "+scoreT33+"\nاعلي درجة  : "+QuizCatalog3.highscoreT33)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizT33.class);
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
        if (backPressedTimeT33 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeT33 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerT33 != null) {
            countDownTimerT33.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORET33, scoreT33);
        outState.putInt(KEY_QUESTION_COUNTT33, questionCounterT33);
        outState.putLong(KEY_MILLIS_LEFTT33, timeLeftInMillisT33);
        outState.putBoolean(KEY_ANSWEREDT33, answeredT33);
        outState.putParcelableArrayList(KEY_QUESTION_LISTT33, questionListT33);
    }
}
