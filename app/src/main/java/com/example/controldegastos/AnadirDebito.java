package com.example.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.controldegastos.ui.main.GsonMetodo;
import com.example.controldegastos.ui.main.TarjetaCredito;
import com.example.controldegastos.ui.main.TarjetaDebito;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class AnadirDebito extends AppCompatActivity {
    EditText Digitos, Cupo,Cuota;
    Button buttonAgregar;
    private Spinner spinnerX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debito);
        spinnerX = (Spinner)findViewById(R.id.spinner);
        String [] Tipos ={"Visa", "MasterCard" ,"Diners Club","American Express"};

        ArrayAdapter<String> adapterCat = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Tipos);
        spinnerX.setAdapter(adapterCat);
        Digitos = (EditText)findViewById(R.id.InDigitos);
        Cupo = (EditText)findViewById(R.id.InCupo);
        Cuota = (EditText)findViewById(R.id.InCuota);

        buttonAgregar = (Button)findViewById(R.id.buttonAgregar);
        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TarjetaDebito TD = new TarjetaDebito((String)spinnerX.getSelectedItem(),Integer.parseInt(Digitos.getText().toString()),Integer.parseInt(Cupo.getText().toString()),Integer.parseInt(Cuota.getText().toString()));

                GsonMetodo<TarjetaDebito> gson = new GsonMetodo<TarjetaDebito>();
                String json = gson.convertToJson(TD);
                RequestParams params= new RequestParams();
                params.put("debito",json);
                AsyncHttpClient client;
                client = new AsyncHttpClient();
                client . post ( "http://192.168.0.108:51414/ServerApp/Controller", params , new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess (int statusCode , Header[] headers , byte [] responseBody  ) {
                        // super.onSuccess(statusCode,headers,responseBody);
                        Toast.makeText(getApplicationContext(), "Envio al servidor exitoso", Toast.LENGTH_LONG).show();
                        Digitos.setText("");
                        Cupo.setText("");
                        Cuota.setText("");

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
