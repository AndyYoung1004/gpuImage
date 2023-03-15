package com.example.gpuimagetest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.example.gpuimagetest.filter.GPUImage;
import com.example.gpuimagetest.filter.GPUImageExposureFilter;

public class MainActivity extends AppCompatActivity {
    private GLSurfaceView glSurfaceView;
    private GPUImage gpuImage;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        glSurfaceView = findViewById(R.id.glSfView);
        gpuImage = new GPUImage(getApplicationContext());
        gpuImage.setGLSurfaceView(glSurfaceView);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thelittleprince);
        gpuImage.setImage(bitmap);
        gpuImage.setFilter(new GPUImageExposureFilter(0.5F));
    }
}