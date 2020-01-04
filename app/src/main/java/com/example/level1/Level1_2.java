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
import com.example.level1.Al7an.A121;
import com.example.level1.Al7an.A122;
import com.example.level1.Al7an.A123;
import com.example.level1.Ash.Aah_2;
import com.example.level1.Coptic.Cootic_2;
import com.example.level1.Games.games;
import com.example.level1.Quizes.QuizCatalog2;
import com.example.level1.Quizes.QuizCatalogue;
import com.example.level1.Taks.Taks_2;

public class Level1_2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_2);

        Toolbar toolbar = findViewById( R.id.toolbar2);
        toolbar.setTitle("تـي اجـيــا    Level 1 ");
        toolbar.setTitleMarginStart(50);
        setSupportActionBar( toolbar );
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        android.support.v4.app.FragmentTransaction Transaction = getSupportFragmentManager().beginTransaction();
        A121 Fregment = new A121();
        Transaction.add( R.id.fram_l12, Fregment );
        Transaction.commit();

        DrawerLayout drawerLayout = findViewById( R.id.drwer_l12 );

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.open, R.string.close );
        drawerLayout.addDrawerListener( actionBarDrawerToggle );

        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById( R.id.nav_l12 );
        navigationView.setNavigationItemSelectedListener(this);



    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById( R.id.drwer_l12);
        if (drawerLayout.isDrawerOpen( GravityCompat.START )) {
            drawerLayout.closeDrawer( GravityCompat.START );
        } else {
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;



        if (itemId == R.id.t1_12)
        {   fragment=new A121();
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();

        } else if (itemId == R.id.t2_12) {
            fragment=new A122();
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();
        } else if (itemId == R.id.t3_12) {
            fragment=new A123();
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();
        } else if (itemId == R.id.C_12) {
            fragment=new Cootic_2();
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();

        } else if (itemId == R.id.A_12) {
           fragment=new Aah_2();
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();
        } else  if(itemId==R.id.T_12){
          fragment=new Taks_2();
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();
        }
        else  if(itemId==R.id.catalog_12){
            fragment=new catalog();
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();
        }
        else  if(itemId==R.id.gam_12){
            intent=new Intent(this, games.class);
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();
        }
        else  if(itemId==R.id.quiz_12){
            intent=new Intent(this, QuizCatalogue.class);
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();
        }
        else if(itemId==R.id.moraga_12){
            intent=new Intent(this, Morag3a.class);
            A121.mediaPlayer.stop();
            A122.mediaPlayer.stop();
            A123.mediaPlayer.stop();
        }
        else {
         intent=   openfacebook("110490343647850");

        }
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace( R.id.fram_l12, fragment );
            transaction.commit();


        } else {
            startActivity( intent );
        }
        DrawerLayout drawerLayout= findViewById( R.id.drwer_l12 );
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
