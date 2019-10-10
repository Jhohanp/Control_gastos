package com.example.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgregarFondo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_fondo);

        Button efect=(Button) findViewById(R.id.button4);
        efect.setOnClickListener(new View.OnClickListener()

                                  {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent ( view.getContext(), AnadirEfectivo.class);
                                          startActivityForResult(intent, 0);
                                      }
                                  }

        );

        Button cred=(Button) findViewById(R.id.button5);
        cred.setOnClickListener(new View.OnClickListener()

                                 {
                                     @Override
                                     public void onClick(View view) {
                                         Intent intent = new Intent ( view.getContext(), AnadirCredito.class);
                                         startActivityForResult(intent, 0);
                                     }
                                 }

        );

        Button debit=(Button) findViewById(R.id.button6);
        debit.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent ( view.getContext(), AnadirDebito.class);
                                        startActivityForResult(intent, 0);
                                    }
                                }

        );
    }
}
