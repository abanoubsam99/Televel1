package com.example.level1;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Morag3a extends AppCompatActivity {

    public static PDFView pdfView;
    Button MoragaC1,MoragaC2,MoragaC3,MoragaT1,MoragaT2,MoragaT3;
    TextView textView10,textView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morag3a);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        MobileAds.initialize(this,
                "ca-app-pub-9066719717930706~9380288818");

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Typeface typeface=Typeface.createFromAsset( this.getAssets(),"a-massir-ballpoint.ttf" );
        textView10=findViewById(R.id.textView10);
        textView9=findViewById(R.id.textView9);
        textView10.setTypeface(typeface);
        textView9.setTypeface(typeface);

        pdfView=findViewById(R.id.pdfView_moragaa);
       pdfView.fromAsset("Morag3a1C1.pdf").load();

        MoragaC1 =findViewById(R.id.MoragaC1);
        MoragaC2 =findViewById(R.id.MoragaC2);
        MoragaC3 =findViewById(R.id.MoragaC3);
        MoragaT1 =findViewById(R.id.MoragaT1);
        MoragaT2 =findViewById(R.id.MoragaT2);
        MoragaT3 =findViewById(R.id.MoragaT3);
        // setfont
        MoragaC1.setTypeface(typeface);
        MoragaC2.setTypeface(typeface);
        MoragaC3.setTypeface(typeface);
        MoragaT1.setTypeface(typeface);
        MoragaT2.setTypeface(typeface);
        MoragaT3.setTypeface(typeface);

//set
        MoragaC1.setBackgroundColor(getResources().getColor(R.color.shafaf22));
        MoragaC2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
        MoragaC3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
        MoragaT1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
        MoragaT2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
        MoragaT3.setBackgroundColor(getResources().getColor(R.color.Safaf3));



        MoragaC1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                   pdfView.fromAsset("Morag3a1C1.pdf").load();

                MoragaC1.setBackgroundColor(getResources().getColor(R.color.shafaf22));
                MoragaC2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
            }
        });

        MoragaC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 pdfView.fromAsset("Morag3a1C2.pdf").load();

                MoragaC1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC2.setBackgroundColor(getResources().getColor(R.color.shafaf22));
                MoragaC3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
            }
        });

        MoragaC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             pdfView.fromAsset("Morag3a1C3.pdf").load();
                MoragaC1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC3.setBackgroundColor(getResources().getColor(R.color.shafaf22));
                MoragaT1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
            }
        });


        MoragaT1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                  pdfView.fromAsset("Morag3a1T1.pdf").load();

                MoragaC1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT1.setBackgroundColor(getResources().getColor(R.color.shafaf22));
                MoragaT2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT3.setBackgroundColor(getResources().getColor(R.color.Safaf3));

            }
        });

        MoragaT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  pdfView.fromAsset("Morag3a1T2.pdf").load();
                MoragaC1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT2.setBackgroundColor(getResources().getColor(R.color.shafaf22));
                MoragaT3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
            }
        });


        MoragaT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 pdfView.fromAsset("Morag3a1T3.pdf").load();

                MoragaC1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaC3.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT1.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT2.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                MoragaT3.setBackgroundColor(getResources().getColor(R.color.shafaf22));
            }
        });


    }
}
