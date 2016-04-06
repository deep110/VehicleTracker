package com.lab.bus.tracker;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author DEEPANKAR
 * @since 31-03-2016.
 */
public class MapActivity extends AppCompatActivity implements SocketClient.OnMessageReceiveListener{

    SocketClient client;

    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        client = new SocketClient(this);
        new TcpTask().execute();

        mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    }

    final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String array[] = (msg.obj).toString().split(" ");

            mapFragment.setLocation(new LatLng(Double.valueOf(array[0]),Double.valueOf(array[1])));
        }
    };

    @Override
    public void messageReceived(String message) {
        Log.e("RESPONSE FROM SERVER", "" + message);
        Message msg = handler.obtainMessage();

        msg.obj = message;
        handler.sendMessage(msg);

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
