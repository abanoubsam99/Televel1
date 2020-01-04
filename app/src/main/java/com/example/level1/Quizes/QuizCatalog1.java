package com.example.level1.Quizes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level1.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class QuizCatalog1 extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdView mAdView,mAdView2,mAdView3;
//T1
    private TextView textViewHighscoreT11;
    private static final int REQUEST_CODE_QUIZT11 = 1;
    public static final String SHARED_PREFST11 = "sharedPrefsT11";
    public static final String KEY_HIGHSCORET11 = "keyHighscoreT11";

    private TextView textViewHighscoreT12;
    private static final int REQUEST_CODE_QUIZT12 = 2;
    public static final String SHARED_PREFST12 = "sharedPrefsT12";
    public static final String KEY_HIGHSCORET12= "keyHighscoreT12";

    private TextView textViewHighscoreT13;
    private static final int REQUEST_CODE_QUIZT13 = 3;
    public static final String SHARED_PREFST13 = "sharedPrefsT13";
    public static final String KEY_HIGHSCORET13 = "keyHighscoreT13";



//C1


    private TextView textViewHighscoreC11;
    private static final int REQUEST_CODE_QUIZC11 = 4;
    public static final String SHARED_PREFSC11 = "sharedPrefsC11";
    public static final String KEY_HIGHSCOREC11 = "keyHighscoreC11";

    private TextView textViewHighscoreC12;
    private static final int REQUEST_CODE_QUIZC12 = 5;
    public static final String SHARED_PREFSC12 = "sharedPrefsC12";
    public static final String KEY_HIGHSCOREC12= "keyHighscoreC12";

    private TextView textViewHighscoreC13;
    private static final int REQUEST_CODE_QUIZC13 = 6;
    public static final String SHARED_PREFSC13 = "sharedPrefsC13";
    public static final String KEY_HIGHSCOREC13 = "keyHighscoreC13";


//T1
    public static int  highscoreT11;
    public static int highscoreT12;
    public static int highscoreT13;

//C1
public static int highscoreC11;
    public static int highscoreC12;
    public static int highscoreC13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_catalog1);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView2 = findViewById(R.id.adViewquiz2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);


        mAdView3 = findViewById(R.id.adViewquiz3);
        AdRequest adRequest3 = new AdRequest.Builder().build();
        mAdView3.loadAd(adRequest3);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9066719717930706/8428211280");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
//T1
        textViewHighscoreT11 = findViewById(R.id.hight11);
        textViewHighscoreT12 = findViewById(R.id.hight12);
        textViewHighscoreT13 = findViewById(R.id.hight13);
//C1
        textViewHighscoreC11 = findViewById(R.id.highc11);
        textViewHighscoreC12 = findViewById(R.id.highc12);
        textViewHighscoreC13 = findViewById(R.id.highc13);


        loadHighscoreT11();
        loadHighscoreT12();
        loadHighscoreT13();

        loadHighscoreC11();
        loadHighscoreC12();
        loadHighscoreC13();


    }
    public void quizt11(View view) {
        Intent intent=new Intent(this, QuizT11.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZT11);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizt12(View view) {
        Intent intent=new Intent(this, QuizT12.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZT12);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizt13(View view) {
        Intent intent=new Intent(this, QuizT13.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZT13);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    public void quizC11(View view) {
        Intent intent=new Intent(this, QuizC11.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZC11);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizC12(View view) {
        Intent intent=new Intent(this, QuizC12.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZC12);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizC13(View view) {
        Intent intent=new Intent(this, QuizC13.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZC13);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //T1
        if (requestCode == REQUEST_CODE_QUIZT11) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizT11.EXTRA_SCORET11, 0);
                if (score > highscoreT11) {
                    updateHighscoreT11(score);
                }
            }
        }


        else if (requestCode == REQUEST_CODE_QUIZT12) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizT12.EXTRA_SCORET12, 0);
                if (score > highscoreT12) {
                    updateHighscoreT12(score);
                }
            }
        }


        else if (requestCode == REQUEST_CODE_QUIZT13) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizT13.EXTRA_SCORET13, 0);
                if (score > highscoreT13) {
                    updateHighscoreT13(score);
                }
            }
        }

