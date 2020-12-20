package com.example.purwasata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    MediaPlayer player;

    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Set!", Toast.LENGTH_LONG).show();
        player = MediaPlayer.create(context, R.raw.ring);
        player.start();
    }
}
