package com.example.calc3713;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    ArrayList<String> arrayListCopia;

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        searchView_ = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView1);

        searchView_.setIconified(false);

        arrayList.add("Spinner");
        arrayList.add("TextoInputLayout e TextInputEditText");
        arrayList.add("Janela de Diálogo");
        arrayList.add("Texto 4");
        arrayList.add("Texto 5");

        arrayListCopia = new ArrayList<>(arrayList);

        arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                arrayList
        );
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(MainActivity3.this, MainActivitySpinner.class);
                    startActivity(intent);
                }
                if(i == 1){
                    Intent intent = new Intent(MainActivity3.this, MainActivityTextInputLayout.class);
                    startActivity(intent);
                }
                if(i == 2){
                    Intent intent = new Intent(MainActivity3.this, MainActivityDialogo.class);
                    startActivity(intent);
                }

            }
        });

        searchView_.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
               //forma 1
                //MainActivity3.this.arrayAdapter.getFilter().filter(s);

                //forma 2
                fazerBusca(s);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    private void fazerBusca(String s) {

        arrayList.clear();

        s = s.toLowerCase();

        for(String item: arrayListCopia){
            if(item.toLowerCase().contains(s)){
                arrayList.add(item);
            }
        }
    }

}