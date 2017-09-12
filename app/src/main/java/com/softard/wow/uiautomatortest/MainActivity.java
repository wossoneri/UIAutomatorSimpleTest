package com.softard.wow.uiautomatortest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.DataOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static final String COMMAND = "am instrument -w -r   -e debug false -e class com.softard.wow.uiautomatortest" +
            ".Automator#testSettingApp com.softard.wow.uiautomatortest.test/android.support.test.runner" +
            ".AndroidJUnitRunner";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new UiautomatorThread().start();
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

                outputStream.writeBytes(COMMAND + "\n");
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
}
