package com.example.stayarta.rest;

import com.example.stayarta.model.RootHotelModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("purwakarta//hotel") //endpoint
    Call<RootHotelModel> getData();
}