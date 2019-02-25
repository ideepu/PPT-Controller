package com.deepu.mypptcontroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import com.deepu.mypptcontroller.client.ui.MainActivity;


public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // TODO: Your application init goes here.
                Intent mInHome = new Intent(FirstActivity.this, SecondActivity.class);
                FirstActivity.this.startActivity(mInHome);
                FirstActivity.this.finish();
            }
        }, 2000);
    }

}
