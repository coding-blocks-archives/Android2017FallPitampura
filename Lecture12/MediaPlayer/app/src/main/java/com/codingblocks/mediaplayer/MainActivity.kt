package com.codingblocks.mediaplayer

import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView.setVideoURI(Uri.parse(
                "android.resource://$packageName/${R.raw.samplevideo}"
        ))
        videoView.start()
        videoView.setMediaController(MediaController(this))

        val mp = MediaPlayer.create(this, R.raw.crowd)
        /*
        mp.setOnPreparedListener(new OnPreparedListener () {
            @Override
            void onPrepared (MediaPlayer p) {
                p.start()
            }
        })
         */

        btnPlay.setOnClickListener({
            Log.d("mp", "play")
            mp.start()
        })

        btnPause.setOnClickListener({ mp.pause() })
    }
}
