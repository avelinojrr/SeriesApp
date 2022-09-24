package com.example.seriesapp.api

import com.example.seriesapp.helper.Constants
import com.example.seriesapp.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>

}