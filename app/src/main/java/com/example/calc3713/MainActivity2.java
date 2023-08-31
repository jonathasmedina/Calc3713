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

public class MainActivity2 extends AppCompatActivity {

    ListView listView;

    ArrayList<String> arrayListTexto = new ArrayList<>();
    ArrayList<String> arrayListTextoCopia;
    ArrayAdapter<String> meuArrayAdapter;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.lista1);
        searchView = findViewById(R.id.searchView1);

        arrayListTexto.add("Item 1");
        arrayListTexto.add("Item 2");
        arrayListTexto.add("Item 3");
        arrayListTexto.add("Item 4");

        //duplicando para não alterar o original na busca
        arrayListTextoCopia = new ArrayList<>(arrayListTexto);

        meuArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListTexto);
        searchView.setIconified(false);
//        searchView.clearFocus();

        listView.setAdapter(meuArrayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //forma 1: utilizar filter pronto (não busca letras dentro de palavras)
                //MainActivity2.this.meuArrayAdapter.getFilter().filter(s);

                //forma 2: fazer a busca manualmente (busca letras dentro de palavras)
                // fazerBuscaObj(s);
                //meuArrayAdapter.notifyDataSetChanged();

                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "clicou" + i, Toast.LENGTH_SHORT).show();
            }
        });

        //Patterns.EMAIL_ADDRESS.matcher(email).matches()

        Intent intent2 = getIntent();

        String nomeRecebido = (String) intent2.getSerializableExtra("nome_apelido");

    }

    private void fazerBuscaObj(String s) {
        //limpando array que monta a lista ao buscar algum termo na searchView
        arrayListTexto.clear();
        //digitou algo e apagou = trazer todos. SITES_copia contém todos
        if (s.isEmpty()) {
            arrayListTexto.addAll(arrayListTextoCopia);
        } else {
            //algum texto digitado na busca
            //converte para letra minúscula para não haver distinção
            s = s.toLowerCase();
            //percorre o array com os dados originais e busca
            for (String item : arrayListTextoCopia) {
                //caso, nos dados originais, exista o termo procurado, popule o array vazio com o item
                if (item.toLowerCase().contains(s)) {
                    arrayListTexto.add(item);
                }
            }
        }
    }
}