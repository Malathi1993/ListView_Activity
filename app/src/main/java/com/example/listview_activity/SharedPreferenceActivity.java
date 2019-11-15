package com.example.listview_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SharedPreferenceActivity extends AppCompatActivity {

    private EditText name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edit1);
        age = findViewById(R.id.edit2);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        @SuppressLint("WrongConstant") SharedPreferences sh
                = getSharedPreferences("MySharedPref",
                MODE_APPEND);

        String s1 = sh.getString("name", "");
        int a = sh.getInt("age", 0);

        name.setText(s1);
        age.setText(String.valueOf(a));
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();
        myEdit.putString("name",
                name.getText().toString());
        myEdit.putInt("age",
                Integer.parseInt(
                        age.getText().toString()));
        myEdit.commit();
    }
}