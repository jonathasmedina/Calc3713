package com.example.calc3713;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    SearchView searchView_;
    ListView listView;

    ArrayList<String> arrayList = new ArrayList<>();

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        searchView_ = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView1);

        arrayList.add("Texto 1");
        arrayList.add("Texto 2");
        arrayList.add("Texto 3");
        arrayList.add("Texto 4");
        arrayList.add("Texto 5");

        arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                arrayList
        );
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        getApplicationContext(),
                        "Cliquei: " + i,
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}