package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import ui.MainActivity;

public class ActivityTheme extends AppCompatActivity {

    private Button themeChoise1;
    private Button themeChoise2;
    private Button themeChoise3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp = getSharedPreferences("Theme", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        int theme = sp.getInt("THEME", 0);
        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        themeChoise1 = findViewById(R.id.theme_1);
        themeChoise2 = findViewById(R.id.theme_2);
        themeChoise3 = findViewById(R.id.theme_3);

        View.OnClickListener themeClickListner = new View.OnClickListener() {

            Intent intent = new Intent(ActivityTheme.this, MainActivity.class);

            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case (R.id.theme_1): {
                        editor.putInt("THEME", R.style.Theme_Calc);
                        editor.apply();
                        setTheme(R.style.Theme_Calc);
                        startActivity(intent);
                        break;
                    }
                    case (R.id.theme_2): {
                        editor.putInt("THEME", R.style.CustomTheme);
                        editor.apply();
                        setTheme(R.style.CustomTheme);
                        startActivity(intent);
                        break;
                    }
                    case (R.id.theme_3): {
                        editor.putInt("THEME", R.style.CustomTheme_2);
                        editor.apply();
                        setTheme(R.style.CustomTheme_2);
                        startActivity(intent);
                        break;
                    }
                }
            }
        };

        themeChoise1.setOnClickListener(themeClickListner);
        themeChoise2.setOnClickListener(themeClickListner);
        themeChoise3.setOnClickListener(themeClickListner);
    }
}