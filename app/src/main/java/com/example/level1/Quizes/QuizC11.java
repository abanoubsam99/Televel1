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

public class QuizC11 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCOREC11 = "extraScore";
    private static final long COUNTDOWN_IN_MILLISC11  = 20000;

    private static final String KEY_SCOREC11  = "keyScore";
    private static final String KEY_QUESTION_COUNTC11  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTC11  = "keyMillisLeft";
    private static final String KEY_ANSWEREDC11  = "keyAnswered";
    private static final String KEY_QUESTION_LISTC11  = "keyQuestionList";

    private TextView textViewQuestionC11 ;
    private TextView textViewScoreC11 ;
    private TextView textViewQuestionCountC11 ;
    private TextView textViewCountDownC11 ;
    private RadioGroup rbGroupC11 ;
    private RadioButton rb1C11 ;
    private RadioButton rb2C11 ;
    private RadioButton rb3C11 ;
    private Button buttonConfirmNextC11 ;

    private ColorStateList textColorDefaultRbC11 ;
    private ColorStateList textColorDefaultCdC11 ;

    private CountDownTimer countDownTimerC11 ;
    private long timeLeftInMillisC11 ;

    private ArrayList<QuestionsC11> questionListC11 ;
    private int questionCounterC11 ;
    private int questionCountTotalC11 ;
    private QuestionsC11 currentQuestionC11 ;

    private int scoreC11 ;
    private boolean answeredC11 ;

    private long backPressedTimeC11 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c11);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textViewQuestionC11 = findViewById(R.id.text_view_questionC11);
        textViewQuestionC11.setTypeface( typeface );

        textViewScoreC11 = findViewById(R.id.text_view_scoreC11);
        textViewQuestionCountC11 = findViewById(R.id.text_view_question_countC11);
        textViewCountDownC11 = findViewById(R.id.text_view_countdownC11);
        rbGroupC11 = findViewById(R.id.radio_groupC11);
        rb1C11 = findViewById(R.id.radio_button1C11);
        rb1C11.setTypeface( typeface );
        rb2C11 = findViewById(R.id.radio_button2C11);
        rb2C11.setTypeface( typeface );
        rb3C11= findViewById(R.id.radio_button3C11);
        rb3C11.setTypeface( typeface );

        buttonConfirmNextC11 = findViewById(R.id.button_confirm_nextC11);

        textColorDefaultRbC11= rb1C11.getTextColors();
        textColorDefaultCdC11 = textViewCountDownC11.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListC11 = dbHelper.getAllQuestionsC11();
            questionCountTotalC11 = questionListC11.size();
            Collections.shuffle(questionListC11);

            showNextQuestion();
        } else {
            questionListC11 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTC11);
            questionCountTotalC11 = questionListC11.size();
            questionCounterC11 = savedInstanceState.getInt(KEY_QUESTION_COUNTC11);
            currentQuestionC11 = questionListC11.get(questionCounterC11 - 1);
            scoreC11 = savedInstanceState.getInt(KEY_SCOREC11);
            timeLeftInMillisC11 = savedInstanceState.getLong(KEY_MILLIS_LEFTC11);
            answeredC11 = savedInstanceState.getBoolean(KEY_ANSWEREDC11);

            if (!answeredC11) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextC11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredC11) {
                    if (rb1C11.isChecked() || rb2C11.isChecked() || rb3C11.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizC11.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1C11.setTextColor(textColorDefaultRbC11);
        rb2C11.setTextColor(textColorDefaultRbC11);
        rb3C11.setTextColor(textColorDefaultRbC11);
        rbGroupC11.clearCheck();

        if (questionCounterC11 < questionCountTotalC11) {
            currentQuestionC11 = questionListC11.get(questionCounterC11);

            textViewQuestionC11.setText(currentQuestionC11.getQuestionC11());
            rb1C11.setText(currentQuestionC11.getOption1C11());
            rb2C11.setText(currentQuestionC11.getOption2C11());
            rb3C11.setText(currentQuestionC11.getOption3C11());

            questionCounterC11++;
            textViewQuestionCountC11.setText("Question: " + questionCounterC11 + "/" + questionCountTotalC11);
            answeredC11= false;
            buttonConfirmNextC11.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisC11 = COUNTDOWN_IN_MILLISC11;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerC11 = new CountDownTimer(timeLeftInMillisC11, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisC11= millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisC11 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisC11 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisC11 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownC11.setText(timeFormatted);

        if (timeLeftInMillisC11 < 10000) {
            textViewCountDownC11.setTextColor(Color.RED);
        } else {
            textViewCountDownC11.setTextColor(textColorDefaultCdC11);
        }
    }

    private void checkAnswer() {
        answeredC11 = true;

        countDownTimerC11.cancel();

        RadioButton rbSelected = findViewById(rbGroupC11.getCheckedRadioButtonId());
        int answerNr = rbGroupC11.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionC11.getAnswerNrC11()) {
            scoreC11++;
            textViewScoreC11.setText("Score: " + scoreC11);
        }

        showSolution();
    }

    private void showSolution() {
        rb1C11.setTextColor(Color.RED);
        rb2C11.setTextColor(Color.RED);
        rb3C11.setTextColor(Color.RED);

        switch (currentQuestionC11.getAnswerNrC11()) {
            case 1:
                rb1C11.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2C11.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3C11.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterC11 < questionCountTotalC11) {
            buttonConfirmNextC11.setText("التالي ");
        } else {
            buttonConfirmNextC11.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCOREC11, scoreC11);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizC11.this);
        alert.setMessage( " الدرجة  : "+scoreC11+"\nاعلي درجة  : "+QuizCatalog1.highscoreC11)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizC11.class);
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
        if (backPressedTimeC11 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeC11 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerC11 != null) {
            countDownTimerC11.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCOREC11, scoreC11);
        outState.putInt(KEY_QUESTION_COUNTC11, questionCounterC11);
        outState.putLong(KEY_MILLIS_LEFTC11, timeLeftInMillisC11);
        outState.putBoolean(KEY_ANSWEREDC11, answeredC11);
        outState.putParcelableArrayList(KEY_QUESTION_LISTC11, questionListC11);
    }
}
