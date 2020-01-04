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

public class QuizC13 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    public static final String EXTRA_SCOREC13 = "extraScore";
    private static final long COUNTDOWN_IN_MILLISC13  = 20000;

    private static final String KEY_SCOREC13  = "keyScore";
    private static final String KEY_QUESTION_COUNTC13  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTC13  = "keyMillisLeft";
    private static final String KEY_ANSWEREDC13  = "keyAnswered";
    private static final String KEY_QUESTION_LISTC13  = "keyQuestionList";

    private TextView textViewQuestionC13 ;
    private TextView textViewScoreC13 ;
    private TextView textViewQuestionCountC13 ;
    private TextView textViewCountDownC13 ;
    private RadioGroup rbGroupC13 ;
    private RadioButton rb1C13 ;
    private RadioButton rb2C13 ;
    private RadioButton rb3C13 ;
    private Button buttonConfirmNextC13 ;

    private ColorStateList textColorDefaultRbC13;
    private ColorStateList textColorDefaultCdC13 ;

    private CountDownTimer countDownTimerC13 ;
    private long timeLeftInMillisC13 ;

    private ArrayList<QuestionsC13> questionListC13 ;
    private int questionCounterC13 ;
    private int questionCountTotalC13 ;
    private QuestionsC13 currentQuestionC13 ;

    private int scoreC13 ;
    private boolean answeredC13 ;

    private long backPressedTimeC13 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c13);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );

        textViewQuestionC13 = findViewById(R.id.text_view_questionC13);
        textViewQuestionC13.setTypeface( typeface );
        textViewScoreC13 = findViewById(R.id.text_view_scoreC13);
        textViewQuestionCountC13 = findViewById(R.id.text_view_question_countC13);
        textViewCountDownC13 = findViewById(R.id.text_view_countdownC13);
        rbGroupC13 = findViewById(R.id.radio_groupC13);
        rb1C13= findViewById(R.id.radio_button1C13);
        rb1C13.setTypeface( typeface );
        rb2C13 = findViewById(R.id.radio_button2C13);
        rb2C13.setTypeface( typeface );
        rb3C13= findViewById(R.id.radio_button3C13);
        rb3C13.setTypeface( typeface );
        buttonConfirmNextC13= findViewById(R.id.button_confirm_nextC13);

        textColorDefaultRbC13 = rb1C13.getTextColors();
        textColorDefaultCdC13= textViewCountDownC13.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListC13 = dbHelper.getAllQuestionsC13();
            questionCountTotalC13 = questionListC13.size();
            Collections.shuffle(questionListC13);

            showNextQuestion();
        } else {
            questionListC13 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTC13);
            questionCountTotalC13 = questionListC13.size();
            questionCounterC13 = savedInstanceState.getInt(KEY_QUESTION_COUNTC13);
            currentQuestionC13 = questionListC13.get(questionCounterC13 - 1);
            scoreC13 = savedInstanceState.getInt(KEY_SCOREC13);
            timeLeftInMillisC13 = savedInstanceState.getLong(KEY_MILLIS_LEFTC13);
            answeredC13 = savedInstanceState.getBoolean(KEY_ANSWEREDC13);

            if (!answeredC13) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextC13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredC13) {
                    if (rb1C13.isChecked() || rb2C13.isChecked() || rb3C13.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizC13.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1C13.setTextColor(textColorDefaultRbC13);
        rb2C13.setTextColor(textColorDefaultRbC13);
        rb3C13.setTextColor(textColorDefaultRbC13);
        rbGroupC13.clearCheck();

        if (questionCounterC13 < questionCountTotalC13) {
            currentQuestionC13 = questionListC13.get(questionCounterC13);

            textViewQuestionC13.setText(currentQuestionC13.getQuestionC13());
            rb1C13.setText(currentQuestionC13.getOption1C13());
            rb2C13.setText(currentQuestionC13.getOption2C13());
            rb3C13.setText(currentQuestionC13.getOption3C13());

            questionCounterC13++;
            textViewQuestionCountC13.setText("Question: " + questionCounterC13 + "/" + questionCountTotalC13);
            answeredC13 = false;
            buttonConfirmNextC13.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisC13 = COUNTDOWN_IN_MILLISC13;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerC13 = new CountDownTimer(timeLeftInMillisC13, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisC13 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisC13 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisC13 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisC13 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownC13.setText(timeFormatted);

        if (timeLeftInMillisC13 < 10000) {
            textViewCountDownC13.setTextColor(Color.RED);
        } else {
            textViewCountDownC13.setTextColor(textColorDefaultCdC13);
        }
    }

    private void checkAnswer() {
        answeredC13 = true;

        countDownTimerC13.cancel();

        RadioButton rbSelected = findViewById(rbGroupC13.getCheckedRadioButtonId());
        int answerNr = rbGroupC13.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionC13.getAnswerNrC13()) {
            scoreC13++;
            textViewScoreC13.setText("Score: " + scoreC13);
        }

        showSolution();
    }

    private void showSolution() {
        rb1C13.setTextColor(Color.RED);
        rb2C13.setTextColor(Color.RED);
        rb3C13.setTextColor(Color.RED);

        switch (currentQuestionC13.getAnswerNrC13()) {
            case 1:
                rb1C13.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2C13.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3C13.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterC13 < questionCountTotalC13) {
            buttonConfirmNextC13.setText("التالي ");
        } else {
            buttonConfirmNextC13.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCOREC13, scoreC13);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizC13.this);
        alert.setMessage( " الدرجة  : "+scoreC13+"\nاعلي درجة  : "+QuizCatalog1.highscoreC13)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizC13.class);
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
        if (backPressedTimeC13 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeC13 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerC13 != null) {
            countDownTimerC13.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCOREC13, scoreC13);
        outState.putInt(KEY_QUESTION_COUNTC13, questionCounterC13);
        outState.putLong(KEY_MILLIS_LEFTC13, timeLeftInMillisC13);
        outState.putBoolean(KEY_ANSWEREDC13, answeredC13);
        outState.putParcelableArrayList(KEY_QUESTION_LISTC13, questionListC13);
    }
}
