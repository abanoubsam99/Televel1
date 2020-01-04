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

public class QuizC23 extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCOREC23 = "extraScore";
    private static final long COUNTDOWN_IN_MILLISC23  = 20000;

    private static final String KEY_SCOREC23  = "keyScore";
    private static final String KEY_QUESTION_COUNTC23  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTC23  = "keyMillisLeft";
    private static final String KEY_ANSWEREDC23  = "keyAnswered";
    private static final String KEY_QUESTION_LISTC23  = "keyQuestionList";

    private TextView textViewQuestionC23 ;
    private TextView textViewScoreC23 ;
    private TextView textViewQuestionCountC23 ;
    private TextView textViewCountDownC23 ;
    private RadioGroup rbGroupC23 ;
    private RadioButton rb1C23 ;
    private RadioButton rb2C23 ;
    private RadioButton rb3C23 ;
    private Button buttonConfirmNextC23 ;

    private ColorStateList textColorDefaultRbC23;
    private ColorStateList textColorDefaultCdC23 ;

    private CountDownTimer countDownTimerC23 ;
    private long timeLeftInMillisC23 ;

    private ArrayList<QuestionsC23> questionListC23 ;
    private int questionCounterC23 ;
    private int questionCountTotalC23 ;
    private QuestionsC23 currentQuestionC23 ;

    private int scoreC23 ;
    private boolean answeredC23 ;

    private long backPressedTimeC23 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c23);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );

        textViewQuestionC23 = findViewById(R.id.text_view_questionC23);
        textViewQuestionC23.setTypeface( typeface );
        textViewScoreC23 = findViewById(R.id.text_view_scoreC23);
        textViewQuestionCountC23 = findViewById(R.id.text_view_question_countC23);
        textViewCountDownC23 = findViewById(R.id.text_view_countdownC23);
        rbGroupC23 = findViewById(R.id.radio_groupC23);
        rb1C23= findViewById(R.id.radio_button1C23);
        rb1C23.setTypeface( typeface );
        rb2C23 = findViewById(R.id.radio_button2C23);
        rb2C23.setTypeface( typeface );
        rb3C23= findViewById(R.id.radio_button3C23);
        rb3C23.setTypeface( typeface );
        buttonConfirmNextC23= findViewById(R.id.button_confirm_nextC23);

        textColorDefaultRbC23 = rb1C23.getTextColors();
        textColorDefaultCdC23= textViewCountDownC23.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListC23 = dbHelper.getAllQuestionsC23();
            questionCountTotalC23 = questionListC23.size();
            Collections.shuffle(questionListC23);

            showNextQuestion();
        } else {
            questionListC23 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTC23);
            questionCountTotalC23 = questionListC23.size();
            questionCounterC23 = savedInstanceState.getInt(KEY_QUESTION_COUNTC23);
            currentQuestionC23 = questionListC23.get(questionCounterC23 - 1);
            scoreC23 = savedInstanceState.getInt(KEY_SCOREC23);
            timeLeftInMillisC23 = savedInstanceState.getLong(KEY_MILLIS_LEFTC23);
            answeredC23 = savedInstanceState.getBoolean(KEY_ANSWEREDC23);

            if (!answeredC23) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextC23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredC23) {
                    if (rb1C23.isChecked() || rb2C23.isChecked() || rb3C23.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizC23.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1C23.setTextColor(textColorDefaultRbC23);
        rb2C23.setTextColor(textColorDefaultRbC23);
        rb3C23.setTextColor(textColorDefaultRbC23);
        rbGroupC23.clearCheck();

        if (questionCounterC23 < questionCountTotalC23) {
            currentQuestionC23 = questionListC23.get(questionCounterC23);

            textViewQuestionC23.setText(currentQuestionC23.getQuestionC23());
            rb1C23.setText(currentQuestionC23.getOption1C23());
            rb2C23.setText(currentQuestionC23.getOption2C23());
            rb3C23.setText(currentQuestionC23.getOption3C23());

            questionCounterC23++;
            textViewQuestionCountC23.setText("Question: " + questionCounterC23 + "/" + questionCountTotalC23);
            answeredC23 = false;
            buttonConfirmNextC23.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisC23 = COUNTDOWN_IN_MILLISC23;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerC23 = new CountDownTimer(timeLeftInMillisC23, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisC23 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisC23 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisC23 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisC23 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownC23.setText(timeFormatted);

        if (timeLeftInMillisC23 < 10000) {
            textViewCountDownC23.setTextColor(Color.RED);
        } else {
            textViewCountDownC23.setTextColor(textColorDefaultCdC23);
        }
    }

    private void checkAnswer() {
        answeredC23 = true;

        countDownTimerC23.cancel();

        RadioButton rbSelected = findViewById(rbGroupC23.getCheckedRadioButtonId());
        int answerNr = rbGroupC23.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionC23.getAnswerNrC23()) {
            scoreC23++;
            textViewScoreC23.setText("Score: " + scoreC23);
        }

        showSolution();
    }

    private void showSolution() {
        rb1C23.setTextColor(Color.RED);
        rb2C23.setTextColor(Color.RED);
        rb3C23.setTextColor(Color.RED);

        switch (currentQuestionC23.getAnswerNrC23()) {
            case 1:
                rb1C23.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2C23.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3C23.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterC23 < questionCountTotalC23) {
            buttonConfirmNextC23.setText("التالي ");
        } else {
            buttonConfirmNextC23.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCOREC23, scoreC23);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizC23.this);
        alert.setMessage( " الدرجة  : "+scoreC23+"\nاعلي درجة  : "+QuizCatalog2.highscoreC23)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizC23.class);
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
        if (backPressedTimeC23 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeC23 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerC23 != null) {
            countDownTimerC23.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCOREC23, scoreC23);
        outState.putInt(KEY_QUESTION_COUNTC23, questionCounterC23);
        outState.putLong(KEY_MILLIS_LEFTC23, timeLeftInMillisC23);
        outState.putBoolean(KEY_ANSWEREDC23, answeredC23);
        outState.putParcelableArrayList(KEY_QUESTION_LISTC23, questionListC23);
    }
}

