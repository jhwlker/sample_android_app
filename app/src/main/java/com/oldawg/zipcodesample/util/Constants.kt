package com.oldawg.zipcodesample.util

import com.oldawg.zipcodesample.BuildConfig

object Constants {
    const val BASE_URL = "https://www.zipcodeapi.com/rest/${BuildConfig.ZIP_CODE_API_KEY}/radius.json/"
    const val END_POINT = "{zipCode}/{radius}/km"
}