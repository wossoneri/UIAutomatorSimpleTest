//package com.softard.wow.uiautomatortest;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.test.InstrumentationRegistry;
//import android.support.test.uiautomator.UiDevice;
//import android.support.test.uiautomator.UiObject;
//import android.support.test.uiautomator.UiScrollable;
//import android.support.test.uiautomator.UiSelector;
//import android.widget.Button;
//import android.widget.ListView;
//
//import org.junit.Test;
//
//
///**
// * Created by wow on 17-9-11.
// */
//
//public class Automator {
//
//    @Test
//    public void testSettingApp() throws Exception {
//        Context context = InstrumentationRegistry.getContext();
//        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//
//        mDevice.pressHome();
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.android.settings");
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//        // find scroll view by id
//        UiScrollable scrollview = new UiScrollable(new UiSelector().className("android.support.v7.widget" +
//                ".RecyclerView").resourceId("com.android.settings:id/dashboard_container"));
//        scrollview.flingForward();
//
//        UiObject menu_system = scrollview.getChild(new UiSelector().text("System"));
//        menu_system.click();
//
//        UiScrollable content_system = new UiScrollable(new UiSelector().className("android.support.v7.widget" +
//                ".RecyclerView").resourceId("com.android.settings:id/list"));
//        UiObject phone = content_system.getChild(new UiSelector().text("About phone"));
//        phone.click();
//
//        UiObject btnBack = mDevice.findObject(new UiSelector().className("android.widget.ImageButton").description("Navigate up"));
//        btnBack.click();
//
//        mDevice.pressBack();
//        scrollview.scrollTextIntoView("Sound");
//        UiObject sound = scrollview.getChild(new UiSelector().text("Sound"));
//        sound.click();
//
//        UiObject ringtone = mDevice.findObject(new UiSelector().textContains("ringtone"));
//        ringtone.click();
//
//        UiScrollable listview = new UiScrollable(new UiSelector().className(ListView.class).resourceId("android:id/select_dialog_listview"));
//        listview.scrollTextIntoView("Playa");
//        UiObject playa = listview.getChild(new UiSelector().text("Playa"));
//        playa.click();
//        UiObject btnOk = mDevice.findObject(new UiSelector().text("OK").className(Button.class));
//        btnOk.click();
//
//
//
//
//    }
//}
