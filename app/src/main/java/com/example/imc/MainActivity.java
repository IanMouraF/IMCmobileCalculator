package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tv;
    EditText peso;
    EditText altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.txt);
        peso = (EditText) findViewById(R.id.inputPeso);
        altura = (EditText) findViewById(R.id.inputAltura);
    }

    public void calcular(View v){

        try{

            Double pesoN = Double.parseDouble(peso.getText().toString());

            Double alturaN = Double.parseDouble(altura.getText().toString());

            Double imc = (pesoN)/(Math.pow(alturaN, 2));



            tv.setText(imc.toString());





        }catch(Exception e){

            tv.setText("Tente novamente");

        }

    }


}

