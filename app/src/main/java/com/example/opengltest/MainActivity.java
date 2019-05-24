package com.example.opengltest;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GLSurfaceView demoGlv = findViewById(R.id.glv_main_demo);
        demoGlv.setEGLContextClientVersion(2);
        demoGlv.setRenderer(new MyRenderer());
        demoGlv.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }
}
