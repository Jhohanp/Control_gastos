package com.example.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VerFondo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_saldo);

        Button vgas=(Button) findViewById(R.id.button);
        vgas.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent ( view.getContext(), VerFondo.class);
                                        startActivityForResult(intent, 0);
                                    }
                                }

        );

        Button versal=(Button) findViewById(R.id.button2);
        versal.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent ( view.getContext(), VerFondo.class);
                                        startActivityForResult(intent, 0);
                                    }
                                }

        );
    }
}
