package com.example.mytest;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import org.junit.Test;

import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;


public class UiaTest {
    public UiDevice mDevice;
    public Context context;
    public final String PACKAGE_NAME = "com.example.mytest";



    @Test
    public void uiaTestAssert() throws InterruptedException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)),10000);
        mDevice.findObject(By.res(PACKAGE_NAME,"textView")).setText("1");
        sleep(500);
        mDevice.findObject(By.res("com.example.mytest:id/textView3")).setText("2");
        sleep(500);
        mDevice.findObject(By.text("=")).click();
        sleep(500);
        String result = mDevice.findObject(By.descContains("result")).getText();
        assertTrue("Wrong result",result.equals("3"));
    }

    @Test
    public void uiaTestAssertNoItem() throws InterruptedException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)),10000);
        mDevice.findObject(By.res(PACKAGE_NAME,"textView5")).setText("1");
    }

    @Test
    public void uiaTestAssertNoItem2() throws InterruptedException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)),10000);
        if (mDevice.hasObject(By.res(PACKAGE_NAME,"textView5"))==true){
            mDevice.findObject(By.res(PACKAGE_NAME,"textView5")).setText("1");
        }else {
            assertTrue("not fount res : "+PACKAGE_NAME+"/textView5",false);
        }
    }
}
