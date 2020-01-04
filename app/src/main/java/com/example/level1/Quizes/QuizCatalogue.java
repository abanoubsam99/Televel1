package com.example.level1.Quizes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level1.Level1_1;
import com.example.level1.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class QuizCatalogue extends AppCompatActivity {

    private AdView mAdView;

    Button button_1,button2,button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_catalogue);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        MobileAds.initialize(this, "ca-app-pub-9066719717930706~9380288818");

        mAdView = findViewById(R.id.adViewquiz);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Typeface typeface2=Typeface.createFromAsset( this.getAssets(),"a-massir-ballpoint.ttf" );

        button_1=findViewById(R.id.button_1);
        button2=findViewById(R.id.button2);
        button5=findViewById(R.id.button5);

        button_1.setTypeface(typeface2);
        button2.setTypeface(typeface2);
        button5.setTypeface(typeface2);

    }

    public void Quiz1(View view) {
        Intent intent=new Intent(this, QuizCatalog1.class);
        startActivity( intent );

    }

    public void Quiz2(View view) {
        Intent intent=new Intent(this,QuizCatalog2.class);
        startActivity( intent );

    }

    public void Quiz3(View view) {
        Intent intent=new Intent(this,QuizCatalog3.class);
        startActivity( intent );

    }
}
