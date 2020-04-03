package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    //public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";

    RadioGroup radioGroupRange;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton radioButtonRange;
    TextView textView;
    TextView textView2;
    TextView textView3;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroupRange = findViewById(R.id.radioGroupRange);
        textView = findViewById(R.id.text_view_selected);
        textView2 = findViewById(R.id.text_view_selected2);
        textView3 = findViewById(R.id.text_view_selected3);

        Button buttonApply = findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                int radioIdRange = radioGroupRange.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);
                radioButtonRange = findViewById(radioIdRange);

                textView.setText("Wybrałeś: " + radioButton.getText() + " i " + radioButtonRange.getText());
                openActivity();
            }
        });
    }

    public void openActivity() {
        int radioId = radioGroup.getCheckedRadioButtonId();
        int radioIdRange = radioGroupRange.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        radioButtonRange = findViewById(radioIdRange);
        int range = 0;
        switch(radioButtonRange.getText().toString()) {
            case "0 - 10":
                range = 10;
                break;
            case "0 - 20":
                range = 20;
                break;
            case "0 - 100":
                range = 100;
                break;
            case "0 - 1000":
                range = 1000;
                break;
        }

        if(radioButton.getText().length() == 10) {
            switch(name){
                case "Add":
                    Intent intent = new Intent(this, ActivityAdd.class);
                    intent.putExtra(EXTRA_NUMBER, range);
                    startActivity(intent);
                    break;
                case "Minus":
                    Intent intent2 = new Intent(this, ActivityMinus.class);
                    intent2.putExtra(EXTRA_NUMBER, range);
                    startActivity(intent2);
                    break;
                case "Multiple":
                    Intent intent3 = new Intent(this, ActivityMultiple.class);
                    intent3.putExtra(EXTRA_NUMBER, range);
                    startActivity(intent3);
                    break;
                case "Divide":
                    Intent intent4 = new Intent(this, ActivityDivide.class);
                    intent4.putExtra(EXTRA_NUMBER, range);
                    startActivity(intent4);
                    break;
                case "Divide2":
                    Intent intent5 = new Intent(this, ActivityDivide2.class);
                    intent5.putExtra(EXTRA_NUMBER, range);
                    startActivity(intent5);
                    break;
            }


        }
        //else {
            //Intent intent = new Intent(this, ActivityMinusKarty.class);
            //intent.putExtra(EXTRA_TEXT, id);
            //intent.putExtra(EXTRA_NUMBER, range);
            //startActivity(intent);
        //}

    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(),
                Toast.LENGTH_SHORT).show();
    }

    public void checkButtonRange(View v) {
        int radioIdRange = radioGroupRange.getCheckedRadioButtonId();

        radioButtonRange = findViewById(radioIdRange);

        Toast.makeText(this, "Selected Radio Button: " + radioButtonRange.getText(),
                Toast.LENGTH_SHORT).show();
    }
}
