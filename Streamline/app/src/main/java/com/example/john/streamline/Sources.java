package com.example.john.streamline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
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
