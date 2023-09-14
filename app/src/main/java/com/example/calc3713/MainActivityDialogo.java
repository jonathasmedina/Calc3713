package com.example.calc3713;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class MainActivityDialogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dialogo);


        AlertDialog.Builder janela = new AlertDialog.Builder(MainActivityDialogo.this);
        janela.setTitle("Título da janela");
        janela.setMessage("A mensagem é essa.");
        //janela.setNeutralButton("Tudo bem.", null);
        janela.setPositiveButton("Ok", null);
        janela.setNegativeButton("Cancelar", ouvinte);

        janela.show();
    }

    DialogInterface.OnClickListener ouvinte = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(MainActivityDialogo.this, MainActivity3.class);
            startActivity(intent);
        }
    };
}