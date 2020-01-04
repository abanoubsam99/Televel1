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

public class QuizT11 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    public static final String EXTRA_SCORET11 = "extraScore";
    private static final long COUNTDOWN_IN_MILLIST11  = 20000;

    private static final String KEY_SCORET11  = "keyScore";
    private static final String KEY_QUESTION_COUNTT11  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTT11  = "keyMillisLeft";
    private static final String KEY_ANSWEREDT11  = "keyAnswered";
    private static final String KEY_QUESTION_LISTT11  = "keyQuestionList";

    private TextView textViewQuestionT11 ;
    private TextView textViewScoreT11 ;
    private TextView textViewQuestionCountT11 ;
    private TextView textViewCountDownT11 ;
    private RadioGroup rbGroupT11 ;
    private RadioButton rb1T11 ;
    private RadioButton rb2T11 ;
    private RadioButton rb3T11 ;
    private Button buttonConfirmNextT11 ;

    private ColorStateList textColorDefaultRbT11 ;
    private ColorStateList textColorDefaultCdT11 ;

    private CountDownTimer countDownTimerT11 ;
    private long timeLeftInMillisT11 ;

    private ArrayList<QuestionsT11> questionListT11 ;
    private int questionCounterT11 ;
    private int questionCountTotalT11 ;
    private QuestionsT11 currentQuestionT11 ;

    private int scoreT11 ;
    private boolean answeredT11 ;

    private long backPressedTimeT11 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_t11);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionT11 = findViewById(R.id.text_view_questionT11);
        textViewScoreT11 = findViewById(R.id.text_view_scoreT11);
        textViewQuestionCountT11 = findViewById(R.id.text_view_question_countT11);
        textViewCountDownT11 = findViewById(R.id.text_view_countdownT11);
        rbGroupT11 = findViewById(R.id.radio_groupT11);
        rb1T11 = findViewById(R.id.radio_button1T11);
        rb2T11 = findViewById(R.id.radio_button2T11);
        rb3T11= findViewById(R.id.radio_button3T11);
        buttonConfirmNextT11 = findViewById(R.id.button_confirm_nextT11);

        textColorDefaultRbT11= rb1T11.getTextColors();
        textColorDefaultCdT11 = textViewCountDownT11.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListT11 = dbHelper.getAllQuestionsT11();
            questionCountTotalT11 = questionListT11.size();
            Collections.shuffle(questionListT11);

            showNextQuestion();
        } else {
            questionListT11 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTT11);
            questionCountTotalT11 = questionListT11.size();
            questionCounterT11 = savedInstanceState.getInt(KEY_QUESTION_COUNTT11);
            currentQuestionT11 = questionListT11.get(questionCounterT11 - 1);
            scoreT11 = savedInstanceState.getInt(KEY_SCORET11);
            timeLeftInMillisT11 = savedInstanceState.getLong(KEY_MILLIS_LEFTT11);
            answeredT11 = savedInstanceState.getBoolean(KEY_ANSWEREDT11);

            if (!answeredT11) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextT11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredT11) {
                    if (rb1T11.isChecked() || rb2T11.isChecked() || rb3T11.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizT11.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1T11.setTextColor(textColorDefaultRbT11);
        rb2T11.setTextColor(textColorDefaultRbT11);
        rb3T11.setTextColor(textColorDefaultRbT11);
        rbGroupT11.clearCheck();

        if (questionCounterT11 < questionCountTotalT11) {
            currentQuestionT11 = questionListT11.get(questionCounterT11);

            textViewQuestionT11.setText(currentQuestionT11.getQuestionT11());
            rb1T11.setText(currentQuestionT11.getOption1T11());
            rb2T11.setText(currentQuestionT11.getOption2T11());
            rb3T11.setText(currentQuestionT11.getOption3T11());

            questionCounterT11++;
            textViewQuestionCountT11.setText("Question: " + questionCounterT11 + "/" + questionCountTotalT11);
            answeredT11= false;
            buttonConfirmNextT11.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisT11 = COUNTDOWN_IN_MILLIST11;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerT11 = new CountDownTimer(timeLeftInMillisT11, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisT11= millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisT11 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisT11 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisT11 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownT11.setText(timeFormatted);

        if (timeLeftInMillisT11 < 10000) {
            textViewCountDownT11.setTextColor(Color.RED);
        } else {
            textViewCountDownT11.setTextColor(textColorDefaultCdT11);
        }
    }

    private void checkAnswer() {
        answeredT11 = true;

        countDownTimerT11.cancel();

        RadioButton rbSelected = findViewById(rbGroupT11.getCheckedRadioButtonId());
        int answerNr = rbGroupT11.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionT11.getAnswerNrT11()) {
            scoreT11++;
            textViewScoreT11.setText("Score: " + scoreT11);
        }

        showSolution();
    }

    private void showSolution() {
        rb1T11.setTextColor(Color.RED);
        rb2T11.setTextColor(Color.RED);
        rb3T11.setTextColor(Color.RED);

        switch (currentQuestionT11.getAnswerNrT11()) {
            case 1:
                rb1T11.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2T11.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3T11.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterT11 < questionCountTotalT11) {
            buttonConfirmNextT11.setText("التالي ");
        } else {
            buttonConfirmNextT11.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORET11, scoreT11);
        setResult(RESULT_OK, resultIntent);

            AlertDialog.Builder alert=new AlertDialog.Builder(QuizT11.this);
            alert.setMessage( " الدرجة  : "+scoreT11+"\nاعلي درجة  : "+QuizCatalog1.highscoreT11)
                    .setCancelable(false)
                    .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(getApplicationContext(),QuizT11.class);
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
        if (backPressedTimeT11 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeT11 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerT11 != null) {
            countDownTimerT11.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORET11, scoreT11);
        outState.putInt(KEY_QUESTION_COUNTT11, questionCounterT11);
        outState.putLong(KEY_MILLIS_LEFTT11, timeLeftInMillisT11);
        outState.putBoolean(KEY_ANSWEREDT11, answeredT11);
        outState.putParcelableArrayList(KEY_QUESTION_LISTT11, questionListT11);
    }
}
