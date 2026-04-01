package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPhoneType;
    private RadioGroup radioGroupBrand;
    private Button btnOk;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPhoneType = findViewById(R.id.spinnerPhoneType);
        radioGroupBrand = findViewById(R.id.radioGroupBrand);
        btnOk = findViewById(R.id.btnOk);
        tvResult = findViewById(R.id.tvResult);

        String[] phoneTypes = {
                "Оберіть тип телефону",
                "Смартфон",
                "Кнопковий телефон",
                "Складаний телефон",
                "Ігровий телефон"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                phoneTypes
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPhoneType.setAdapter(adapter);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedPhoneType = spinnerPhoneType.getSelectedItem().toString();
                int selectedBrandId = radioGroupBrand.getCheckedRadioButtonId();

                if (selectedPhoneType.equals("Оберіть тип телефону") || selectedBrandId == -1) {
                    Toast.makeText(MainActivity.this,
                            "Завершіть введення всіх даних",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedBrand = findViewById(selectedBrandId);
                String brand = selectedBrand.getText().toString();

                String result = "Обрано телефон:\nТип: " + selectedPhoneType +
                        "\nФірма: " + brand;

                tvResult.setText(result);
            }
        });
    }
}