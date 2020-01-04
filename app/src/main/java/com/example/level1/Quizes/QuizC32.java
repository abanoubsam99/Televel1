package com.example.level1.Quizes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
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

public class QuizC32 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    public static final String EXTRA_SCOREC32 = "extraScore";
    private static final long COUNTDOWN_IN_MILLISC32  = 20000;

    private static final String KEY_SCOREC32  = "keyScore";
    private static final String KEY_QUESTION_COUNTC32  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTC32  = "keyMillisLeft";
    private static final String KEY_ANSWEREDC32  = "keyAnswered";
    private static final String KEY_QUESTION_LISTC32  = "keyQuestionList";

    private TextView textViewQuestionC32 ;
    private TextView textViewScoreC32 ;
    private TextView textViewQuestionCountC32 ;
    private TextView textViewCountDownC32 ;
    private RadioGroup rbGroupC32 ;
    private RadioButton rb1C32 ;
    private RadioButton rb2C32 ;
    private RadioButton rb3C32 ;
    private Button buttonConfirmNextC32 ;

    private ColorStateList textColorDefaultRbC32 ;
    private ColorStateList textColorDefaultCdC32 ;

    private CountDownTimer countDownTimerC32 ;
    private long timeLeftInMillisC32 ;

    private ArrayList<QuestionsC32> questionLisC32 ;
    private int questionCounterC32 ;
    private int questionCountTotalC32 ;
    private QuestionsC32 currentQuestionC32 ;

    private int scoreC32 ;
    private boolean answeredC32;

    private long backPressedTimeC32 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c32);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );

        textViewQuestionC32 = findViewById(R.id.text_view_questionC32);
        textViewQuestionC32.setTypeface( typeface );
        textViewScoreC32 = findViewById(R.id.text_view_scoreC32);
        textViewQuestionCountC32 = findViewById(R.id.text_view_question_countC32);
        textViewCountDownC32 = findViewById(R.id.text_view_countdownC32);
        rbGroupC32 = findViewById(R.id.radio_groupC32);
        rb1C32 = findViewById(R.id.radio_button1C32);
        rb1C32.setTypeface( typeface );
        rb2C32 = findViewById(R.id.radio_button2C32);
        rb2C32.setTypeface( typeface );
        rb3C32= findViewById(R.id.radio_button3C32);
        rb3C32.setTypeface( typeface );
        buttonConfirmNextC32 = findViewById(R.id.button_confirm_nextC32);

        textColorDefaultRbC32 = rb1C32.getTextColors();
        textColorDefaultCdC32 = textViewCountDownC32.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionLisC32 = dbHelper.getAllQuestionsC32();
            questionCountTotalC32 = questionLisC32.size();
            Collections.shuffle(questionLisC32);

            showNextQuestion();
        } else {
            questionLisC32 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTC32);
            questionCountTotalC32 = questionLisC32.size();
            questionCounterC32 = savedInstanceState.getInt(KEY_QUESTION_COUNTC32);
            currentQuestionC32 = questionLisC32.get(questionCounterC32 - 1);
            scoreC32 = savedInstanceState.getInt(KEY_SCOREC32);
            timeLeftInMillisC32 = savedInstanceState.getLong(KEY_MILLIS_LEFTC32);
            answeredC32 = savedInstanceState.getBoolean(KEY_ANSWEREDC32);

            if (!answeredC32) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextC32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredC32) {
                    if (rb1C32.isChecked() || rb2C32.isChecked() || rb3C32.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizC32.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1C32.setTextColor(textColorDefaultRbC32);
        rb2C32.setTextColor(textColorDefaultRbC32);
        rb3C32.setTextColor(textColorDefaultRbC32);
        rbGroupC32.clearCheck();

        if (questionCounterC32 < questionCountTotalC32) {
            currentQuestionC32 = questionLisC32.get(questionCounterC32);

            textViewQuestionC32.setText(currentQuestionC32.getQuestionC32());
            rb1C32.setText(currentQuestionC32.getOption1C32());
            rb2C32.setText(currentQuestionC32.getOption2C32());
            rb3C32.setText(currentQuestionC32.getOption3C32());

            questionCounterC32++;
            textViewQuestionCountC32.setText("Question: " + questionCounterC32 + "/" + questionCountTotalC32);
            answeredC32 = false;
            buttonConfirmNextC32.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisC32 = COUNTDOWN_IN_MILLISC32;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerC32 = new CountDownTimer(timeLeftInMillisC32, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisC32 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisC32 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisC32 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisC32 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownC32.setText(timeFormatted);

        if (timeLeftInMillisC32 < 10000) {
            textViewCountDownC32.setTextColor(Color.RED);
        } else {
            textViewCountDownC32.setTextColor(textColorDefaultCdC32);
        }
    }

    private void checkAnswer() {
        answeredC32 = true;

        countDownTimerC32.cancel();

        RadioButton rbSelected = findViewById(rbGroupC32.getCheckedRadioButtonId());
        int answerNr = rbGroupC32.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionC32.getAnswerNrC32()) {
            scoreC32++;
            textViewScoreC32.setText("Score: " + scoreC32);
        }

        showSolution();
    }

    private void showSolution() {
        rb1C32.setTextColor(Color.RED);
        rb2C32.setTextColor(Color.RED);
        rb3C32.setTextColor(Color.RED);

        switch (currentQuestionC32.getAnswerNrC32()) {
            case 1:
                rb1C32.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2C32.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3C32.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterC32 < questionCountTotalC32) {
            buttonConfirmNextC32.setText("التالي ");
        } else {
            buttonConfirmNextC32.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCOREC32, scoreC32);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizC32.this);
        alert.setMessage( " الدرجة  : "+scoreC32+"\nاعلي درجة  : "+QuizCatalog3.highscoreC32)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizC32.class);
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
        if (backPressedTimeC32 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeC32 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerC32 != null) {
            countDownTimerC32.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCOREC32, scoreC32);
        outState.putInt(KEY_QUESTION_COUNTC32, questionCounterC32);
        outState.putLong(KEY_MILLIS_LEFTC32, timeLeftInMillisC32);
        outState.putBoolean(KEY_ANSWEREDC32, answeredC32);
        outState.putParcelableArrayList(KEY_QUESTION_LISTC32, questionLisC32);
    }
}
