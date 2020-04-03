package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";

    private Button buttonAdd;
    private Button buttonMinus;
    private Button buttonMultiple;
    private Button buttonDivide;
    private Button buttonDivide2;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMultiple = (Button) findViewById(R.id.buttonMultiple);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide2 = (Button) findViewById(R.id.buttonDivide2);

        buttonAdd.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiple.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonDivide2.setOnClickListener(this);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(EXTRA_TEXT, name);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonAdd:
                name = "Add";
                openActivity2();
                break;
            case R.id.buttonMinus:
                name = "Minus";
                openActivity2();
                break;
            case R.id.buttonMultiple:
                name = "Multiple";
                openActivity2();
                break;
            case R.id.buttonDivide:
                name = "Divide";
                openActivity2();
                break;
            case R.id.buttonDivide2:
                name = "Divide2";
                openActivity2();
                break;
        }
    }
}
