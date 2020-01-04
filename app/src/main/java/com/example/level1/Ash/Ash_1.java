package com.example.level1.Ash;


import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.level1.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ash_1 extends Fragment {

    private AdView mAdView;

    public Ash_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ash_1, container, false);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        Typeface typeface=Typeface.createFromAsset( getActivity().getAssets(),"Avva_Shenouda.ttf" );
        TextView textView=view.findViewById( R.id.COPTIC_ash1 );
        textView.setTypeface( typeface );

        AdView mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final TextView Ta=view.findViewById(R.id.ARAB_ash1);
        final TextView TC=view.findViewById(R.id.COPTIC_ash1);
        final TextView TCA=view.findViewById(R.id.Ca_ash1);
        Spinner spinner=view.findViewById(R.id.spinner_ash1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (view != null) {
                    if (i == 0) {
                        Ta.setText(R.string.hlm_ash111);
                        TC.setText("");
                        TCA.setText("");

                    } else if (i == 1) {
                        Ta.setText(R.string.polos_ash111);
                        TC.setText("");
                        TCA.setText("");
                    } else if (i == 2) {
                        Ta.setText(R.string.wahed_ash112);
                        TC.setText("");
                        TCA.setText("");

                    }

                    else if (i == 3) {
                        Ta.setText(R.string.toba__ash113);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 4) {
                        Ta.setText(R.string.engel__ash113);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 5) {
                        Ta.setText(R.string.kt3a1_ash113);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 6) {
                        Ta.setText(R.string.kt3a2__ash113);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 7) {
                        Ta.setText(R.string.kt3a3__ash113);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 8) {
                        Ta.setText(R.string.tahlel1_ash113);
                        TC.setText("");
                        TCA.setText("");

                    }

                    else {
                        Ta.setText(R.string.tahlel2_ash113);
                        TC.setText("");
                        TCA.setText("");
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }


}
