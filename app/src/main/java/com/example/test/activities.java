package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activities extends NavigationActivity {
    private Button yoga, journal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        setMainClicker();
        setNewDayClicker();
        setActivitiesClicker();
        setDailyClicker();
        setButtonColor(R.id.activities);


        journal = findViewById(R.id.problemButton);
        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJournal();
            }
        });

        yoga = findViewById(R.id.yogaButton);
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYoga();
            }
        });

    }

    private void openJournal() {
        Intent I = new Intent(this, journal.class);
        startActivity(I);
    }

    private void openYoga() {
        Intent I = new Intent(this, yogaexercise.class);
        startActivity(I);
    }
}