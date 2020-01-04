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

public class QuizCatalog2 extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdView mAdView,mAdView2,mAdView3;
    //T2
    private TextView textViewHighscoreT21;
    private static final int REQUEST_CODE_QUIZT21 = 1;
    public static final String SHARED_PREFST21 = "sharedPrefsT21";
    public static final String KEY_HIGHSCORET21 = "keyHighscoreT21";

    private TextView textViewHighscoreT22;
    private static final int REQUEST_CODE_QUIZT22 = 2;
    public static final String SHARED_PREFST22 = "sharedPrefsT22";
    public static final String KEY_HIGHSCORET22= "keyHighscoreT22";

    private TextView textViewHighscoreT23;
    private static final int REQUEST_CODE_QUIZT23 = 3;
    public static final String SHARED_PREFST23 = "sharedPrefsT23";
    public static final String KEY_HIGHSCORET23 = "keyHighscoreT23";



    //C2


    private TextView textViewHighscoreC21;
    private static final int REQUEST_CODE_QUIZC21 = 4;
    public static final String SHARED_PREFSC21 = "sharedPrefsC21";
    public static final String KEY_HIGHSCOREC21 = "keyHighscoreC21";

    private TextView textViewHighscoreC22;
    private static final int REQUEST_CODE_QUIZC22 = 5;
    public static final String SHARED_PREFSC22 = "sharedPrefsC22";
    public static final String KEY_HIGHSCOREC22= "keyHighscoreC22";

    private TextView textViewHighscoreC23;
    private static final int REQUEST_CODE_QUIZC23 = 6;
    public static final String SHARED_PREFSC23 = "sharedPrefsC23";
    public static final String KEY_HIGHSCOREC23 = "keyHighscoreC23";


    //T2
    public static  int highscoreT21;
    public static int highscoreT22;
    public static int highscoreT23;

    //C2
    public static int highscoreC21;
    public static int highscoreC22;
    public static int highscoreC23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_catalog2);

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
        textViewHighscoreT21 = findViewById(R.id.hight21);
        textViewHighscoreT22 = findViewById(R.id.hight22);
        textViewHighscoreT23 = findViewById(R.id.hight23);
//C1
        textViewHighscoreC21 = findViewById(R.id.highc21);
        textViewHighscoreC22 = findViewById(R.id.highc22);
        textViewHighscoreC23 = findViewById(R.id.highc23);


        loadHighscoreT21();
        loadHighscoreT22();
        loadHighscoreT23();

        loadHighscoreC21();
        loadHighscoreC22();
        loadHighscoreC23();


    }
    public void quizt21(View view) {
        Intent intent=new Intent(this, QuizT21.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZT21);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizt22(View view) {
        Intent intent=new Intent(this, QuizT22.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZT22);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizt23(View view) {
        Intent intent=new Intent(this, QuizT23.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZT23);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    public void quizC21(View view) {
        Intent intent=new Intent(this, QuizC21.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZC21);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizC22(View view) {
        Intent intent=new Intent(this, QuizC22.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZC22);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }
    public void quizC23(View view) {
        Intent intent=new Intent(this, QuizC23.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZC23);
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
        if (requestCode == REQUEST_CODE_QUIZT21) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizT21.EXTRA_SCORET21, 0);
                if (score > highscoreT21) {
                    updateHighscoreT21(score);
                }
            }
        }


        else if (requestCode == REQUEST_CODE_QUIZT22) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizT22.EXTRA_SCORET22, 0);
                if (score > highscoreT22) {
                    updateHighscoreT22(score);
                }
            }
        }


        else if (requestCode == REQUEST_CODE_QUIZT23) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizT23.EXTRA_SCORET23, 0);
                if (score > highscoreT23) {
                    updateHighscoreT23(score);
                }
            }
        }

//C1


        else if (requestCode == REQUEST_CODE_QUIZC21) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizC21.EXTRA_SCOREC21, 0);
                if (score > highscoreC21) {
                    updateHighscoreC21(score);
                }
            }
        }

        else if (requestCode == REQUEST_CODE_QUIZC22) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizC22.EXTRA_SCOREC22, 0);
                if (score > highscoreC22) {
                    updateHighscoreC22(score);
                }
            }
        }

        else if (requestCode == REQUEST_CODE_QUIZC23) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizC23.EXTRA_SCOREC23, 0);
                if (score > highscoreC23) {
                    updateHighscoreC23(score);
                }
            }
        }

        else {
            Toast.makeText(this, "error ", Toast.LENGTH_SHORT).show();
        }




    }
    //T1
    private void loadHighscoreT21() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST21, MODE_PRIVATE);
        highscoreT21 = prefs.getInt(KEY_HIGHSCORET21, 0);
        textViewHighscoreT21.setText("HighScore: " + highscoreT21+"/18");
    }

    private void updateHighscoreT21(int highscoreNew) {
        highscoreT21 = highscoreNew;
        textViewHighscoreT21.setText("HighScore : " + highscoreT21+"/18");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST21, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORET21, highscoreT21);
        editor.apply();
    }



    private void loadHighscoreT22() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST22, MODE_PRIVATE);
        highscoreT22 = prefs.getInt(KEY_HIGHSCORET22, 0);
        textViewHighscoreT22.setText("HighScore: " + highscoreT22+"/15");
    }

    private void updateHighscoreT22(int highscoreNew) {
        highscoreT22 = highscoreNew;
        textViewHighscoreT22.setText("HighScore: " + highscoreT22+"/15");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST22, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORET22, highscoreT22);
        editor.apply();
    }



    private void loadHighscoreT23() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST23, MODE_PRIVATE);
        highscoreT23 = prefs.getInt(KEY_HIGHSCORET23, 0);
        textViewHighscoreT23.setText("HighScore: " + highscoreT23+"/42");
    }

    private void updateHighscoreT23(int highscoreNew) {
        highscoreT23 = highscoreNew;
        textViewHighscoreT23.setText("HighScore: " + highscoreT23+"/42");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFST23, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORET23, highscoreT23);
        editor.apply();
    }




//C1

    private void loadHighscoreC21() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC21, MODE_PRIVATE);
        highscoreC21 = prefs.getInt(KEY_HIGHSCOREC21, 0);
        textViewHighscoreC21.setText("HighScore: " + highscoreC21+"/16");
    }

    private void updateHighscoreC21(int highscoreNew) {
        highscoreC21 = highscoreNew;
        textViewHighscoreC21.setText("HighScore : " + highscoreC21+"/16");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC21, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCOREC21, highscoreC21);
        editor.apply();
    }



    private void loadHighscoreC22() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC22, MODE_PRIVATE);
        highscoreC22 = prefs.getInt(KEY_HIGHSCOREC22, 0);
        textViewHighscoreC22.setText("HighScore: " + highscoreC22+"/15");
    }

    private void updateHighscoreC22(int highscoreNew) {
        highscoreC22 = highscoreNew;
        textViewHighscoreC22.setText("HighScore: " + highscoreC22+"/15");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC22, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCOREC22, highscoreC22);
        editor.apply();
    }



    private void loadHighscoreC23() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC23, MODE_PRIVATE);
        highscoreC23 = prefs.getInt(KEY_HIGHSCOREC23, 0);
        textViewHighscoreC23.setText("HighScore: " + highscoreC23+"/32");
    }

    private void updateHighscoreC23(int highscoreNew) {
        highscoreC23 = highscoreNew;
        textViewHighscoreC23.setText("HighScore: " + highscoreC23+"/32");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFSC23, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCOREC23, highscoreC23);
        editor.apply();
    }

}
