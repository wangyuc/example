package com.example.mytest;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EspTest {
    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testEsp() {
        onView(withId(R.id.textView)).perform(replaceText("1"));
        onView(withResourceName("textView3")).perform(replaceText("2"));
        onView(withText("=")).perform(click());
        onView(withContentDescription("result")).check(matches(withText("4")));
    }

    @Test
    public void testEspAssert() {
        onView(withId(R.id.textView)).perform(replaceText("1"));
        onView(withResourceName("textView3")).perform(replaceText("2"));
        onView(withText("=")).perform(click());
        String result = getText(withContentDescription("result"));
        assertTrue("Wrong result",result.equals("4"));
    }

    @Test
    public void testEspUia() {
        onView(withId(R.id.textView)).perform(replaceText("1"));
        onView(withResourceName("textView3")).perform(replaceText("2"));
        onView(withText("=")).perform(click());
        String result = getText(withContentDescription("result"));
        assertTrue("Wrong result",result.equals("4"));
    }

    @Test
    public void testPlusNum(){
        PlusNum mPlusNum = new PlusNum();
        assertTrue("wrong result",mPlusNum.plus(1,2)==3);
    }



    public String getText(final Matcher<View> matcher) {
        final String[] text = {null};
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }
            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }
            @Override
            public void perform(UiController uiController, View view) {
                TextView textView = (TextView)view;
                text[0] = textView.getText().toString();
            }
        });
        return text[0];
    }
}
