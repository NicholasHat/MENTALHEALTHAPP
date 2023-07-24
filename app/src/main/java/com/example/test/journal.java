package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class journal extends NavigationActivity {

    public static final String FILE_NAME = "journal.txt";

    EditText journalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        setMainClicker();
        setNewDayClicker();
        setActivitiesClicker();
        setDailyClicker();
        setButtonColor(R.id.activities);

        journalText = findViewById(R.id.journalText);

        load();
    }

    @Override
    protected void onStop() {
        super.onStop();
        save(journalText.getText());

    }

    private void save(Editable t) {
        String s = journalText.getText().toString();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getFilesDir() + FILE_NAME, true));
            PrintWriter w = new PrintWriter(getFilesDir() + FILE_NAME);
            w.print("");
            writer.close();
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        List<String> text;
        String textasstring = null;
        ArrayList<String> load = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFilesDir() + FILE_NAME));
            text = Files.readAllLines(Paths.get(getFilesDir() + FILE_NAME));
            Toast.makeText(journalText.getContext(), text.size(), Toast.LENGTH_LONG).show();
            //journalText.setText(text.get(0));
            //line 72 is problem
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formating(List<String> t) {
        String value = t.get(0);
        t.remove(0);
        if(t.size() > 1) {
            return value + formating(t);
        }
        else
            return "";
    }
}