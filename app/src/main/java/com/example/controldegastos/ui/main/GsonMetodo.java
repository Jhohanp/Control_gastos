package com.example.controldegastos.ui.main;

import com.google.gson.Gson;

public class GsonMetodo<T>{

    public String convertToJson(T t){
        Gson gson = new Gson();
        String json = gson.toJson(t);
        return json;
    }
}
