package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button convertButton, resetButton;
    TextView showTemp;
    EditText getTemperature;
    RadioButton c2f,f2c;
    Double x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertButton = (Button) findViewById(R.id.convertButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        showTemp = (TextView) findViewById(R.id.showTemp);
        getTemperature = (EditText) findViewById(R.id.getTemperature);
        c2f = (RadioButton) findViewById(R.id.c2f);
        f2c = (RadioButton) findViewById(R.id.f2c);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getTemperature.getText().toString().isEmpty()) {
//                    showTemp.setText("Please enter a unit to convert!");
                    Toast.makeText(getApplicationContext(), "Please enter unit to convert!", Toast.LENGTH_LONG).show();
            }
                else
                {
                    x = Double.parseDouble(String.valueOf(getTemperature.getText()));
                    if(c2f.isChecked()){
                        x = (x*9)/5+32;
                        x = Double.parseDouble(new DecimalFormat("##.##").format(x));
                        showTemp.setText(String.valueOf(x)+ " °F");
                    }
                    else if(f2c.isChecked()){
                        x= (x-32)*5/9;
                        x = Double.parseDouble(new DecimalFormat("##.##").format(x));
                        showTemp.setText(String.valueOf(x) + " °C");
                    }
                    else{
//                        showTemp.setText("Please select option!");
                        Toast.makeText(getApplicationContext(), "Please select option!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTemp.setText("0.0");
                getTemperature.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });

    }
}