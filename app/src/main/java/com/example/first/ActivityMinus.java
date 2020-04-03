package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ActivityMinus extends AppCompatActivity {
    TextView textViewOp;
    EditText editTextResult;
    Button buttonNext;
    int numberOne;
    int numberTwo;
    int counter;
    int range;
    int gameCounter;
    final Random myRandom = new Random();

    public void newGame() {
        gameCounter++;
        editTextResult.setText(null);

        numberOne = myRandom.nextInt(range);
        numberTwo = myRandom.nextInt(numberOne);

        textViewOp.setText(numberOne + " - " + numberTwo + " = ");
    }

    public void checkSum() {
        if (Integer.parseInt(editTextResult.getText().toString()) == numberOne - numberTwo) {
            counter++;
        }
        newGame();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minus);

        Intent intent = getIntent();
        range = intent.getIntExtra(Activity2.EXTRA_NUMBER, 0);

        textViewOp = (TextView) findViewById(R.id.textViewOperation);
        editTextResult = (EditText) findViewById(R.id.editTextResult);
        buttonNext = (Button)findViewById(R.id.buttonNext);

        counter = 0;
        gameCounter = 0;
        newGame();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(gameCounter == 10){
                    if (Integer.parseInt(editTextResult.getText().toString()) == numberOne - numberTwo) {
                        counter++;
                    }
                    openWin();
                }
                else checkSum();
            }
        });

    }

    public void openWin() {
        Intent intent = new Intent(this, ActivityWin.class);
        startActivity(intent);
    }
}
