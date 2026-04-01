package com.example.lab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    private static final String ARG_DATA = "data";

    public static ResultFragment newInstance(String data) {
        ResultFragment fragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_DATA, data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_result, container, false);

        TextView tvResult = view.findViewById(R.id.tvResult);
        Button btnCancel = view.findViewById(R.id.btnCancel);

        String data = getArguments().getString(ARG_DATA);
        tvResult.setText(data);

        btnCancel.setOnClickListener(v -> {
            // Видаляємо тільки ResultFragment
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .remove(this)
                    .commit();
        });

        return view;
    }
}