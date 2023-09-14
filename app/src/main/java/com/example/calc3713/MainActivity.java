package com.example.calc3713;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edNum1, edNum2;
    Button btSomar, btSubtrair, btMult, btDiv, btLimpar;
    TextView tvResultado;

    float resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSomar = findViewById(R.id.buttonSomar);
        btSubtrair = findViewById(R.id.buttonSubtrair);
        btMult = findViewById(R.id.buttonMultiplicar);
        btDiv = findViewById(R.id.buttonDividir);
        btLimpar = findViewById(R.id.buttonLimpar);

        tvResultado = findViewById(R.id.textViewResultado);

        tvResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("aqui: ", "valores das var");
                Toast.makeText(getApplicationContext(),"Usuário Logado", Toast.LENGTH_SHORT).show();
                //Patterns.EMAIL_ADDRESS.matcher(emailDigitado).matches()
            }
        });

        edNum1 = findViewById(R.id.editTextNum1);
        edNum2 = findViewById(R.id.editTextNum2);

        btDiv.setOnClickListener(this);
        btSomar.setOnClickListener(this);
        btSubtrair.setOnClickListener(this);
        btMult.setOnClickListener(this);
        btLimpar.setOnClickListener(this);

        //edNum1.setEnabled(false);
        //edNum1.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View view) {

        if(edNum1.getText().toString().equals("") && edNum2.getText().toString().equals("")) {
            edNum1.setError("Campo vazio");
            edNum2.setError("Campo vazio");
        }
        else if(edNum2.getText().toString().equals("")){
            edNum2.setError("Campo vazio");
        }else if(edNum1.getText().toString().equals("")){
            edNum1.setError("Campo vazio");
        }
        else{
            float valorDigitado1 = Float.parseFloat(edNum1.getText().toString());
            float valorDigitado2 = Float.parseFloat(edNum2.getText().toString());

            if(view.getId() == R.id.buttonSomar){
                resultado = valorDigitado1 + valorDigitado2;

            }
            if(view.getId() == R.id.buttonSubtrair){
                resultado = valorDigitado1 - valorDigitado2;
            }
            if(view.getId() == R.id.buttonMultiplicar){
                resultado = valorDigitado1 * valorDigitado2;
            }
            if(view.getId() == R.id.buttonDividir){
                if(edNum2.getText().toString().equals("0")){
                    edNum2.setError("é zero.");
                    return;
                }else{
                    resultado = valorDigitado1 / valorDigitado2;
                }

            }
            if(view.getId() == R.id.buttonLimpar){
                edNum1.setText("");
                edNum2.setText("");
                tvResultado.setText("Resultado");
            }
            String resultado_ = String.format("%.2f", resultado);
            tvResultado.setText(resultado_);

            Intent i = new Intent(MainActivity.this, MainActivity3.class);

            String nome = "joao";

            i.putExtra("nome_apelido", nome);

            startActivity(i);

        }


    }
}