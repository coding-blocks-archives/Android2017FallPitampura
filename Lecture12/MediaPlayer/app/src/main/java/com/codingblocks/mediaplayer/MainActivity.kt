package com.codingblocks.mediaplayer

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mp = MediaPlayer.create(this, R.raw.crowd)

        btnPlay.setOnClickListener({
            Log.d("mp", "play")
            mp.start()
        })

        btnPause.setOnClickListener({ mp.pause() })
    }
}
