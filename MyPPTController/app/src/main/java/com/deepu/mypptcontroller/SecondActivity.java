package com.deepu.mypptcontroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.deepu.mypptcontroller.client.bluetoothconnectivity.BluetoothDevices;
import com.deepu.mypptcontroller.client.ui.MainActivity;


public class SecondActivity extends Activity {

    Button bluetoothbutton,wifibutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bluetoothbutton = (Button) findViewById(R.id.bluetoothbutton);
        wifibutton = (Button) findViewById(R.id.wifibutton);

        bluetoothbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, BluetoothDevices.class);
                startActivity(intent);
            }
        });

        wifibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
