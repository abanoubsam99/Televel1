package com.example.level1.Al7an;


import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level1.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class A113 extends Fragment {
    private AdView mAdView;

    boolean play=true;
    boolean puse=false;

    boolean music=true;

    public static ScrollView scrollView;

    SeekBar seekBar;
    int fprograss;
    public static  MediaPlayer mediaPlayer=new MediaPlayer();

    public static double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private TextView timeend_113,timestart_113;
    public static int oneTimeOnly = 0;

    public A113() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a113, container, false);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        scrollView=view.findViewById(R.id.scrollView_A113);


        MobileAds.initialize(getContext(),
                "ca-app-pub-9066719717930706~9380288818");

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        Typeface typeface=Typeface.createFromAsset( getActivity().getAssets(),"Avva_Shenouda.ttf" );
        TextView textView=view.findViewById( R.id.COPTIC_A113 );
        textView.setTypeface( typeface );

        chang_play(play,puse);



        FloatingActionButton play=view.findViewById(R.id.play_A113);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chang_play(false,true);


                if (music==true){
                    mediaPlayer.start();
                }
                else {
                    Toast.makeText(getActivity(), " لم يتم اضافة صوت هذا اللحن ", Toast.LENGTH_SHORT).show();
                    chang_play(true,false);
                }                   }
        });

        FloatingActionButton puse=view.findViewById(R.id.puse_A113);
        puse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chang_play(true,false);
                mediaPlayer.pause();
            }
        });



        final TextView Ta=view.findViewById(R.id.ARAB_A113);
        final TextView TC=view.findViewById(R.id.COPTIC_A113);
        final TextView TCA=view.findViewById(R.id.Ca_A113);
        timestart_113 =view.findViewById(R.id.timestart_113);
        timeend_113 =view.findViewById(R.id.timeend_113);
        Spinner spinner=view.findViewById(R.id.spinner_A113);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (view != null) {


                    if (i == 0) {
                        Ta.setText(R.string.mradatba3d_A113a);
                        TC.setText(R.string.mradatba3d_A113c);
                        TCA.setText(R.string.mradatba3d_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.m3ro7ak113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);


                    } else if (i == 1) {
                        Ta.setText(R.string.nesherofem_A113a);
                        TC.setText(R.string.nesherofem_A113c);
                        TCA.setText(R.string.nesherofem_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.nesherobem113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    } else if (i == 2) {
                        Ta.setText(R.string.ba3delsharobem_A113a);
                        TC.setText(R.string.ba3delsharobem_A113c);
                        TCA.setText(R.string.ba3delsharobem_A113ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdba3d113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 3) {
                        Ta.setText(R.string.mrdrshom_A113a);
                        TC.setText(R.string.mrdrshom_A113c);
                        TCA.setText(R.string.mrdrshom_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.rshomat113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 4) {
                        Ta.setText(R.string.rshomat1_A113a);
                        TC.setText(R.string.rshomat1_A113c);
                        TCA.setText(R.string.rshomat1_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrd5obz113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 5) {
                        Ta.setText(R.string.rshomatkas_A113a);
                        TC.setText(R.string.rshomatkas_A113c);
                        TCA.setText(R.string.rshomatkas_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdkas113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 6) {
                        Ta.setText(R.string.amenamenamen_A113a);
                        TC.setText(R.string.amenamenamen_A113c);
                        TCA.setText(R.string.amenamenamen_A113ca);
                        music=true;

                        mediaPlayer.stop();
                        chang_play(true,false);

                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ton113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 7) {
                        Ta.setText(R.string.mrad7lol_A113a);
                        TC.setText(R.string.mrad7lol_A113c);
                        TCA.setText(R.string.mrad7lol_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrd7lol113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 8) {
                        Ta.setText(R.string.mrdawashe_A113a);
                        TC.setText(R.string.mrdawashe_A113c);
                        TCA.setText(R.string.mrdawashe_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.er7amna113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 9) {
                        Ta.setText(R.string.yarabor7amyarab_A113a);
                        TC.setText(R.string.yarabor7amyarab_A113c);
                        TCA.setText(R.string.yarabor7amyarab_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdmaa113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    } else if (i == 10) {
                        Ta.setText(R.string.yarab_A113a);
                        TC.setText(R.string.yarab_A113c);
                        TCA.setText(R.string.yarab_A113ca);
                        scrollView.smoothScrollTo(0, 0);

                        music=true;

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdkraben113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 11) {
                        Ta.setText(R.string.er7amna3_A113a);
                        TC.setText("");
                        TCA.setText("");
                        music=false;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                        timestart_113.setText("0 : 0");
                        timeend_113.setText("0 : 0");
                    }
                    else if (i == 12) {
                        Ta.setText(R.string.areboesmo_A113a);
                        TC.setText(R.string.areboesmo_A113c);
                        TCA.setText(R.string.areboesmo_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ereboesmo113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 13) {
                        Ta.setText(R.string.osberen_A113a);
                        TC.setText(R.string.osberen_A113c);
                        TCA.setText(R.string.osberen_A113ca);
                        music=true;

                        mediaPlayer.stop();
                        chang_play(true,false);

                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.kamakan113);
                        seekBar.setMax(mediaPlayer.getDuration() );
                        time(mediaPlayer);


                    }
                    else if (i == 14) {
                        Ta.setText(R.string.mradat7taelkesma_A113a);
                        TC.setText(R.string.mradat7taelkesma_A113c);
                        TCA.setText(R.string.mradat7taelkesma_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrd7ta113);
                        seekBar.setMax(mediaPlayer.getDuration() );
                        time(mediaPlayer);

                    }
                    else if (i == 15) {
                        Ta.setText(R.string.inkesma_A113a);
                        TC.setText(R.string.inkesma_A113c);
                        TCA.setText(R.string.inkesma_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdin113);
                        seekBar.setMax(mediaPlayer.getDuration() );
                        time(mediaPlayer);

                    }
                    else if (i == 16) {
                        Ta.setText(R.string.mrdba3dkesma_A113a);
                        TC.setText(R.string.mrdba3dkesma_A113c);
                        TCA.setText(R.string.mrdba3dkesma_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdba3dksma113);
                        seekBar.setMax(mediaPlayer.getDuration() );
                        time(mediaPlayer);

                    }
                    else if (i == 17) {
                        Ta.setText(R.string.eso_A113a);
                        TC.setText(R.string.eso_A113c);
                        TCA.setText(R.string.eso_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.wa7ed113);
                        seekBar.setMax(mediaPlayer.getDuration() );
                        time(mediaPlayer);

                    }
                    else if (i == 18) {
                        Ta.setText(R.string.mrda3traf_A113a);
                        TC.setText(R.string.mrda3traf_A113c);
                        TCA.setText(R.string.mrda3traf_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdkable3traf);
                        seekBar.setMax(mediaPlayer.getDuration() );
                        time(mediaPlayer);
                    }
                    else if (i == 19) {
                        Ta.setText(R.string.elmagd_A113a);
                        TC.setText(R.string.elmagd_A113c);
                        TCA.setText(R.string.elmagd_A113ca);
                        music=false;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        seekBar.setMax(mediaPlayer.getDuration());
                        timestart_113.setText("0 : 0");
                        timeend_113.setText("0 : 0");
                    }
                    else if (i == 20) {
                        Ta.setText(R.string.eltwze3_A113a);
                        TC.setText(R.string.eltwze3_A113c);
                        TCA.setText(R.string.eltwze3_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.tawze3sanawy113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else {
                        Ta.setText(R.string.salawatsanawy_A113a);
                        TC.setText(R.string.salawatsanawy_A113c);
                        TCA.setText(R.string.salawatsanawy_A113ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.last113);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }



                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        try {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.kerieeleison11);
            mediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        seekBar=view.findViewById(R.id.seekBar_A113);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromuser) {
                fprograss=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(fprograss);
            }
        });


    }






    @SuppressLint("RestrictedApi")
    public void chang_play(boolean play, boolean puse){
        FloatingActionButton Play=getView().findViewById(R.id.play_A113);
        FloatingActionButton Puse=getView().findViewById(R.id.puse_A113);

        if(puse==false&&play==true){
            Play.setVisibility(View.VISIBLE);
            Puse.setVisibility(View.INVISIBLE);
        }
        else if (puse==true&&play==false){
            Play.setVisibility(View.INVISIBLE);
            Puse.setVisibility(View.VISIBLE);
        }
    }



    private void  time (MediaPlayer media){

        finalTime = media.getDuration();
        startTime = media.getCurrentPosition();
        if (oneTimeOnly == 0) {
            seekBar.setMax((int) finalTime);
            oneTimeOnly = 1;
        }

        timeend_113.setText(String.format("%d : %d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );

        timestart_113.setText(String.format("%d : %d",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                startTime)))
        );

        seekBar.setProgress((int) startTime);
        myHandler.postDelayed(UpdateSongTime,100);

    }


    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            timestart_113.setText(String.format("%d : %d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);


        }
    };

}
