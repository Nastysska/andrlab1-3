package com.example.lab1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.IOException;

public class StorageActivity extends AppCompatActivity {

    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        tvData = findViewById(R.id.tvData);

        loadData();
    }

    private void loadData() {
        try {
            FileInputStream fis = openFileInput("data.txt");
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fis.close();

            String text = new String(bytes);

            if (text.isEmpty()) {
                tvData.setText("Сховище порожнє");
            } else {
                tvData.setText(text);
            }

        } catch (IOException e) {
            tvData.setText("Сховище порожнє");
        }
    }
}