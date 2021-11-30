package com.oldawg.zipcodesample.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oldawg.zipcodesample.data.ZipCodeRepository
import com.oldawg.zipcodesample.di.CoroutineScropeIO
import com.oldawg.zipcodesample.models.ZipCode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ZipCodesViewModel @Inject constructor(
    private val repository: ZipCodeRepository,
    @CoroutineScropeIO private val ioCoroutineScope: CoroutineScope
) : ViewModel() {

    val zipCodes: MutableLiveData<List<ZipCode>> by lazy {
        MutableLiveData<List<ZipCode>>()
    }

    val zip = MutableLiveData<String>()
    val radius = MutableLiveData<Int>(0)

    fun fetchZipCodes(originZip: String, distance: Int) {
        loadZipCodes(originZip, distance)
    }

    private fun loadZipCodes(originZip: String, distance: Int) {
        zip.value = originZip
        radius.value = distance

        viewModelScope.launch(Dispatchers.IO) {
            repository.getZipCodes(originZip, distance).let { response ->
                if (response.isSuccessful) {
                    zipCodes.postValue(response.body()?.zip_codes?.filter { code ->
                        code.zip_code != originZip
                    }?.sortedBy { code -> code.distance })
                } else {
                    zip.value = response.message()
                }
            }
        }
    }
}