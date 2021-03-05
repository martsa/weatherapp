package com.serv24.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        Intent intent = null;
        intent = YouTubeStandalonePlayer.createPlaylistIntent(this, VideoActivity.GOOGLE_API_KEY, VideoActivity.YOUTUBE_PLAYLIST, 0, 0, true, true);

        if(intent != null) {
            startActivity(intent);
        }
    }
}