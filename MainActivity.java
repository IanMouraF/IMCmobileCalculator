package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.R;
import android.app.AlertDialog;

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
      
      if(imc > 0){
      
         if(imc < 18.5 ){
         
           
           tv.setText(imc.toString() + " - Abaixo do peso normal .");
           
         }else if((imc >= 18.5)&&(imc <= 24.9)){
           
           tv.setText(imc.toString() + " - Peso normal .");
           
           
         }else if((imc >= 25)&&(imc <= 29.9)){
           
           tv.setText(imc.toString() + " - Excesso de Peso .");
           
           
         }else if((imc >= 30)&&(imc <= 34.9)){
           
           tv.setText(imc.toString() + " - Obesidade Classe I .");
           
         }else if((imc >= 35.5)&&(imc <= 39.9)){
           
           tv.setText(imc.toString() + " - Obesidade Classe II .");
           
         }else if((imc >= 40)){
           
           tv.setText(imc.toString() + " - Obesidade Classe III.");
           
         }
        
      }else{
        
        tv.setText("Tente novamente");
        
      }
      
    }catch(Exception e){
      
      tv.setText("Tente novamente");
      
    } 
    
    }
    
    
}

