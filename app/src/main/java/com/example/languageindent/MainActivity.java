package com.example.languageindent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spinner, spinnerIndent;
    Button okBtn, okBtnIndent;
    Locale locale;
    Configuration config;

    private static int currentThemeRes = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (currentThemeRes != -1) {
            setTheme(currentThemeRes);
        }
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        spinner = findViewById(R.id.spinner);
        spinnerIndent = findViewById(R.id.spinnerIndent);
        okBtnIndent = findViewById(R.id.okBtn2);
        okBtnIndent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinnerIndent.getSelectedItem().toString().equals("Крупная")){
                    currentThemeRes = R.style.Indent1;
                    recreate();
                }else if(spinnerIndent.getSelectedItem().toString().equals("Средняя")){
                   currentThemeRes = R.style.Indent2;
                   recreate();
                }else if(spinnerIndent.getSelectedItem().toString().equals("Мелкая")){
                    currentThemeRes = R.style.Indent3;
                    recreate();
                }

            }
        });

        okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItem().toString().equals("English")) {
                    locale = new Locale("en");
                    config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }else {
                    locale = new Locale("ru");
                    config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }

            }
        });
    }
}