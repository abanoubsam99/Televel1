package com.example.level1.Taks;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
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
public class Taks_3 extends Fragment {
    private AdView mAdView,mAdView2;

    PDFView pdfView;

    public Taks_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_taks_3, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        MobileAds.initialize(getContext(),
                "ca-app-pub-9066719717930706~9380288818");

        mAdView = view.findViewById(R.id.adViewTask3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView2 = view.findViewById(R.id.adViewTask32);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);



        pdfView=view.findViewById(R.id.pdfView_T13);
        pdfView.fromAsset("taks13.pdf").load();
    }
}
