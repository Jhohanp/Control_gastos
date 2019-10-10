package com.example.controldegastos.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.controldegastos.R;
import com.example.controldegastos.Tabla;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import cz.msebera.android.httpclient.Header;


public class DiaFragment extends Fragment {
    private  TableLayout tableLayout;
    private Button consultar;
    private Context context;
    private CalendarView calendario;
    private EditText prueba;
    private String newDate;
    View v;
    RequestQueue requestQueue;

    public DiaFragment(Context context) {
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_dia, container, false);


        calendario=v.findViewById(R.id.calendarView4);
        prueba=v.findViewById(R.id.pruebafecha);
        CalendarView.OnDateChangeListener myCalendarListener = new CalendarView.OnDateChangeListener(){

            public void onSelectedDayChange(CalendarView view, int year, int month, int day){
                month = month + 1;
                 newDate = year+"-"+month+"-"+day;
            }
        };
        calendario.setOnDateChangeListener(myCalendarListener);

        consultar=(Button)v.findViewById(R.id.consultarDia);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RequestParams params = new RequestParams("fecha", newDate);
                AsyncHttpClient client;
                client = new AsyncHttpClient();
                client.get ("http:///ServerApp/Controller", params , new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onStart() {
                        // called before request is started
                        Toast.makeText(context, "inicio envio", Toast.LENGTH_LONG).show();
                    }

                    public void onSuccess (int statusCode , Header[] headers , byte [] responseBody  ) {
                        // super.onSuccess(statusCode,headers,responseBody);
                        String json=new String(responseBody);
                        System.out.println(json);
                        Toast.makeText(context, "Envio al servidor exitoso", Toast.LENGTH_LONG).show();

                    }
                    public void onFailure  ( int statusCode , Header [] headers , byte [] responseBody , Throwable error) {
                        // Codigo a ejecutar en caso de error .
                        Toast.makeText(context, "Error en el envio al servidor", Toast.LENGTH_LONG).show();
                    }
                }) ;
            }
        });

        return v;
    }
    /*
    private void AgregarATabla(String URL){

            final   Tabla tabla = new Tabla(getActivity(), (TableLayout)v.findViewById(R.id.tabla));
            tabla.agregarCabecera(R.array.cabecera_tabla);

            for (int i = 0; i < 5; i++) {

                final ArrayList<String> elementos = new ArrayList<String>();

                elementos.add("hjolaaa");
                elementos.add("melossss");
                tabla.agregarFilaTabla(elementos);

            }
        }*/
    }


