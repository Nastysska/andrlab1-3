package com.example.lab1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements InputFragment.OnDataSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Завантажуємо InputFragment у верхній контейнер
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.input_container, new InputFragment())
                    .commit();
        }
    }

    @Override
    public void onDataSend(String data) {
        // Додаємо/оновлюємо ResultFragment у нижньому контейнері
        ResultFragment fragment = ResultFragment.newInstance(data);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.result_container, fragment)
                .commit();
    }
}