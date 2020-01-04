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

public class QuizC12 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCOREC12 = "extraScore";
    private static final long COUNTDOWN_IN_MILLISC12  = 20000;

    private static final String KEY_SCOREC12  = "keyScore";
    private static final String KEY_QUESTION_COUNTC12  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTC12  = "keyMillisLeft";
    private static final String KEY_ANSWEREDC12  = "keyAnswered";
    private static final String KEY_QUESTION_LISTC12  = "keyQuestionList";

    private TextView textViewQuestionC12 ;
    private TextView textViewScoreC12 ;
    private TextView textViewQuestionCountC12 ;
    private TextView textViewCountDownC12 ;
    private RadioGroup rbGroupC12 ;
    private RadioButton rb1C12 ;
    private RadioButton rb2C12 ;
    private RadioButton rb3C12 ;
    private Button buttonConfirmNextC12 ;

    private ColorStateList textColorDefaultRbC12 ;
    private ColorStateList textColorDefaultCdC12 ;

    private CountDownTimer countDownTimerC12 ;
    private long timeLeftInMillisC12 ;

    private ArrayList<QuestionsC12> questionListC12 ;
    private int questionCounterC12 ;
    private int questionCountTotalC12 ;
    private QuestionsC12 currentQuestionC12 ;

    private int scoreC12 ;
    private boolean answeredC12;

    private long backPressedTimeC12 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c12);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );


        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionC12 = findViewById(R.id.text_view_questionC12);
        textViewQuestionC12.setTypeface( typeface );

        textViewScoreC12 = findViewById(R.id.text_view_scoreC12);
        textViewQuestionCountC12 = findViewById(R.id.text_view_question_countC12);
        textViewCountDownC12 = findViewById(R.id.text_view_countdownC12);
        rbGroupC12 = findViewById(R.id.radio_groupC12);
        rb1C12 = findViewById(R.id.radio_button1C12);
        rb1C12.setTypeface( typeface );
        rb2C12 = findViewById(R.id.radio_button2C12);
        rb2C12.setTypeface( typeface );
        rb3C12= findViewById(R.id.radio_button3C12);
        rb3C12.setTypeface( typeface );
        buttonConfirmNextC12 = findViewById(R.id.button_confirm_nextC12);

        textColorDefaultRbC12 = rb1C12.getTextColors();
        textColorDefaultCdC12 = textViewCountDownC12.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListC12 = dbHelper.getAllQuestionsC12();
            questionCountTotalC12 = questionListC12.size();
            Collections.shuffle(questionListC12);

            showNextQuestion();
        } else {
            questionListC12 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTC12);
            questionCountTotalC12 = questionListC12.size();
            questionCounterC12 = savedInstanceState.getInt(KEY_QUESTION_COUNTC12);
            currentQuestionC12 = questionListC12.get(questionCounterC12 - 1);
            scoreC12 = savedInstanceState.getInt(KEY_SCOREC12);
            timeLeftInMillisC12 = savedInstanceState.getLong(KEY_MILLIS_LEFTC12);
            answeredC12 = savedInstanceState.getBoolean(KEY_ANSWEREDC12);

            if (!answeredC12) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextC12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredC12) {
                    if (rb1C12.isChecked() || rb2C12.isChecked() || rb3C12.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizC12.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1C12.setTextColor(textColorDefaultRbC12);
        rb2C12.setTextColor(textColorDefaultRbC12);
        rb3C12.setTextColor(textColorDefaultRbC12);
        rbGroupC12.clearCheck();

        if (questionCounterC12 < questionCountTotalC12) {
            currentQuestionC12 = questionListC12.get(questionCounterC12);

            textViewQuestionC12.setText(currentQuestionC12.getQuestionC12());
            rb1C12.setText(currentQuestionC12.getOption1C12());
            rb2C12.setText(currentQuestionC12.getOption2C12());
            rb3C12.setText(currentQuestionC12.getOption3C12());

            questionCounterC12++;
            textViewQuestionCountC12.setText("Question: " + questionCounterC12 + "/" + questionCountTotalC12);
            answeredC12 = false;
            buttonConfirmNextC12.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisC12 = COUNTDOWN_IN_MILLISC12;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerC12 = new CountDownTimer(timeLeftInMillisC12, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisC12 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisC12 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisC12 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisC12 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownC12.setText(timeFormatted);

        if (timeLeftInMillisC12 < 10000) {
            textViewCountDownC12.setTextColor(Color.RED);
        } else {
            textViewCountDownC12.setTextColor(textColorDefaultCdC12);
        }
    }

    private void checkAnswer() {
        answeredC12 = true;

        countDownTimerC12.cancel();

        RadioButton rbSelected = findViewById(rbGroupC12.getCheckedRadioButtonId());
        int answerNr = rbGroupC12.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionC12.getAnswerNrC12()) {
            scoreC12++;
            textViewScoreC12.setText("Score: " + scoreC12);
        }

        showSolution();
    }

    private void showSolution() {
        rb1C12.setTextColor(Color.RED);
        rb2C12.setTextColor(Color.RED);
        rb3C12.setTextColor(Color.RED);

        switch (currentQuestionC12.getAnswerNrC12()) {
            case 1:
                rb1C12.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2C12.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3C12.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterC12 < questionCountTotalC12) {
            buttonConfirmNextC12.setText("التالي ");
        } else {
            buttonConfirmNextC12.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCOREC12, scoreC12);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizC12.this);
        alert.setMessage( " الدرجة  : "+scoreC12+"\nاعلي درجة  : "+QuizCatalog1.highscoreC12)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizC12.class);
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
        if (backPressedTimeC12 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeC12 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerC12 != null) {
            countDownTimerC12.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCOREC12, scoreC12);
        outState.putInt(KEY_QUESTION_COUNTC12, questionCounterC12);
        outState.putLong(KEY_MILLIS_LEFTC12, timeLeftInMillisC12);
        outState.putBoolean(KEY_ANSWEREDC12, answeredC12);
        outState.putParcelableArrayList(KEY_QUESTION_LISTC12, questionListC12);
    }
}
