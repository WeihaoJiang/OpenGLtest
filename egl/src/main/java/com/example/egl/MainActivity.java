package com.example.egl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {
    private GLRenderer glRenderer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SurfaceView sv = (SurfaceView)findViewById(R.id.sv_main_demo);
        glRenderer = new GLRenderer("GLRenderer");
        glRenderer.start();

        sv.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
                glRenderer.render(surfaceHolder.getSurface(),width,height);  // 这里偷懒直接在主线程渲染了，大家切莫效仿
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        glRenderer.release();
        glRenderer = null;
        super.onDestroy();
    }
}
