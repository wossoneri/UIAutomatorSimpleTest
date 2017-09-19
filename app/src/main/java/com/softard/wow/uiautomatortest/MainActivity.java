package com.softard.wow.uiautomatortest;

import android.content.Intent;
import android.os.Bundle;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.DataOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // Command for Test
    static final String COMMAND = "am instrument -w -r   -e debug false -e class com.softard.wow.uiautomatortest" +
            ".Automator#testSettingApp com.softard.wow.uiautomatortest.test/android.support.test.runner" +
            ".AndroidJUnitRunner";
    Button button;

    private static String SCRIPT_CMD = "am instrument -w -r   -e debug false -e class com.softard.wow.uiautomatortest.xxx.Automator "
            +"com.softard.wow.uiautomatortest/android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("WOW", "Created");
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new UiautomatorThread().start();
                startService(new Intent(MainActivity.this, AutomatorService.class));
            }
        });
    }

    class UiautomatorThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                Process su = Runtime.getRuntime().exec("su");
                DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

                outputStream.writeBytes(SCRIPT_CMD + "\n");
                outputStream.flush();

                outputStream.writeBytes("exit\n");
                outputStream.flush();
                su.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("WOW", "Resumed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("WOW", "Started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("WOW", "Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("WOW", "Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("WOW", "Destoried");
    }
}
