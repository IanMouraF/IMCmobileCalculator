package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


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


    public void calcular(View v) {
        ImageView im = findViewById(R.id.imageView);

        try {
            Double pesoN = Double.parseDouble(peso.getText().toString());

            String alturaStr = altura.getText().toString().replace(',', '.');
            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
            Number alturaN = format.parse(alturaStr);
            Double alturaMetros = alturaN.doubleValue() / 100;
            Double imc = pesoN / (alturaMetros * alturaMetros);

            DecimalFormat df = new DecimalFormat("#.##");

            if (imc > 0) {
                if (imc < 18.5) {
                    tv.setText(df.format(imc) + " - Abaixo do peso normal.");
                    im.setImageResource(R.drawable.imc1);
                } else if ((imc >= 18.5) && (imc <= 24.9)) {
                    tv.setText(df.format(imc) + " - Peso normal.");
                    im.setImageResource(R.drawable.imc2);
                } else if ((imc >= 25) && (imc <= 29.9)) {
                    tv.setText(df.format(imc) + " - Excesso de Peso.");
                    im.setImageResource(R.drawable.imc3);
                } else if ((imc >= 30) && (imc <= 34.9)) {
                    tv.setText(df.format(imc) + " - Obesidade Classe I.");
                    im.setImageResource(R.drawable.imc4);
                } else if ((imc >= 35) && (imc <= 39.9)) {
                    tv.setText(df.format(imc) + " - Obesidade Classe II.");
                    im.setImageResource(R.drawable.imc5);
                } else if (imc >= 40) {
                    tv.setText(df.format(imc) + " - Obesidade Classe III.");
                    im.setImageResource(R.drawable.imc6);
                }
            } else {
                tv.setText("Tente novamente");
            }
        } catch (ParseException e) {
            tv.setText("Tente novamente");
        }
    }
}