package com.example.sistemas.cultura.api;

import com.example.sistemas.cultura.models.Bibliotecas;
import com.example.sistemas.cultura.models.Cines;
import com.example.sistemas.cultura.models.Musicas;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("in3j-awgi.json")
    Call<ArrayList<Bibliotecas>> obtenerBibliotecas();

    @GET("tbiy-svbe.json")
    Call<ArrayList<Musicas>> obtenerMusicas();

    @GET("2azi-vnwj.json")
    Call<ArrayList<Cines>> obtenerCines();


}
