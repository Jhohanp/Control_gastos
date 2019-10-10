package com.example.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button vgas=(Button) findViewById(R.id.button_VerGasto);
        vgas.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( view.getContext(), VistasGasto.class);
                startActivityForResult(intent, 0);
            }
        }

        );


      Button adgas=(Button) findViewById(R.id.button_AddGastos);
      adgas.setOnClickListener(new View.OnClickListener()

                               {
                                  @Override
                                  public void onClick(View view) {
                                      Intent intent = new Intent ( view.getContext(), AnadirGasto.class);
                                      startActivityForResult(intent, 0);
                                  }
                              }

      );

      Button versal=(Button) findViewById(R.id.button_Saldo);
      versal.setOnClickListener(new View.OnClickListener()

                               {
                                   @Override
                                   public void onClick(View view) {
                                       Intent intent = new Intent ( view.getContext(), VerFondo.class);
                                       startActivityForResult(intent, 0);
                                   }
                               }

      );

      Button agrfon=(Button) findViewById(R.id.button3);
      agrfon.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent ( view.getContext(), AgregarFondo.class);
                                        startActivityForResult(intent, 0);
                                    }
                                }

      );
    }

}
