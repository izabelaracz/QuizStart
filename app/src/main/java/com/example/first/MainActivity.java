package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAdd;
    private Button buttonMinus;
    private Button buttonMultiple;
    private Button buttonDivide;
    private Button buttonDivide2;
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
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonAdd:
                openActivity2();
                break;
            case R.id.buttonMinus:
                Toast.makeText(this, "Button - clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonMultiple:
                Toast.makeText(this, "Button * clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDivide:
                Toast.makeText(this, "Button / clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDivide2:
                Toast.makeText(this, "Button /r clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
