package com.example.pokemonteam;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static String CHANNEL_1_ID = "pokemonTeamGeneratedChannel";
    public static String CHANNEL_2_ID = "channel2";


    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "pokemonTeamGeneratedChannel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("Hello Pokemon");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "pokemonTeamGeneratedChannel",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel1.setDescription("This is channel 2");


            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }

}
