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

public class QuizC31 extends AppCompatActivity {
    private AdView mAdView;

    private InterstitialAd mInterstitialAd;


    public static final String EXTRA_SCOREC31 = "extraScore";
    private static final long COUNTDOWN_IN_MILLISC31  = 20000;

    private static final String KEY_SCOREC31  = "keyScore";
    private static final String KEY_QUESTION_COUNTC31  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTC31  = "keyMillisLeft";
    private static final String KEY_ANSWEREDC31  = "keyAnswered";
    private static final String KEY_QUESTION_LISTC31  = "keyQuestionList";

    private TextView textViewQuestionC31 ;
    private TextView textViewScoreC31 ;
    private TextView textViewQuestionCountC31 ;
    private TextView textViewCountDownC31 ;
    private RadioGroup rbGroupC31 ;
    private RadioButton rb1C31 ;
    private RadioButton rb2C31 ;
    private RadioButton rb3C31 ;
    private Button buttonConfirmNextC31 ;

    private ColorStateList textColorDefaultRbC31 ;
    private ColorStateList textColorDefaultCdC31 ;

    private CountDownTimer countDownTimerC31 ;
    private long timeLeftInMillisC31 ;

    private ArrayList<QuestionsC31> questionListC31 ;
    private int questionCounterC31 ;
    private int questionCountTotalC31 ;
    private QuestionsC31 currentQuestionC31 ;

    private int scoreC31 ;
    private boolean answeredC31 ;

    private long backPressedTimeC31 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c31);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );

        textViewQuestionC31 = findViewById(R.id.text_view_questionC31);
        textViewQuestionC31.setTypeface( typeface );
        textViewScoreC31 = findViewById(R.id.text_view_scoreC31);
        textViewQuestionCountC31 = findViewById(R.id.text_view_question_countC31);
        textViewCountDownC31 = findViewById(R.id.text_view_countdownC31);
        rbGroupC31 = findViewById(R.id.radio_groupC31);
        rb1C31 = findViewById(R.id.radio_button1C31);
        rb1C31.setTypeface( typeface );
        rb2C31 = findViewById(R.id.radio_button2C31);
        rb2C31.setTypeface( typeface );
        rb3C31= findViewById(R.id.radio_button3C31);
        rb3C31.setTypeface( typeface );
        buttonConfirmNextC31 = findViewById(R.id.button_confirm_nextC31);

        textColorDefaultRbC31= rb1C31.getTextColors();
        textColorDefaultCdC31 = textViewCountDownC31.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListC31 = dbHelper.getAllQuestionsC31();
            questionCountTotalC31 = questionListC31.size();
            Collections.shuffle(questionListC31);

            showNextQuestion();
        } else {
            questionListC31 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTC31);
            questionCountTotalC31 = questionListC31.size();
            questionCounterC31 = savedInstanceState.getInt(KEY_QUESTION_COUNTC31);
            currentQuestionC31 = questionListC31.get(questionCounterC31 - 1);
            scoreC31 = savedInstanceState.getInt(KEY_SCOREC31);
            timeLeftInMillisC31 = savedInstanceState.getLong(KEY_MILLIS_LEFTC31);
            answeredC31 = savedInstanceState.getBoolean(KEY_ANSWEREDC31);

            if (!answeredC31) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextC31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredC31) {
                    if (rb1C31.isChecked() || rb2C31.isChecked() || rb3C31.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizC31.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1C31.setTextColor(textColorDefaultRbC31);
        rb2C31.setTextColor(textColorDefaultRbC31);
        rb3C31.setTextColor(textColorDefaultRbC31);
        rbGroupC31.clearCheck();

        if (questionCounterC31 < questionCountTotalC31) {
            currentQuestionC31 = questionListC31.get(questionCounterC31);

            textViewQuestionC31.setText(currentQuestionC31.getQuestionC31());
            rb1C31.setText(currentQuestionC31.getOption1C31());
            rb2C31.setText(currentQuestionC31.getOption2C31());
            rb3C31.setText(currentQuestionC31.getOption3C31());

            questionCounterC31++;
            textViewQuestionCountC31.setText("Question: " + questionCounterC31 + "/" + questionCountTotalC31);
            answeredC31= false;
            buttonConfirmNextC31.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisC31 = COUNTDOWN_IN_MILLISC31;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerC31 = new CountDownTimer(timeLeftInMillisC31, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisC31= millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisC31 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisC31 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisC31 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownC31.setText(timeFormatted);

        if (timeLeftInMillisC31 < 10000) {
            textViewCountDownC31.setTextColor(Color.RED);
        } else {
            textViewCountDownC31.setTextColor(textColorDefaultCdC31);
        }
    }

    private void checkAnswer() {
        answeredC31 = true;

        countDownTimerC31.cancel();

        RadioButton rbSelected = findViewById(rbGroupC31.getCheckedRadioButtonId());
        int answerNr = rbGroupC31.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionC31.getAnswerNrC31()) {
            scoreC31++;
            textViewScoreC31.setText("Score: " + scoreC31);
        }

        showSolution();
    }

    private void showSolution() {
        rb1C31.setTextColor(Color.RED);
        rb2C31.setTextColor(Color.RED);
        rb3C31.setTextColor(Color.RED);

        switch (currentQuestionC31.getAnswerNrC31()) {
            case 1:
                rb1C31.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2C31.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3C31.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterC31 < questionCountTotalC31) {
            buttonConfirmNextC31.setText("التالي ");
        } else {
            buttonConfirmNextC31.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCOREC31, scoreC31);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizC31.this);
        alert.setMessage( " الدرجة  : "+scoreC31+"\nاعلي درجة  : "+QuizCatalog3.highscoreC31)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizC31.class);
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
        if (backPressedTimeC31 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeC31 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerC31 != null) {
            countDownTimerC31.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCOREC31, scoreC31);
        outState.putInt(KEY_QUESTION_COUNTC31, questionCounterC31);
        outState.putLong(KEY_MILLIS_LEFTC31, timeLeftInMillisC31);
        outState.putBoolean(KEY_ANSWEREDC31, answeredC31);
        outState.putParcelableArrayList(KEY_QUESTION_LISTC31, questionListC31);
    }
}
