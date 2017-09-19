package com.softard.wow.uiautomatortest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;

import java.io.DataOutputStream;
import java.io.IOException;

public class AutomatorService extends Service {

    private static String SCRIPT_CMD = "am instrument -w -r -e debug false -e class com.softard.wow.uiautomatortest.xxx.Automator "
            +"com.softard.wow.uiautomatortest/android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner";


    public AutomatorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new UiautomatorThread().start();
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
}
