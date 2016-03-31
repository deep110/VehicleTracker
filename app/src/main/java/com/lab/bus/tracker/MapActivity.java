package com.lab.bus.tracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author DEEPANKAR
 * @since 31-03-2016.
 */
public class MapActivity extends AppCompatActivity implements SocketClient.OnMessageReceiveListener{

    Thread clientThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        final SocketClient client = new SocketClient(this);

        clientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                client.run();
            }
        });
        clientThread.run();
    }

    @Override
    public void messageReceived(String message) {
        Log.e("RESPONSE FROM SERVER", "S: Received Message: " + message);
    }
}
