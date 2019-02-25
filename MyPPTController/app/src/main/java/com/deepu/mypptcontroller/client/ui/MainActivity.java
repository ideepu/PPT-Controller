package com.deepu.mypptcontroller.client.ui;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deepu.mypptcontroller.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class MainActivity extends Activity {

	private EditText ipaddress;
    private WifiManager wifiManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_activity);
        wifiManager = (WifiManager)this.getSystemService(Context.WIFI_SERVICE);

		Button connect = (Button) findViewById(R.id.connect);
		ipaddress = (EditText) findViewById(R.id.ipaddress);

		connect.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String ip = ipaddress.getText().toString();
				if (MainActivity.isboolIp(ip)) {

                    boolean wifiEnabled = wifiManager.isWifiEnabled();
                    if (wifiEnabled){
                        Toast.makeText(MainActivity.this, "Wi-Fi is enabled",
                                Toast.LENGTH_LONG).show();
                    }else {
                        wifiManager.setWifiEnabled(true);
                        Toast.makeText(MainActivity.this, "Wi-Fi is enabled",
                                Toast.LENGTH_LONG).show();
                    }


					Intent intent = new Intent(MainActivity.this,
							ControlActivity.class);
					intent.putExtra("ip", ip);
					startActivity(intent);
				} else {
					Toast.makeText(MainActivity.this,
							R.string.alert_not_ip_address, Toast.LENGTH_SHORT)
							.show();
				}
			}
		});
	}

	public static boolean isboolIp(String ipAddress) {
		String ip = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
				+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
				+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
				+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		Pattern pattern = Pattern.compile(ip);
		Matcher matcher = pattern.matcher(ipAddress);
		return matcher.matches();
	}
}
