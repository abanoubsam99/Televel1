package com.example.level1.Coptic;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.level1.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class Coptic_1 extends Fragment {
    private AdView mAdView;

  public static   PDFView pdfView;
    Button Kbar,Sgar;

    public Coptic_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coptic_1, container, false);
    }
    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        MobileAds.initialize(getContext(),
                "ca-app-pub-9066719717930706~9380288818");

        mAdView = view.findViewById(R.id.adViewcoptic13);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        pdfView=view.findViewById(R.id.pdfView_C11);
        pdfView.fromAsset("coptic11.pdf").load();



        Kbar =view.findViewById(R.id.bck1);
        Sgar =view.findViewById(R.id.bcp1);
        Sgar.setBackgroundColor(getResources().getColor(R.color.Safaf3));
        Kbar.setBackgroundColor(getResources().getColor(R.color.shafaf22));

        Kbar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                pdfView.fromAsset("coptic11.pdf").load();
                Sgar.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                Kbar.setBackgroundColor(getResources().getColor(R.color.shafaf22));

            }
        });

        Sgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdfView.fromAsset("coptic11p.pdf").load();
                Sgar.setBackgroundColor(getResources().getColor(R.color.shafaf22));
                Kbar.setBackgroundColor(getResources().getColor(R.color.Safaf3));
            }
        });
    }

}
