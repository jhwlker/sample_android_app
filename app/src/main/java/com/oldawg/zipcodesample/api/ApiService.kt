package com.oldawg.zipcodesample.api

import com.oldawg.zipcodesample.models.ZipCodeResponse
import com.oldawg.zipcodesample.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getZipCodes(
        @Path("zipCode") origin: String,
        @Path("radius") distance: Int
    ): Response<ZipCodeResponse>
}