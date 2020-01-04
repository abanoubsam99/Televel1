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
public class Aah_2 extends Fragment {

    private AdView mAdView;

    public Aah_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aah_2, container, false);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        Typeface typeface=Typeface.createFromAsset( getActivity().getAssets(),"Avva_Shenouda.ttf" );
        TextView textView=view.findViewById( R.id.COPTIC_ash2 );
        textView.setTypeface( typeface );

        AdView mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final TextView Ta=view.findViewById(R.id.ARAB_ash2);
        final TextView TC=view.findViewById(R.id.COPTIC_ash2);
        final TextView TCA=view.findViewById(R.id.Ca_ash2);
        Spinner spinner=view.findViewById(R.id.spinner_ash2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (view != null) {
                    if (i == 0) {
                        Ta.setText(R.string.ystageb_ash121);
                        TC.setText("");
                        TCA.setText("");

                    } else if (i == 1) {
                        Ta.setText(R.string.alrabyr3any_ash121);
                        TC.setText("");
                        TCA.setText("");
                    } else if (i == 2) {
                        Ta.setText(R.string.llrabelard_ash122);
                        TC.setText("");
                        TCA.setText("");

                    }

                    else if (i == 3) {
                        Ta.setText(R.string.engel_ash122);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 4) {
                        Ta.setText(R.string.ketaa1_ash123);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 5) {
                        Ta.setText(R.string.ketaa2_ash123);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 6) {
                        Ta.setText(R.string.ketaa3_ash123);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 7) {
                        Ta.setText(R.string.ketaa4_ash123);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i == 8) {
                        Ta.setText(R.string.ketaa5_ash123);
                        TC.setText("");
                        TCA.setText("");

                    }
                    else if (i ==9) {
                        Ta.setText(R.string.ketaa6_ash121);
                        TC.setText("");
                        TCA.setText("");

                    }

                    else {
                        Ta.setText(R.string.ta7lel_ash123);
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
