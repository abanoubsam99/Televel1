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

public class QuizCatalog3 extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private AdView mAdView,mAdView2,mAdView3;
    //T1
    private TextView textViewHighscoreT31;
    private static final int REQUEST_CODE_QUIZT31 = 1;
    public static final String SHARED_PREFST31 = "sharedPrefsT31";
    public static final String KEY_HIGHSCORET31 = "keyHighscoreT31";

    private TextView textViewHighscoreT32;
    private static final int REQUEST_CODE_QUIZT32 = 2;
    public static final String SHARED_PREFST32 = "sharedPrefsT32";
    public static final String KEY_HIGHSCORET32= "keyHighscoreT32";

    private TextView textViewHighscoreT33;
    private static final int REQUEST_CODE_QUIZT33 = 3;
    public static final String SHARED_PREFST33 = "sharedPrefsT33";
    public static final String KEY_HIGHSCORET33 = "keyHighscoreT33";



//C1


    private TextView textViewHighscoreC31;
    private static final int REQUEST_CODE_QUIZC31 = 4;
    public static final String SHARED_PREFSC31 = "sharedPrefsC31";
    public static final String KEY_HIGHSCOREC31 = "keyHighscoreC31";

    private TextView textViewHighscoreC32;
    private static final int REQUEST_CODE_QUIZC32 = 5;
    public static final String SHARED_PREFSC32 = "sharedPrefsC32";
    public static final String KEY_HIGHSCOREC32= "keyHighscoreC32";

    private TextView textViewHighscoreC33;
    private static final int REQUEST_CODE_QUIZC33 = 6;
    public static final String SHARED_PREFSC33 = "sharedPrefsC33";
    public static final String KEY_HIGHSCOREC33 = "keyHighscoreC33";


    //T1
    public static int highscoreT31;
    public static int highscoreT32;
    public static int highscoreT33;

    //C1
    public static int highscoreC31;
    public static int highscoreC32;
    public static int highscoreC33;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_catalog3);



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
        textViewHighscoreT31 = findViewById(R.id.hight31);
        textViewHighscoreT32 = findViewById(R.id.hight32);
        textViewHighscoreT33 = findViewById(R.id.hight33);
//C1
        textViewHighscoreC31 = findViewById(R.id.highc31);
        textViewHighscoreC32 = findViewById(R.id.highc32);
        textViewHighscoreC33 = findViewById(R.id.highc33);


        loadHighscoreT31();
        loadHighscoreT32();
        loadHighscoreT33();

        loadHighscoreC31();
        loadHighscoreC32();
        loadHighscoreC33();


    }
    public void quizt31(View view) {
        Intent intent=new Intent(this, QuizT31.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZT31);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizt32(View view) {
        Intent intent=new Intent(this, QuizT32.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZT32);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizt33(View view) {
        Intent intent=new Intent(this, QuizT33.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZT33);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    public void quizC31(View view) {
        Intent intent=new Intent(this, QuizC31.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZC31);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizC32(View view) {
        Intent intent=new Intent(this, QuizC32.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZC32);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizC33(View view) {
        Intent intent=new Intent(this, QuizC33.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZC33);
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
        if (requestCode == REQUEST_CODE_QUIZT31) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizT31.EXTRA_SCORET31, 0);
                if (score > highscoreT31) {
                    updateHighscoreT31(score);
                }
            }
        }


        else if (requestCode == REQUEST_CODE_QUIZT32) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizT32.EXTRA_SCORET32, 0);
                if (score > highscoreT32) {
                    updateHighscoreT32(score);
                }
            }
        }


        else if (requestCode == REQUEST_CODE_QUIZT33) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizT33.EXTRA_SCORET33, 0);
                if (score > highscoreT33) {
                    updateHighscoreT33(score);
                }
            }
        }

//C1


        else if (requestCode == REQUEST_CODE_QUIZC31) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizC31.EXTRA_SCOREC31, 0);
                if (score > highscoreC31) {
                    updateHighscoreC31(score);
                }
            }
        }

        else if (requestCode == REQUEST_CODE_QUIZC32) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizC32.EXTRA_SCOREC32, 0);
                if (score > highscoreC32) {
                    updateHighscoreC32(score);
                }
            }
        }

        else if (requestCode == REQUEST_CODE_QUIZC33) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizC33.EXTRA_SCOREC33, 0);
                if (score > highscoreC33) {
                    updateHighscoreC33(score);
                }
            }
        }

        else {
            Toast.makeText(this, "error ", Toast.LENGTH_SHORT).show();
        }




    }
    //T1
    private void loadHighscoreT31() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST31, MODE_PRIVATE);
        highscoreT31 = prefs.getInt(KEY_HIGHSCORET31, 0);
        textViewHighscoreT31.setText("HighScore: " + highscoreT31+"/28");
    }

    private void updateHighscoreT31(int highscoreNew) {
        highscoreT31 = highscoreNew;
        textViewHighscoreT31.setText("HighScore : " + highscoreT31+"/28");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST31, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORET31, highscoreT31);
        editor.apply();
    }



    private void loadHighscoreT32() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST32, MODE_PRIVATE);
        highscoreT32 = prefs.getInt(KEY_HIGHSCORET32, 0);
        textViewHighscoreT32.setText("HighScore: " + highscoreT32+"/19");
    }

    private void updateHighscoreT32(int highscoreNew) {
        highscoreT32 = highscoreNew;
        textViewHighscoreT32.setText("HighScore: " + highscoreT32+"/19");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST32, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORET32, highscoreT32);
        editor.apply();
    }



    private void loadHighscoreT33() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST33, MODE_PRIVATE);
        highscoreT33 = prefs.getInt(KEY_HIGHSCORET33, 0);
        textViewHighscoreT33.setText("HighScore: " + highscoreT33+"/13");
    }

    private void updateHighscoreT33(int highscoreNew) {
        highscoreT33 = highscoreNew;
        textViewHighscoreT33.setText("HighScore: " + highscoreT33+"/13");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST33, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORET33, highscoreT33);
        editor.apply();
    }




//C1

    private void loadHighscoreC31() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC31, MODE_PRIVATE);
        highscoreC31 = prefs.getInt(KEY_HIGHSCOREC31, 0);
        textViewHighscoreC31.setText("HighScore: " + highscoreC31+"/28");
    }

    private void updateHighscoreC31(int highscoreNew) {
        highscoreC31 = highscoreNew;
        textViewHighscoreC31.setText("HighScore : " + highscoreC31+"/28");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC31, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCOREC31, highscoreC31);
        editor.apply();
    }



    private void loadHighscoreC32() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC32, MODE_PRIVATE);
        highscoreC32 = prefs.getInt(KEY_HIGHSCOREC32, 0);
        textViewHighscoreC32.setText("HighScore: " + highscoreC32+"/15");
    }

    private void updateHighscoreC32(int highscoreNew) {
        highscoreC32 = highscoreNew;
        textViewHighscoreC32.setText("HighScore: " + highscoreC32+"/15");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC32, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCOREC32, highscoreC32);
        editor.apply();
    }



    private void loadHighscoreC33() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC33, MODE_PRIVATE);
        highscoreC33 = prefs.getInt(KEY_HIGHSCOREC33, 0);
        textViewHighscoreC33.setText("HighScore: " + highscoreC33+"/25");
    }

    private void updateHighscoreC33(int highscoreNew) {
        highscoreC33 = highscoreNew;
        textViewHighscoreC33.setText("HighScore: " + highscoreC33+"/25");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC33, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCOREC33, highscoreC33);
        editor.apply();
    }

}
