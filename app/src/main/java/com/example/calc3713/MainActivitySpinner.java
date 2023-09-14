package com.example.calc3713;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivitySpinner extends AppCompatActivity {

    Spinner spinner_;
    ArrayList<String> stringArraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_spinner);

        spinner_ = findViewById(R.id.spinner1);

        stringArraylist.add("Opção 1");
        stringArraylist.add("Opção 2");
        stringArraylist.add("Opção 3");
        stringArraylist.add("Opção 4");

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_spinner_item,
                stringArraylist
        );

        spinner_.setAdapter(stringArrayAdapter);

        spinner_.setOnItemSelectedListener(mOuvinte);

    }
    AdapterView.OnItemSelectedListener mOuvinte = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String itemSelecionado = spinner_.getSelectedItem().toString();
            Toast.makeText(
                    getApplicationContext(),
                    "Item escolhido: " + itemSelecionado,
                    Toast.LENGTH_LONG).
                    show();

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
}