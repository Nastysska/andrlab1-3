package com.example.lab1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    private OnDataSendListener listener;

    public interface OnDataSendListener {
        void onDataSend(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnDataSendListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_input, container, false);

        Spinner spinner = view.findViewById(R.id.spinnerPhoneType);
        RadioGroup radioGroup = view.findViewById(R.id.radioGroupBrand);
        Button btnOk = view.findViewById(R.id.btnOk);

        String[] phoneTypes = {
                "Оберіть тип телефону",
                "Смартфон",
                "Кнопковий телефон",
                "Складаний телефон",
                "Ігровий телефон"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                phoneTypes
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnOk.setOnClickListener(v -> {

            String selectedType = spinner.getSelectedItem().toString();
            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedType.equals("Оберіть тип телефону") || selectedId == -1) {
                Toast.makeText(getContext(),
                        "Заповніть всі поля",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedRadio = view.findViewById(selectedId);
            String brand = selectedRadio.getText().toString();

            String result = "Обрано телефон:\nТип: " + selectedType +
                    "\nФірма: " + brand;

            listener.onDataSend(result);
        });

        return view;
    }
}