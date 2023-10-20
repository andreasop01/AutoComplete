package com.avidesousa.autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String []paises= new String[]{"Alemania","Andorra","Arabia","etc","España","Eslovenia"};
        ArrayAdapter<String> miAdaptadorPais=new ArrayAdapter<String>(
                this, R.layout.autocomplete_paises,paises);// this, android.R.layout.simple_list_item_1
        AutoCompleteTextView txtPais=findViewById(R.id.txtPais);
        txtPais.setThreshold(1);
        txtPais.setAdapter(miAdaptadorPais);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn=(Button)v;
                Toast.makeText(getApplicationContext(),btn.getText()+"-"+btn.getId(),Toast.LENGTH_SHORT).show();
            }
        };
        LinearLayout l=findViewById(R.id.edVerticalLayout);
        for(int i=0;i<17;i++){
            Button b=new Button(this);
            b.setText("Boton"+i);
            b.setId(View.generateViewId()); //genera un id automatico
            b.setOnClickListener(listener);
            l.addView(b);
        }
        for(int i=0;i<l.getChildCount();i++){
            Button b=(Button)l.getChildAt(i);
            b.setBackgroundColor(Color.GREEN);
        }
    }
}