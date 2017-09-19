package com.example.mohammed.vvplayer;

import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback,MediaPlayer.OnPreparedListener, MediaPlayer.OnDrmPreparedListener {
 private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
            private SurfaceHolder msSurfaceHolder;
    private static final String videopath="https://youtu.be/cuEbh_TiTew";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView =(SurfaceView)findViewById(R.id.firstSurface);
       msSurfaceHolder=surfaceView.getHolder();
        msSurfaceHolder.addCallback(MainActivity.this);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setDisplay(surfaceHolder);
        try{

            mediaPlayer.setDataSource(videopath);
            mediaPlayer.prepare();
            mediaPlayer.setOnDrmPreparedListener(MainActivity.this);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer= null;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer= null;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

mediaPlayer.start();
    }

    @Override
    public void onDrmPrepared(MediaPlayer mediaPlayer, int i) {

    }
}
