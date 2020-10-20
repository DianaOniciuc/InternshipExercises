package com.example.diana.internshipexercises;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG =MainActivity.class.getSimpleName();
    private static final String BUNDLE_COUNTER = "counter" ;

    private int incrementValue=0;

    private TextView incrementTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: Happy to be born!");
        if(savedInstanceState != null){
            incrementValue=savedInstanceState.getInt(BUNDLE_COUNTER, 0);
        }
        initView();
    }

    private void initView(){
        incrementTV=findViewById(R.id.counter_value_tv);
        Button incrementBtn = findViewById(R.id.increment_bt);

        incrementTV.setText(String.valueOf(incrementValue));
        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    incrementValue++;
                incrementTV.setText(String.valueOf(incrementValue));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart: I exist, but you can't see me");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"OnResume: Final changes to the UI and I am ready to interact");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"OnPause: You can see me, but I don't want to interact with you");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"OnStop: Not visible anymore, I need a break");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"OnDestroy: Bye Bye!");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_COUNTER, incrementValue);
    }

    /*@Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        incrementTV.setText(savedInstanceState.getString("label_key"));
    }*/

    //override onBackPressed() for custom behavior
}
