package com.mydomain.myapplication.UiControl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.mydomain.myapplication.R;

public class UiActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    EditText editText;
    CheckBox ch1, ch2;
    ToggleButton tg1, tg2;
    RadioGroup radioSexGroup;
    RadioButton radioSexButton;
    TimePicker timePicker;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        textView = findViewById(R.id.textView1);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.edittext);

        ch1 = (CheckBox) findViewById(R.id.checkBox1);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        tg1 = (ToggleButton) findViewById(R.id.toggleButton);
        tg2 = (ToggleButton) findViewById(R.id.toggleButton2);

        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup);

        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        aSwitch = (Switch) findViewById(R.id.switch1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                radioSexButton = (RadioButton) findViewById(selectedId);
                textView.setText(editText.getText().toString());
                StringBuffer result = new StringBuffer();
                result.append("Teksti : ").append(editText.getText().toString());
                result.append("\nLeksioni : ").append(ch1.isChecked());
                result.append("\nAndroid: ").append(ch2.isChecked());
                result.append("\nJu keni klikuar butonin e pare ").append(tg1.getText());
                result.append("\nJu keni klikuar butonin e dyte  ").append(tg2.getText());
                result.append("\nGjinia eshte ").append(radioSexButton.getText());
                result.append("\nSwichi eshte ").append(aSwitch.isChecked());
                result.append("\nOra eshte ").append(timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute());

                textView.setText(result.toString());
            }
        });

    }
}
