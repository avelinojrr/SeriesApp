package com.example.seriesapp.repository

import com.example.seriesapp.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject
constructor(private val apiService: ApiService){

        suspend fun getTvShows() = apiService.getTvShows()

}
