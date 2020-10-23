package com.example.diana.internshipexercises;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.diana.internshipexercises.util.DownloaderUtil;

public class ThreadActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        imageView = findViewById(R.id.imageView);
        getImageUsingThread();

    }

    private void getImageUsingThread() {
        new Thread(() -> {
            final Bitmap bitmap = DownloaderUtil.INSTANCE.downloadImage();
            imageView.post(() -> imageView.setImageBitmap(bitmap));
        }).start();

    }
}
