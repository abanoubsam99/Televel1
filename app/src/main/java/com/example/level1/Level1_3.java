package com.example.level1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.level1.Al7an.A111;
import com.example.level1.Al7an.A112;
import com.example.level1.Al7an.A113;
import com.example.level1.Al7an.A131;
import com.example.level1.Al7an.A132;
import com.example.level1.Al7an.A133;
import com.example.level1.Ash.Ash_3;
import com.example.level1.Coptic.Coptic_3;
import com.example.level1.Games.games;
import com.example.level1.Quizes.QuizCatalog3;
import com.example.level1.Quizes.QuizCatalogue;
import com.example.level1.Taks.Taks_3;

public class Level1_3 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_3);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Toolbar toolbar = findViewById( R.id.toolbar2 );
        toolbar.setTitle("تـي اجـيــا    Level 1 ");
        toolbar.setTitleMarginStart(50);
        setSupportActionBar( toolbar );


        android.support.v4.app.FragmentTransaction Transaction = getSupportFragmentManager().beginTransaction();
        A131 Fregment = new A131();
       Transaction.add( R.id.fram_l13, Fregment );
        Transaction.commit();

        DrawerLayout drawerLayout = findViewById( R.id.drwer_l13 );

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.open, R.string.close );
        drawerLayout.addDrawerListener( actionBarDrawerToggle );

        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById( R.id.nav_l13 );
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById( R.id.drwer_l13);
        if (drawerLayout.isDrawerOpen( GravityCompat.START )) {
            drawerLayout.closeDrawer( GravityCompat.START );
        } else {
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;



        if (itemId == R.id.t1_13)
        {  fragment=new A131();
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        } else if (itemId == R.id.t2_13) {
            fragment=new A132();
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        } else if (itemId == R.id.t3_13) {
            fragment=new A133();
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        } else if (itemId == R.id.C_13) {
            fragment=new Coptic_3();
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        } else if (itemId == R.id.A_13) {
            fragment=new Ash_3();
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        } else if(itemId==R.id.T_13){
          fragment=new Taks_3();
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        }
        else if(itemId==R.id.catalog_13){
            fragment=new catalog();
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        }
        else if(itemId==R.id.gam_13){
            intent=new Intent(this, games.class);
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        }
        else if(itemId==R.id.quiz_13){
            intent=new Intent(this, QuizCatalogue.class);
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        }
        else if(itemId==R.id.moraga_13){
            intent=new Intent(this, Morag3a.class);
            A131.mediaPlayer.stop();
            A132.mediaPlayer.stop();
            A133.mediaPlayer.stop();
        }
        else {
           intent= openfacebook("110490343647850");

        }
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace( R.id.fram_l13, fragment );
            transaction.commit();


        } else {
            startActivity( intent );
        }
        DrawerLayout drawerLayout= findViewById( R.id.drwer_l13 );
        drawerLayout.closeDrawer( GravityCompat.START );
        return true;
    }
    public  static Intent openfacebook(String id){

        try {
            return new Intent(Intent.ACTION_VIEW,Uri.parse("fb://page/"+id));

        }
        catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/"+id));

        }

    }
}

