package com.example.mytest;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testPlusNum(){
        PlusNum mPlusNum = new PlusNum();
        assertTrue("wrong result",mPlusNum.plus(1,2)==3);
    }

    @Test
    public void testMock(){
        PlusNum mPlusNum = mock(PlusNum.class);
        when(mPlusNum.plus(1,2)).thenReturn(3);
        assertTrue("Wrong result",mPlusNum.plus(1,2)==3);
        when(mPlusNum.plus(1,2)).thenReturn(4);
        assertTrue("Wrong result",mPlusNum.plus(1,2)==4);
    }
}