//C1


        else if (requestCode == REQUEST_CODE_QUIZC11) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizC11.EXTRA_SCOREC11, 0);
                if (score > highscoreC11) {
                    updateHighscoreC11(score);
                }
            }
        }

        else if (requestCode == REQUEST_CODE_QUIZC12) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizC12.EXTRA_SCOREC12, 0);
                if (score > highscoreC12) {
                    updateHighscoreC12(score);
                }
            }
        }

        else if (requestCode == REQUEST_CODE_QUIZC13) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizC13.EXTRA_SCOREC13, 0);
                if (score > highscoreC13) {
                    updateHighscoreC13(score);
                }
            }
        }

        else {
            Toast.makeText(this, "error ", Toast.LENGTH_SHORT).show();
        }




    }
//T1
    private void loadHighscoreT11() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST11, MODE_PRIVATE);
        highscoreT11 = prefs.getInt(KEY_HIGHSCORET11, 0);
        textViewHighscoreT11.setText("HighScore: " + highscoreT11+"/25");
    }

    private void updateHighscoreT11(int highscoreNew) {
        highscoreT11 = highscoreNew;
        textViewHighscoreT11.setText("HighScore : " + highscoreT11+"/25");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST11, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORET11, highscoreT11);
        editor.apply();
    }



    private void loadHighscoreT12() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST12, MODE_PRIVATE);
        highscoreT12 = prefs.getInt(KEY_HIGHSCORET12, 0);
        textViewHighscoreT12.setText("HighScore: " + highscoreT12+"/22");
    }

    private void updateHighscoreT12(int highscoreNew) {
        highscoreT12 = highscoreNew;
        textViewHighscoreT12.setText("HighScore: " + highscoreT12+"/22");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST12, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORET12, highscoreT12);
        editor.apply();
    }



    private void loadHighscoreT13() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST13, MODE_PRIVATE);
        highscoreT13 = prefs.getInt(KEY_HIGHSCORET13, 0);
        textViewHighscoreT13.setText("HighScore: " + highscoreT13+"/39");
    }

    private void updateHighscoreT13(int highscoreNew) {
        highscoreT13 = highscoreNew;
        textViewHighscoreT13.setText("HighScore: " + highscoreT13+"/39");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST13, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORET13, highscoreT13);
        editor.apply();
    }




//C1

    private void loadHighscoreC11() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC11, MODE_PRIVATE);
        highscoreC11 = prefs.getInt(KEY_HIGHSCOREC11, 0);
        textViewHighscoreC11.setText("HighScore: " + highscoreC11+"/13");
    }

    private void updateHighscoreC11(int highscoreNew) {
        highscoreC11 = highscoreNew;
        textViewHighscoreC11.setText("HighScore : " + highscoreC11+"/13");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC11, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCOREC11, highscoreC11);
        editor.apply();
    }



    private void loadHighscoreC12() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC12, MODE_PRIVATE);
        highscoreC12 = prefs.getInt(KEY_HIGHSCOREC12, 0);
        textViewHighscoreC12.setText("HighScore: " + highscoreC12+"/28");
    }

    private void updateHighscoreC12(int highscoreNew) {
        highscoreC12 = highscoreNew;
        textViewHighscoreC12.setText("HighScore: " + highscoreC12+"/28");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC12, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCOREC12, highscoreC12);
        editor.apply();
    }



    private void loadHighscoreC13() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC13, MODE_PRIVATE);
        highscoreC13 = prefs.getInt(KEY_HIGHSCOREC13, 0);
        textViewHighscoreC13.setText("HighScore: " + highscoreC13+"/20");
    }

    private void updateHighscoreC13(int highscoreNew) {
        highscoreC13 = highscoreNew;
        textViewHighscoreC13.setText("HighScore: " + highscoreC13+"/20");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC13, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCOREC13, highscoreC13);
        editor.apply();
    }








}
