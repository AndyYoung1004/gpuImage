package com.example.gpuimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kiki);
        bitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false);
        findViewById(R.id.gpu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPUImage gpuImage = new GPUImage(getApplicationContext());
                GPUImageFilter filter = new GPUImageContrastFilter(0.5f);
                gpuImage.setImage(bitmap);
                gpuImage.setFilter(filter);
                Bitmap filterBitmap = gpuImage.getBitmapWithFilterApplied();
                imageView.setImageBitmap(filterBitmap);
            }
        });
    }
}