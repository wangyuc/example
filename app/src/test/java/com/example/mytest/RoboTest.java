package com.example.mytest;


import android.widget.EditText;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.w3c.dom.Text;


import static junit.framework.TestCase.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class RoboTest {

    @Test
    public void testRobo() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        EditText textView = activity.findViewById(R.id.textView);
        textView.setText("1");
        EditText textView3 = activity.findViewById(R.id.textView3);
        textView3.setText("2");
        activity.findViewById(R.id.button).performClick();
        TextView textView4 = activity.findViewById(R.id.textView4);
        assertTrue("result is wrong",textView4.getText().equals("3"));
    }
}
