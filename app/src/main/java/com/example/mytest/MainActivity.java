package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public EditText a;
    public EditText b;
    public TextView result;
    public Button equalBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.textView);
        b = findViewById(R.id.textView3);
        equalBtn = findViewById(R.id.button);
        result = findViewById(R.id.textView4);
        equalBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        PlusNum mPlus = new PlusNum();
        int numA = Integer.valueOf(String.valueOf(a.getText()));
        int numB = Integer.valueOf(String.valueOf(b.getText()));
        int numC = mPlus.plus(numA,numB);
        result.setText(String.valueOf(numC));
    }
}
