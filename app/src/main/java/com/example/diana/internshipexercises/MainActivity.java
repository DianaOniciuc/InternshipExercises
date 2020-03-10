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

    private int incrementValue=0;

    private TextView incrementTV;
    private Button incrementBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: Happy to be born!");
        if(savedInstanceState != null){
            incrementValue=Integer.parseInt(savedInstanceState.getString("label_key"));
        }
        initView();
    }

    private void initView(){
        incrementTV=findViewById(R.id.counter_value_tv);
        incrementBtn=findViewById(R.id.increment_bt);

        incrementTV.setText(incrementValue+"");
        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    incrementValue++;
                incrementTV.setText(incrementValue+ "");
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
        Log.d(TAG,"OnResume: Preparing");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"OnPause: You can see me");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"OnStop: Packing up");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"OnDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("label_key", incrementTV.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        incrementTV.setText(savedInstanceState.getString("label_key"));
    }
}
