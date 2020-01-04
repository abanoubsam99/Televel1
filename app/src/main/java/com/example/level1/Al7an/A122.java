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
public class A122 extends Fragment {
    private AdView mAdView;

    boolean play=true;
    boolean puse=false;

    public static ScrollView scrollView;

    boolean music=true;

    SeekBar seekBar;
    int fprograss;
    public static   MediaPlayer mediaPlayer=new MediaPlayer();

    public static double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private TextView timeend_122,timestart_122;
    public static int oneTimeOnly = 0;

    public A122() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a122, container, false);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        scrollView=view.findViewById(R.id.scrollView_A122);


        MobileAds.initialize(getContext(),
                "ca-app-pub-9066719717930706~9380288818");

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        Typeface typeface=Typeface.createFromAsset( getActivity().getAssets(),"Avva_Shenouda.ttf" );
        TextView textView=view.findViewById( R.id.COPTIC_A122 );
        textView.setTypeface( typeface );

        chang_play(play,puse);



        FloatingActionButton play=view.findViewById(R.id.play_A122);
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

        FloatingActionButton puse=view.findViewById(R.id.puse_A122);
        puse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chang_play(true,false);
                mediaPlayer.pause();
            }
        });




        final TextView Ta=view.findViewById(R.id.ARAB_A122);
        final TextView TC=view.findViewById(R.id.COPTIC_A122);
        final TextView TCA=view.findViewById(R.id.Ca_A122);
        timestart_122 =view.findViewById(R.id.timestart_122);
        timeend_122 =view.findViewById(R.id.timeend_122);
        Spinner spinner=view.findViewById(R.id.spinner_A122);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (view != null) {


                    if (i == 0) {
                        Ta.setText(R.string.hetens_A122a);
                        TC.setText(R.string.hetens_A122c);
                        TCA.setText(R.string.hetens_A122ca);

                        mediaPlayer.stop();
                        chang_play(true,false);
                        scrollView.smoothScrollTo(0, 0);

                        music=true;

                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.hetensaleb122);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);



                    } else if (i == 1) {
                        Ta.setText(R.string.mrdengels_A122a);
                        TC.setText(R.string.mrdengels_A122c);
                        TCA.setText(R.string.mrdengels_A122ca);
                        music=true;
                        mediaPlayer.stop();
                        chang_play(true,false);
                        scrollView.smoothScrollTo(0, 0);

                   mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdengeldawra122);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    } else if (i == 2) {
                        Ta.setText(R.string.mrdengelsom1_A122a);
                        TC.setText(R.string.mrdengelsom1_A122c);
                        TCA.setText(R.string.mrdengelsom1_A122ca);
                        scrollView.smoothScrollTo(0, 0);

                        music=true;
                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.abana122);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);

                    }
                    else if (i == 3) {
                        Ta.setText(R.string.mrdengelsom2_A122a);
                        TC.setText(R.string.mrdengelsom2_A122c);
                        TCA.setText(R.string.mrdengelsom2_A122ca);
                        music=true;
                        mediaPlayer.stop();
                        chang_play(true,false);
                        scrollView.smoothScrollTo(0, 0);

                      mediaPlayer = MediaPlayer.create(getActivity(), R.raw.teherene122);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }
                    else if (i == 4) {
                        Ta.setText(R.string.mrdengelsh_A122a);
                        TC.setText("");
                        TCA.setText("");
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                        music=true;
                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdanagelsha3anen122);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }
                    else if (i == 5) {
                        Ta.setText(R.string.lkegkoa_A122a);
                        TC.setText(R.string.lkegkoa_A122c);
                        TCA.setText(R.string.lkegkoa_A122ca);
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                        music=true;
                      mediaPlayer = MediaPlayer.create(getActivity(), R.raw.thoktategom122);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }
                    else if (i == 6) {
                        Ta.setText(R.string.ebooro_A122a);
                        TC.setText(R.string.ebooro_A122c);
                        TCA.setText(R.string.ebooro_A122ca);
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                        music=true;
                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.eboroalam122);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }
                    else if (i == 7) {
                        Ta.setText(R.string.heten3ed_A122a);
                        TC.setText(R.string.heten3ed_A122c);
                        TCA.setText(R.string.heten3ed_A122ca);
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                        music=true;

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.hetenkeama122);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }
                    else if (i == 8) {
                        Ta.setText(R.string.mrdmazmor3ed_A122a);
                        TC.setText(R.string.mrdmazmor3ed_A122c);
                        TCA.setText(R.string.mrdmazmor3ed_A122ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

              mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdmazmor122);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }else {
                        Ta.setText(R.string.mrdengel3ed_A122a);
                        TC.setText(R.string.mrdengel3ed_A122c);
                        TCA.setText(R.string.mrdengel3ed_A122ca);
                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdengelkeama122);
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
        seekBar=view.findViewById(R.id.seekBar_A122);

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
        FloatingActionButton Play=getView().findViewById(R.id.play_A122);
        FloatingActionButton Puse=getView().findViewById(R.id.puse_A122);

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

        timeend_122.setText(String.format("%d : %d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );

        timestart_122.setText(String.format("%d : %d",
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
            timestart_122.setText(String.format("%d : %d",
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
