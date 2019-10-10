package com.example.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.controldegastos.ui.main.Efectivo;
import com.example.controldegastos.ui.main.Gasto;
import com.example.controldegastos.ui.main.GsonMetodo;
import com.example.controldegastos.ui.main.TarjetaCredito;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class AnadirCredito extends AppCompatActivity {

    EditText Digitos, Interes, Cupo,Cuota;
    Button buttonAgregar;
    private Spinner spinnerTar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credito);
        spinnerTar =(Spinner)findViewById(R.id.spinnerTj);
        Digitos = (EditText)findViewById(R.id.InDigitos);
        Interes = (EditText)findViewById(R.id.InInteres);
        Cupo = (EditText)findViewById(R.id.InCupo);
        Cuota = (EditText)findViewById(R.id.InCuota);
        String [] Tipos ={"Visa", "MasterCard" ,"Diners Club","American Express"};

        ArrayAdapter<String> adapterCat = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Tipos);
        spinnerTar.setAdapter(adapterCat);



        buttonAgregar = (Button)findViewById(R.id.buttonAgregar);
        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TarjetaCredito TC = new TarjetaCredito(Integer.parseInt(Digitos.getText().toString()),(String)spinnerTar.getSelectedItem(),Integer.parseInt(Cupo.getText().toString()),Integer.parseInt(Cuota.getText().toString()),Double.parseDouble(Interes.getText().toString()));

                GsonMetodo<TarjetaCredito> gson = new GsonMetodo<TarjetaCredito>();
                String json = gson.convertToJson(TC);
                RequestParams params= new RequestParams();
                params.put("credito",json);
                AsyncHttpClient client;
                client = new AsyncHttpClient();
                client . post ( "http://192.168.0.108:51414/ServerApp/Controller", params , new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess (int statusCode , Header[] headers , byte [] responseBody  ) {
                        // super.onSuccess(statusCode,headers,responseBody);
                        Toast.makeText(getApplicationContext(), "Envio al servidor exitoso", Toast.LENGTH_LONG).show();
                        Digitos.setText("");
                        Interes.setText("");
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
