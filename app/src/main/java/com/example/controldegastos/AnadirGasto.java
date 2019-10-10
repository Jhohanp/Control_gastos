package com.example.controldegastos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import cz.msebera.android.httpclient.Header;

import com.example.controldegastos.ui.main.GsonMetodo;
import com.google.gson.*;
import com.loopj.android.http.*;
import com.example.controldegastos.ui.main.Gasto;




public class AnadirGasto extends AppCompatActivity {

    Spinner Cat, mPago;
    EditText Monto, Fecha, Hora, Frec, Desc;
    Button buttonAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadirgasto);

        Cat =(Spinner)findViewById(R.id.spinnerCat);
        Frec =(EditText)findViewById(R.id.InFrec);
        mPago = (Spinner)findViewById(R.id.spinnerMetodo);
        Monto = (EditText)findViewById(R.id.InMonto);
        Fecha = (EditText)findViewById(R.id.InFecha);
        Hora = (EditText)findViewById(R.id.InHora);
        Desc = (EditText)findViewById(R.id.InDescripcion);
        buttonAgregar = (Button)findViewById(R.id.buttonAgregar);

        String [] CategoriasArray = {"Hogar", "Salud", "Transporte", "Ropa y calzado", "Cuentas y pagos", "Seguros", "Estetica", "Diversion", "Otros gastos"};
        String [] MetodosArray;

        ArrayAdapter<String> adapterCat = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CategoriasArray);
        Cat.setAdapter(adapterCat);


       buttonAgregar = (Button)findViewById(R.id.buttonAgregar);
        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Gasto gasto = new Gasto("0",(String)Cat.getSelectedItem(),Fecha.getText().toString().toString(),Hora.getText().toString(),"efectivo",Desc.getText().toString(),Integer.parseInt(Monto.getText().toString()),Integer.parseInt(Frec.getText().toString()));

                GsonMetodo<Gasto> gson = new GsonMetodo<Gasto>();
                String json = gson.convertToJson(gasto);
                RequestParams params= new RequestParams();
                params.put("gasto",json);
                AsyncHttpClient client;
                client = new AsyncHttpClient();
                client . post ( "http://192.168.0.108:51414/ServerApp/Controller", params , new AsyncHttpResponseHandler ()
                {
                    public void onSuccess ( int statusCode , Header [] headers , byte [] responseBody  ) {
                       // super.onSuccess(statusCode,headers,responseBody);
                        Toast.makeText(getApplicationContext(), "Envio al servidor exitoso", Toast.LENGTH_LONG).show();
                        Monto.setText("");
                        Fecha.setText("");
                        Hora.setText("");
                        Frec.setText("");
                        Desc.setText("");
                    }
                    public void onFailure  ( int statusCode , Header [] headers , byte [] responseBody , Throwable error) {
                    // Codigo a ejecutar en caso de error .
                        Toast.makeText(getApplicationContext(), "Error en el envio al servidor", Toast.LENGTH_LONG).show();
                    }
                }) ;
            }
        });
    }

}
