package com.oldawg.zipcodesample.data

import com.oldawg.zipcodesample.api.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ZipCodeRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getZipCodes(originZipCode: String, distance: Int) = apiService.getZipCodes(originZipCode, distance)
}