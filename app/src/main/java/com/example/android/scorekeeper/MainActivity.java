package com.example.android.scorekeeper;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


public class MainActivity extends AppCompatActivity {
    private int mScore1;
    private int mScore2;
    private TextView mScoreText1;
    private TextView mScoreText2;
    static final String STATE_SCORE_1 = "Team 1 score";
    static final String STATE_SCORE_2 = "Team 2 score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mScoreText1 = findViewById(R.id.score_1);
       mScoreText2 = findViewById(R.id.score_2);
       if (savedInstanceState != null) {
           mScore1 = savedInstanceState.getInt(STATE_SCORE_1, mScore1);
           mScore2 = savedInstanceState.getInt(STATE_SCORE_2, mScore2);
           mScoreText1.setText(String.valueOf(mScore1));
           mScoreText2.setText(String.valueOf(mScore2));
       }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.night_mode){
          int nightMode = AppCompatDelegate.getDefaultNightMode();
          if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
              AppCompatDelegate.setDefaultNightMode
                      (AppCompatDelegate.MODE_NIGHT_NO);
          }
          else {
              AppCompatDelegate.setDefaultNightMode
                      (AppCompatDelegate.MODE_NIGHT_YES);
          }
          recreate();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
    int nightMode = AppCompatDelegate.getDefaultNightMode();
    if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
        menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
    }
    else {
        menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
    }
        return true;
    }
    public void decreaseScore(View view) {
        int viewId = view.getId();
        switch (viewId){
            case R.id.decreaseTeam1:

                if(mScore1 == 0){
                    mScoreText1.setText("0");
                }
                else {
                    mScore1--;
                    mScoreText1.setText(String.valueOf(mScore1));
                }
                break;
            case R.id.decreaseTeam2:

                if(mScore2 == 0){
                    mScoreText2.setText("0");
                }
                else{
                    mScore2--;
                    mScoreText2.setText(String.valueOf(mScore2));
                }

        }
    }

    public void increaseScore(View view) {
       int viewId = view.getId();
        switch (viewId){
            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}
