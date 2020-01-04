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

public class QuizC22 extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public static final String EXTRA_SCOREC22 = "extraScore";
    private static final long COUNTDOWN_IN_MILLISC22  = 20000;

    private static final String KEY_SCOREC22  = "keyScore";
    private static final String KEY_QUESTION_COUNTC22  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTC22  = "keyMillisLeft";
    private static final String KEY_ANSWEREDC22  = "keyAnswered";
    private static final String KEY_QUESTION_LISTC22  = "keyQuestionList";

    private TextView textViewQuestionC22 ;
    private TextView textViewScoreC22 ;
    private TextView textViewQuestionCountC22 ;
    private TextView textViewCountDownC22 ;
    private RadioGroup rbGroupC22 ;
    private RadioButton rb1C22 ;
    private RadioButton rb2C22 ;
    private RadioButton rb3C22 ;
    private Button buttonConfirmNextC22 ;

    private ColorStateList textColorDefaultRbC22 ;
    private ColorStateList textColorDefaultCdC22 ;

    private CountDownTimer countDownTimerC22 ;
    private long timeLeftInMillisC22 ;

    private ArrayList<QuestionsC22> questionListC22 ;
    private int questionCounterC22 ;
    private int questionCountTotalC22 ;
    private QuestionsC22 currentQuestionC22 ;

    private int scoreC22 ;
    private boolean answeredC22;

    private long backPressedTimeC22 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c22);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );

        textViewQuestionC22 = findViewById(R.id.text_view_questionC22);
        textViewQuestionC22.setTypeface( typeface );
        textViewScoreC22 = findViewById(R.id.text_view_scoreC22);
        textViewQuestionCountC22 = findViewById(R.id.text_view_question_countC22);
        textViewCountDownC22 = findViewById(R.id.text_view_countdownC22);
        rbGroupC22 = findViewById(R.id.radio_groupC22);
        rb1C22 = findViewById(R.id.radio_button1C22);
        rb1C22.setTypeface( typeface );
        rb2C22 = findViewById(R.id.radio_button2C22);
        rb2C22.setTypeface( typeface );
        rb3C22= findViewById(R.id.radio_button3C22);
        rb3C22.setTypeface( typeface );
        buttonConfirmNextC22 = findViewById(R.id.button_confirm_nextC22);

        textColorDefaultRbC22 = rb1C22.getTextColors();
        textColorDefaultCdC22 = textViewCountDownC22.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListC22 = dbHelper.getAllQuestionsC22();
            questionCountTotalC22 = questionListC22.size();
            Collections.shuffle(questionListC22);

            showNextQuestion();
        } else {
            questionListC22 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTC22);
            questionCountTotalC22 = questionListC22.size();
            questionCounterC22 = savedInstanceState.getInt(KEY_QUESTION_COUNTC22);
            currentQuestionC22 = questionListC22.get(questionCounterC22 - 1);
            scoreC22 = savedInstanceState.getInt(KEY_SCOREC22);
            timeLeftInMillisC22 = savedInstanceState.getLong(KEY_MILLIS_LEFTC22);
            answeredC22 = savedInstanceState.getBoolean(KEY_ANSWEREDC22);

            if (!answeredC22) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextC22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredC22) {
                    if (rb1C22.isChecked() || rb2C22.isChecked() || rb3C22.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizC22.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1C22.setTextColor(textColorDefaultRbC22);
        rb2C22.setTextColor(textColorDefaultRbC22);
        rb3C22.setTextColor(textColorDefaultRbC22);
        rbGroupC22.clearCheck();

        if (questionCounterC22 < questionCountTotalC22) {
            currentQuestionC22 = questionListC22.get(questionCounterC22);

            textViewQuestionC22.setText(currentQuestionC22.getQuestionC22());
            rb1C22.setText(currentQuestionC22.getOption1C22());
            rb2C22.setText(currentQuestionC22.getOption2C22());
            rb3C22.setText(currentQuestionC22.getOption3C22());

            questionCounterC22++;
            textViewQuestionCountC22.setText("Question: " + questionCounterC22 + "/" + questionCountTotalC22);
            answeredC22 = false;
            buttonConfirmNextC22.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisC22 = COUNTDOWN_IN_MILLISC22;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerC22 = new CountDownTimer(timeLeftInMillisC22, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisC22 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisC22 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisC22 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisC22 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownC22.setText(timeFormatted);

        if (timeLeftInMillisC22 < 10000) {
            textViewCountDownC22.setTextColor(Color.RED);
        } else {
            textViewCountDownC22.setTextColor(textColorDefaultCdC22);
        }
    }

    private void checkAnswer() {
        answeredC22 = true;

        countDownTimerC22.cancel();

        RadioButton rbSelected = findViewById(rbGroupC22.getCheckedRadioButtonId());
        int answerNr = rbGroupC22.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionC22.getAnswerNrC22()) {
            scoreC22++;
            textViewScoreC22.setText("Score: " + scoreC22);
        }

        showSolution();
    }

    private void showSolution() {
        rb1C22.setTextColor(Color.RED);
        rb2C22.setTextColor(Color.RED);
        rb3C22.setTextColor(Color.RED);

        switch (currentQuestionC22.getAnswerNrC22()) {
            case 1:
                rb1C22.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2C22.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3C22.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterC22 < questionCountTotalC22) {
            buttonConfirmNextC22.setText("التالي ");
        } else {
            buttonConfirmNextC22.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCOREC22, scoreC22);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizC22.this);
        alert.setMessage( " الدرجة  : "+scoreC22+"\nاعلي درجة  : "+QuizCatalog2.highscoreC22)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizC22.class);
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
        if (backPressedTimeC22 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeC22 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerC22 != null) {
            countDownTimerC22.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCOREC22, scoreC22);
        outState.putInt(KEY_QUESTION_COUNTC22, questionCounterC22);
        outState.putLong(KEY_MILLIS_LEFTC22, timeLeftInMillisC22);
        outState.putBoolean(KEY_ANSWEREDC22, answeredC22);
        outState.putParcelableArrayList(KEY_QUESTION_LISTC22, questionListC22);
    }
}
