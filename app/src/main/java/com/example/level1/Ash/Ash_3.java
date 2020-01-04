package com.example.level1.Ash;


import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
public class Ash_3 extends Fragment {

    private AdView mAdView;

    public Ash_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ash_3, container, false);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);






        Typeface typeface=Typeface.createFromAsset( getActivity().getAssets(),"Avva_Shenouda.ttf" );
        TextView textView=view.findViewById( R.id.COPTIC_ash3 );
        textView.setTypeface( typeface );

        AdView mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final TextView Ta=view.findViewById(R.id.ARAB_ash3);
        final TextView TC=view.findViewById(R.id.COPTIC_ash3);
        final TextView TCA=view.findViewById(R.id.Ca_ash3);
        Spinner spinner=view.findViewById(R.id.spinner_ash3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (view != null) {
                    if (i == 0) {
                        Ta.setText(R.string.mazmor53_ash131);
                        TC.setText("");
                        TCA.setText("");

                    } else if (i == 1) {
                        Ta.setText(R.string.mazmor69_ash131);
                        TC.setText("");
                        TCA.setText("");
                    } else if (i == 2) {
                        Ta.setText(R.string.mazmor92_ash132);
                        TC.setText("");
                        TCA.setText("");

                    }

                    else if (i == 3) {
                        Ta.setText(R.string.engel_ash132);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 4) {
                        Ta.setText(R.string.ket3a1_ash133);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 5) {
                        Ta.setText(R.string.ket3a2_ash133);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 6) {
                        Ta.setText(R.string.ket3a3_ash133);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 7) {
                        Ta.setText(R.string.ket3a4_ash133);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 8) {
                        Ta.setText(R.string.ket3a5_ash133);
                        TC.setText("");
                        TCA.setText("");

                    }

                    else if (i == 9) {
                        Ta.setText(R.string.ket3a6_ash133);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else {
                        Ta.setText(R.string.ta7lel_ash133);
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
