package com.example.diana.internshipexercises;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.diana.internshipexercises.util.DownloaderUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorActivity extends AppCompatActivity {

    private ImageView imageView;
    private Runnable downloadRunnable = new DownloadRunnable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executor);

        imageView = findViewById(R.id.imageViewExecutor);

        getImageUsingExecutor();
    }

    private void getImageUsingExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(downloadRunnable);
    }

    class DownloadRunnable implements Runnable{

        @Override
        public void run() {
            Bitmap bitmap = DownloaderUtil.INSTANCE.downloadImage();
            runOnUiThread(()-> imageView.setImageBitmap(bitmap));
        }
    }
}
