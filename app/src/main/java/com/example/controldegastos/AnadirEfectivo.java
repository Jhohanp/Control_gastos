package com.example.controldegastos;
import cz.msebera.android.httpclient.Header;

import com.example.controldegastos.ui.main.Efectivo;
import com.example.controldegastos.ui.main.GsonMetodo;
import com.google.gson.*;
import com.loopj.android.http.*;
import com.example.controldegastos.ui.main.Gasto;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AnadirEfectivo extends AppCompatActivity {

    EditText Monto, Fecha, Desc;
    Button buttonAgregar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        Monto = (EditText)findViewById(R.id.InMonto);
        Fecha = (EditText)findViewById(R.id.InFecha);
        Desc = (EditText)findViewById(R.id.InDescripcion);
        buttonAgregar = (Button)findViewById(R.id.buttonAgregar);

        buttonAgregar = (Button)findViewById(R.id.buttonAgregar);
        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Efectivo efectivo = new Efectivo(0,Fecha.getText().toString(),Desc.getText().toString(),Integer.parseInt(Monto.getText().toString()));

                GsonMetodo<Efectivo> gson = new GsonMetodo<Efectivo>();
                String json = gson.convertToJson(efectivo);
                RequestParams params= new RequestParams();
                params.put("efectivo",json);
                AsyncHttpClient client;
                client = new AsyncHttpClient();
                client . post ( "http://192.168.0.108:51414/ServerApp/Controller", params , new AsyncHttpResponseHandler ()
                {
                    @Override
                    public void onSuccess ( int statusCode , Header [] headers , byte [] responseBody  ) {
                        // super.onSuccess(statusCode,headers,responseBody);
                        Toast.makeText(getApplicationContext(), "Envio al servidor exitoso", Toast.LENGTH_LONG).show();
                        Monto.setText("");
                        Fecha.setText("");
                        Desc.setText("");
                    }
                    @Override
                    public void onFailure  ( int statusCode , Header [] headers , byte [] responseBody , Throwable error) {
                        // Codigo a ejecutar en caso de error .
                        Toast.makeText(getApplicationContext(), "Error en el envio al servidor", Toast.LENGTH_LONG).show();
                    }
                }) ;
            }
        });
    }
}
