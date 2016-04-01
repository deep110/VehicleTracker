package com.lab.bus.tracker;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author DEEPANKAR
 * @since 31-03-2016.
 */
public class MapActivity extends AppCompatActivity implements SocketClient.OnMessageReceiveListener{

    SocketClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        client = new SocketClient(this);

        new TcpTask().execute();
    }

    @Override
    public void messageReceived(String message) {
        Log.e("RESPONSE FROM SERVER", "" + message);
    }

    private class TcpTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {
            client.run();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

        }

    }
}
