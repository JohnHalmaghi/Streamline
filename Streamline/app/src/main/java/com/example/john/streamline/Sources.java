package com.example.john.streamline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Sources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        String selections = (String)intent.getSerializableExtra("Selections");
        HashMap<String, String> mediaTypeSelections = convertToStringToHashMap(selections);

        Boolean tvShows = getBoolValues(mediaTypeSelections.get("app:id/button_tv"));
        Boolean movies = getBoolValues(mediaTypeSelections.get("app:id/button_movies"));
        Boolean both = getBoolValues(mediaTypeSelections.get("app:id/button_both"));
        Log.v("tv: ", tvShows.toString());
        Log.v("movies: ", movies.toString());
        Log.v("both: ", both.toString());
    }
    protected HashMap<String,String> convertToStringToHashMap(String text){ //from https://www.tomred.net/java/hashmap-tostring-and-back-to-hashmap.html
        HashMap<String,String> data = new HashMap<String,String>();
        Pattern p = Pattern.compile("[\\{\\}\\=\\, ]++");
        String[] split = p.split(text);
        for ( int i=1; i+2 <= split.length; i+=2 ){
            data.put( split[i], split[i+1] );
        }
        return data;
    }
    private Boolean getBoolValues(String value){
        if(value.equals("true")) return true;
        else return false;
    }
    public void nextActivity(View view){
        Intent intent = new Intent(Sources.this, Results.class);
        startActivity(intent);
    }

    public void previousActivity(View view){
        Intent intent = new Intent(Sources.this, MainActivity.class);
        startActivity(intent);
    }
}
