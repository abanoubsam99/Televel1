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
import com.example.level1.Ash.Ash_1;
import com.example.level1.Coptic.Coptic_1;
import com.example.level1.Games.games;
import com.example.level1.Quizes.QuizCatalog1;
import com.example.level1.Quizes.QuizCatalogue;
import com.example.level1.Taks.Taks_1;

public class Level1_1 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_1);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = findViewById( R.id.toolbar2 );
        toolbar.setTitle("تـي اجـيــا    Level 1 ");
        toolbar.setTitleMarginStart(50);
        setTitleColor(Color.WHITE);

        setSupportActionBar( toolbar );


        android.support.v4.app.FragmentTransaction Transaction = getSupportFragmentManager().beginTransaction();
        A111 Fregment = new A111();
        Transaction.add( R.id.fram_l11, Fregment );
        Transaction.commit();

        DrawerLayout drawerLayout = findViewById( R.id.drwer_l11 );

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.open, R.string.close );
        drawerLayout.addDrawerListener( actionBarDrawerToggle );

        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById( R.id.nav_l11);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById( R.id.drwer_l11);
        if (drawerLayout.isDrawerOpen( GravityCompat.START )) {
            drawerLayout.closeDrawer( GravityCompat.START );

        } else {
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
            super.onBackPressed();
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;



        if (itemId == R.id.t1_11)
        {   fragment=new A111();
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        } else if (itemId == R.id.t2_11) {
            fragment=new A112();
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        } else if (itemId == R.id.t3_11) {
            fragment=new A113();
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        } else if (itemId == R.id.C_11) {
            fragment=new Coptic_1();
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        } else if (itemId == R.id.A_11) {
            fragment=new Ash_1();
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        } else if(itemId==R.id.T_11){
           fragment=new Taks_1();
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        }
        else if(itemId==R.id.catalog_11){
            fragment=new catalog();
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        }
        else if(itemId==R.id.gam_11){
            intent=new Intent(this, games.class);
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        }
        else if(itemId==R.id.quiz_11){
            intent=new Intent(this, QuizCatalogue.class);
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        }
        else if(itemId==R.id.moraga_11){
            intent=new Intent(this, Morag3a.class);
            A111.mediaPlayer.stop();
            A112.mediaPlayer.stop();
            A113.mediaPlayer.stop();
        }
        else {
          intent=  openfacebook("110490343647850");

        }

        if (fragment != null) {
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace( R.id.fram_l11, fragment );
            transaction.commit();


        } else {
            startActivity( intent );
        }
        DrawerLayout drawerLayout= findViewById( R.id.drwer_l11 );
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
