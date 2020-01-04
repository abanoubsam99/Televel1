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

public class QuizC33 extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    public static final String EXTRA_SCOREC33 = "extraScore";
    private static final long COUNTDOWN_IN_MILLISC33  = 20000;

    private static final String KEY_SCOREC33  = "keyScore";
    private static final String KEY_QUESTION_COUNTC33  = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFTC33  = "keyMillisLeft";
    private static final String KEY_ANSWEREDC33  = "keyAnswered";
    private static final String KEY_QUESTION_LISTC33  = "keyQuestionList";

    private TextView textViewQuestionC33 ;
    private TextView textViewScoreC33 ;
    private TextView textViewQuestionCountC33 ;
    private TextView textViewCountDownC33 ;
    private RadioGroup rbGroupC33 ;
    private RadioButton rb1C33 ;
    private RadioButton rb2C33 ;
    private RadioButton rb3C33 ;
    private Button buttonConfirmNextC33 ;

    private ColorStateList textColorDefaultRbC33;
    private ColorStateList textColorDefaultCdC33 ;

    private CountDownTimer countDownTimerC33 ;
    private long timeLeftInMillisC33 ;

    private ArrayList<QuestionsC33> questionListC33 ;
    private int questionCounterC33 ;
    private int questionCountTotalC33 ;
    private QuestionsC33 currentQuestionC33 ;

    private int scoreC33 ;
    private boolean answeredC33 ;

    private long backPressedTimeC33 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c33);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"Avva_Shenouda.ttf" );

        textViewQuestionC33 = findViewById(R.id.text_view_questionC33);
        textViewQuestionC33.setTypeface( typeface );
        textViewScoreC33 = findViewById(R.id.text_view_scoreC33);
        textViewQuestionCountC33 = findViewById(R.id.text_view_question_countC33);
        textViewCountDownC33 = findViewById(R.id.text_view_countdownC33);
        rbGroupC33 = findViewById(R.id.radio_groupC33);
        rb1C33= findViewById(R.id.radio_button1C33);
        rb1C33.setTypeface( typeface );
        rb2C33 = findViewById(R.id.radio_button2C33);
        rb2C33.setTypeface( typeface );
        rb3C33= findViewById(R.id.radio_button3C33);
        rb3C33.setTypeface( typeface );
        buttonConfirmNextC33= findViewById(R.id.button_confirm_nextC33);

        textColorDefaultRbC33 = rb1C33.getTextColors();
        textColorDefaultCdC33= textViewCountDownC33.getTextColors();

        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionListC33 = dbHelper.getAllQuestionsC33();
            questionCountTotalC33 = questionListC33.size();
            Collections.shuffle(questionListC33);

            showNextQuestion();
        } else {
            questionListC33 = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LISTC33);
            questionCountTotalC33 = questionListC33.size();
            questionCounterC33 = savedInstanceState.getInt(KEY_QUESTION_COUNTC33);
            currentQuestionC33 = questionListC33.get(questionCounterC33 - 1);
            scoreC33 = savedInstanceState.getInt(KEY_SCOREC33);
            timeLeftInMillisC33 = savedInstanceState.getLong(KEY_MILLIS_LEFTC33);
            answeredC33 = savedInstanceState.getBoolean(KEY_ANSWEREDC33);

            if (!answeredC33) {
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        buttonConfirmNextC33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answeredC33) {
                    if (rb1C33.isChecked() || rb2C33.isChecked() || rb3C33.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizC33.this, " يجب ان تجاوب علي السؤال ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1C33.setTextColor(textColorDefaultRbC33);
        rb2C33.setTextColor(textColorDefaultRbC33);
        rb3C33.setTextColor(textColorDefaultRbC33);
        rbGroupC33.clearCheck();

        if (questionCounterC33 < questionCountTotalC33) {
            currentQuestionC33 = questionListC33.get(questionCounterC33);

            textViewQuestionC33.setText(currentQuestionC33.getQuestionC33());
            rb1C33.setText(currentQuestionC33.getOption1C33());
            rb2C33.setText(currentQuestionC33.getOption2C33());
            rb3C33.setText(currentQuestionC33.getOption3C33());

            questionCounterC33++;
            textViewQuestionCountC33.setText("Question: " + questionCounterC33 + "/" + questionCountTotalC33);
            answeredC33 = false;
            buttonConfirmNextC33.setText("اظهار الاجابة الصحيحة");

            timeLeftInMillisC33 = COUNTDOWN_IN_MILLISC33;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimerC33 = new CountDownTimer(timeLeftInMillisC33, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisC33 = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillisC33 = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillisC33 / 1000) / 60;
        int seconds = (int) (timeLeftInMillisC33 / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDownC33.setText(timeFormatted);

        if (timeLeftInMillisC33 < 10000) {
            textViewCountDownC33.setTextColor(Color.RED);
        } else {
            textViewCountDownC33.setTextColor(textColorDefaultCdC33);
        }
    }

    private void checkAnswer() {
        answeredC33 = true;

        countDownTimerC33.cancel();

        RadioButton rbSelected = findViewById(rbGroupC33.getCheckedRadioButtonId());
        int answerNr = rbGroupC33.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestionC33.getAnswerNrC33()) {
            scoreC33++;
            textViewScoreC33.setText("Score: " + scoreC33);
        }

        showSolution();
    }

    private void showSolution() {
        rb1C33.setTextColor(Color.RED);
        rb2C33.setTextColor(Color.RED);
        rb3C33.setTextColor(Color.RED);

        switch (currentQuestionC33.getAnswerNrC33()) {
            case 1:
                rb1C33.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2C33.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3C33.setTextColor(Color.GREEN);
                break;
        }

        if (questionCounterC33 < questionCountTotalC33) {
            buttonConfirmNextC33.setText("التالي ");
        } else {
            buttonConfirmNextC33.setText("انهاء الاختبار ");
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCOREC33, scoreC33);
        setResult(RESULT_OK, resultIntent);
        AlertDialog.Builder alert=new AlertDialog.Builder(QuizC33.this);
        alert.setMessage( " الدرجة  : "+scoreC33+"\nاعلي درجة  : "+QuizCatalog3.highscoreC33)
                .setCancelable(false)
                .setPositiveButton("اعادة الاختبار ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),QuizC33.class);
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
        if (backPressedTimeC33 + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "اضغط مره اخري للخروج ", Toast.LENGTH_SHORT).show();
        }

        backPressedTimeC33 = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimerC33 != null) {
            countDownTimerC33.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCOREC33, scoreC33);
        outState.putInt(KEY_QUESTION_COUNTC33, questionCounterC33);
        outState.putLong(KEY_MILLIS_LEFTC33, timeLeftInMillisC33);
        outState.putBoolean(KEY_ANSWEREDC33, answeredC33);
        outState.putParcelableArrayList(KEY_QUESTION_LISTC33, questionListC33);
    }
}
