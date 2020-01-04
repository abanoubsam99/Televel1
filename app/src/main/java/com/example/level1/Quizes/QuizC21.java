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

public class QuizC21 extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    public static final String EXTRA_SCOREC21 = "extraScore";
    private static final long COUNTDOWN_IN_MILLISC21  = 20000;

    private static final String KEY_SCOREC21  = "keyScore";
    private static final String KEY_QUESTION_COUNTC21  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTC21  = "keyMillisLeft";
    private static final String KEY_ANSWEREDC21  = "keyAnswered";
    private static final String KEY_QUESTION_LISTC21  = "keyQuestionList";

    private TextView textViewQuestionC21 ;
    private TextView textViewScoreC21 ;
    private TextView textViewQuestionCountC21 ;
    private TextView textViewCountDownC21 ;
    private RadioGroup rbGroupC21 ;
    private RadioButton rb1C21 ;
    private RadioButton rb2C21 ;
    private RadioButton rb3C21 ;
    private Button buttonConfirmNextC21 ;

    private ColorStateList textColorDefaultRbC21 ;
    private ColorStateList textColorDefaultCdC21 ;

    private CountDownTimer countDownTimerC21 ;
    private long timeLeftInMillisC21 ;

    private ArrayList<QuestionsC21> questionListC21 ;
    private int questionCounterC21 ;
    private int questionCountTotalC21 ;
    private QuestionsC21 currentQuestionC21 ;

    private int scoreC21 ;
    private boolean answeredC21 ;

    private long backPressedTimeC21 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c21);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );

        textViewQuestionC21 = findViewById(R.id.text_view_questionC21);
        textViewQuestionC21.setTypeface( typeface );
        textViewScoreC21 = findViewById(R.id.text_view_scoreC21);
        textViewQuestionCountC21 = findViewById(R.id.text_view_question_countC21);
        textViewCountDownC21 = findViewById(R.id.text_view_countdownC21);
        rbGroupC21 = findViewById(R.id.radio_groupC21);
        rb1C21 = findViewById(R.id.radio_button1C21);
        rb1C21.setTypeface( typeface );
        rb2C21 = findViewById(R.id.radio_button2C21);
        rb2C21.setTypeface( typeface );
        rb3C21= findViewById(R.id.radio_button3C21);
        rb3C21.setTypeface( typeface );
        buttonConfirmNextC21 = findViewById(R.id.button_confirm_nextC21);

        textColorDefaultRbC21= rb1C21.getTextColors();
        textColorDefaultCdC21 = textViewCountDownC21.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListC21 = dbHelper.getAllQuestionsC21();
            questionCountTotalC21 = questionListC21.size();
            Collections.shuffle(questionListC21);

            showNextQuestion();
        } else {
            questionListC21 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTC21);
            questionCountTotalC21 = questionListC21.size();
            questionCounterC21 = savedInstanceState.getInt(KEY_QUESTION_COUNTC21);
            currentQuestionC21 = questionListC21.get(questionCounterC21 - 1);
            scoreC21 = savedInstanceState.getInt(KEY_SCOREC21);
            timeLeftInMillisC21 = savedInstanceState.getLong(KEY_MILLIS_LEFTC21);
            answeredC21 = savedInstanceState.getBoolean(KEY_ANSWEREDC21);

            if (!answeredC21) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextC21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredC21) {
                    if (rb1C21.isChecked() || rb2C21.isChecked() || rb3C21.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizC21.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1C21.setTextColor(textColorDefaultRbC21);
        rb2C21.setTextColor(textColorDefaultRbC21);
        rb3C21.setTextColor(textColorDefaultRbC21);
        rbGroupC21.clearCheck();

        if (questionCounterC21 < questionCountTotalC21) {
            currentQuestionC21 = questionListC21.get(questionCounterC21);

            textViewQuestionC21.setText(currentQuestionC21.getQuestionC21());
            rb1C21.setText(currentQuestionC21.getOption1C21());
            rb2C21.setText(currentQuestionC21.getOption2C21());
            rb3C21.setText(currentQuestionC21.getOption3C21());

            questionCounterC21++;
            textViewQuestionCountC21.setText("Question: " + questionCounterC21 + "/" + questionCountTotalC21);
            answeredC21= false;
            buttonConfirmNextC21.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisC21 = COUNTDOWN_IN_MILLISC21;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerC21 = new CountDownTimer(timeLeftInMillisC21, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisC21= millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisC21 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisC21 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisC21 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownC21.setText(timeFormatted);

        if (timeLeftInMillisC21 < 10000) {
            textViewCountDownC21.setTextColor(Color.RED);
        } else {
            textViewCountDownC21.setTextColor(textColorDefaultCdC21);
        }
    }

    private void checkAnswer() {
        answeredC21 = true;

        countDownTimerC21.cancel();

        RadioButton rbSelected = findViewById(rbGroupC21.getCheckedRadioButtonId());
        int answerNr = rbGroupC21.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionC21.getAnswerNrC21()) {
            scoreC21++;
            textViewScoreC21.setText("Score: " + scoreC21);
        }

        showSolution();
    }

    private void showSolution() {
        rb1C21.setTextColor(Color.RED);
        rb2C21.setTextColor(Color.RED);
        rb3C21.setTextColor(Color.RED);

        switch (currentQuestionC21.getAnswerNrC21()) {
            case 1:
                rb1C21.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2C21.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3C21.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterC21 < questionCountTotalC21) {
            buttonConfirmNextC21.setText("التالي ");
        } else {
            buttonConfirmNextC21.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCOREC21, scoreC21);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizC21.this);
        alert.setMessage( " الدرجة  : "+scoreC21+"\nاعلي درجة  : "+QuizCatalog2.highscoreC21)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizC21.class);
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
        if (backPressedTimeC21 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeC21 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerC21 != null) {
            countDownTimerC21.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCOREC21, scoreC21);
        outState.putInt(KEY_QUESTION_COUNTC21, questionCounterC21);
        outState.putLong(KEY_MILLIS_LEFTC21, timeLeftInMillisC21);
        outState.putBoolean(KEY_ANSWEREDC21, answeredC21);
        outState.putParcelableArrayList(KEY_QUESTION_LISTC21, questionListC21);
    }
}
