package com.example.convertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        EditText d =findViewById(R.id.sd);
        EditText d1 =findViewById(R.id.sd2);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.temp, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        Button b1 = findViewById(R.id.button);
       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double p,n = Double.parseDouble(d.getText().toString());
                    p = convert(n);
                    d1.setText(String.format("%.3f",p));

            }
            private double convert(double n) {
                String i = spinner.getSelectedItem().toString();
                String j = spinner1.getSelectedItem().toString();
                if (i .equalsIgnoreCase("Celsius")) {
                    if (j .equalsIgnoreCase("Fahrenheit")) {
                        return (n * 1.8) + 32;
                    }
                    if (j .equalsIgnoreCase("Kelvin")) {
                        return n + 273;

                    }
                } else if (i .equalsIgnoreCase("Fahrenheit")) {
                    if (j .equalsIgnoreCase("Celsius")) {
                        return ((n - 32) * 5) / 9;
                    }
                    if (j .equalsIgnoreCase("Kelvin")) {
                        return (((n - 32) * 5) / 9) + 273;
                    }
                } else if (i .equalsIgnoreCase("Kelvin")) {
                    if (j .equalsIgnoreCase("Celsius")) {
                        return n - 273;
                    }
                    if (j .equalsIgnoreCase("Fahrenheit")) {
                        double l = ((n - 273) * (1.8)) + 32;
                        return l;
                    }
                } else
                    return n;
                return n;



            }

       });

    }
}