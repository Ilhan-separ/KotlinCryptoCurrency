package com.example.retrofitkotlin.service

import com.example.retrofitkotlin.model.CryptoModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {


    // currencies/ticker?key=0703c79653d3530d4b14e992d41870097106efd7
    @GET("currencies/ticker?key=0703c79653d3530d4b14e992d41870097106efd7")
    fun getData() : Observable<List<CryptoModel>>


    //fun getData(): Call<List<CryptoModel>>

}