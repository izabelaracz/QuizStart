package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    RadioGroup radioGroupRange;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton radioButtonRange;
    TextView textView;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

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
            }
        });
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
