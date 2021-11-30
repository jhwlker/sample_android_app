package com.oldawg.zipcodesample.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ZipCode(
    var zip_code: String,
    var distance: Float,
    var city: String,
    var state: String
): Parcelable

data class ZipCodeResponse(
    var zip_codes: List<ZipCode>
)