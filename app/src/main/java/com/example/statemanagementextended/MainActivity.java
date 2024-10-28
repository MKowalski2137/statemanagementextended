package com.example.statemanagementextended;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "count";
    private static final String KEY_TEXT = "text";
    private static final String KEY_SWITCH = "switch";
    private static final String KEY_CHECKBOX = "checkbox";
    private static final String KEY_CHECKBOX_DOG = "checkbox_dog";
    private  boolean isSwitchOn;
    private CheckBox checkbox_cat;
    private CheckBox checkbox_dog;
    private TextView textViewCount;
    private TextView TextViewOption;
    private EditText editTextUser;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        TextViewOption = findViewById(R.id.TextViewOption);
        Button buttonIncrement = findViewById(R.id.button);
        Switch mySwitch = findViewById(R.id.Switch);
        CheckBox checkbox = findViewById(R.id.checkbox);
        CheckBox checkbox_dog = findViewById(R.id.checkbox_dog);
        editTextUser = findViewById(R.id.editTextUser);
        View mainLayout = findViewById(R.id.main_layout);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    mainLayout.setBackgroundColor(Color.WHITE);
                }else {
                    mainLayout.setBackgroundColor(Color.rgb(20, 19, 24));
                }
            }
        });
        updateCountText();

        if (savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_COUNT);
            String userText = savedInstanceState.getString(KEY_TEXT);
            isSwitchOn = savedInstanceState.getBoolean(KEY_SWITCH, true);
            boolean Checkbox_data = savedInstanceState.getBoolean(KEY_CHECKBOX, false);
            checkbox.setChecked(Checkbox_data);
            boolean checkboxdog_data = savedInstanceState.getBoolean(KEY_CHECKBOX_DOG, false);
            checkbox_dog.setChecked(checkboxdog_data);
        }
        updateCountText();

        checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                TextViewOption.setVisibility(View.VISIBLE);
            }else {
                TextViewOption.setVisibility((View.GONE));
            }
        });




        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                updateCountText();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }
    private void updateCountText() {
        textViewCount.setText("Ilość Kliknięć: " + count);
    }
}