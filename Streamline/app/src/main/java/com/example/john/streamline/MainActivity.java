package com.example.john.streamline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    HashMap<Button, Boolean> mediaTypeSelections = new HashMap<Button, Boolean>();
    Button tvShows;
    Button movies;
    Button both;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tvShows = (Button) findViewById(R.id.button_tv);
        tvShows.setOnClickListener(this);
        movies = (Button) findViewById(R.id.button_movies);
        movies.setOnClickListener(this);
        both = (Button) findViewById(R.id.button_both);
        both.setOnClickListener(this);
        mediaTypeSelections.put(tvShows, false);
        mediaTypeSelections.put(movies, false);
        mediaTypeSelections.put(both, false);
    }

    private boolean getSelectionState(Button mediaType) {
        return mediaTypeSelections.get(mediaType);
    }

    private void switchSelectionState(Button mediaType) {
        if (mediaTypeSelections.get(mediaType)) {
            mediaTypeSelections.put(mediaType, false);
            mediaType.setBackgroundColor(getResources().getColor(R.color.white));
        } else {
            mediaTypeSelections.put(mediaType, true);
            mediaType.setBackgroundColor(getResources().getColor(R.color.selected));
        }
    }

    public void buttonPress(Button pressedButton) {
        switchSelectionState(pressedButton);
    }


    public void nextActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Sources.class);
        String Selections = mediaTypeSelections.toString();
        intent.putExtra("Selections", Selections);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_tv:
                    switchSelectionState(tvShows);
                    break;
                case R.id.button_movies:
                    switchSelectionState(movies);
                    break;
                case R.id.button_both:
                    switchSelectionState(both);
                    break;
            }
    }
}
