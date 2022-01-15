package com.test.apps.myapplication.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.apps.myapplication.network.AnimDataInterface
import com.test.apps.myapplication.model.ResponseJsonData.resultJsonData
import com.test.apps.myapplication.network.NetworkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimRepository {
    private val resultJsonData = MutableLiveData<resultJsonData>()
    val animLiveData: LiveData<resultJsonData> //live data to update
        get() {
            return resultJsonData
        }

    fun fetchDataFromRepository(animName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            var networkManager: NetworkManager = NetworkManager()
            var resultData: AnimDataInterface = networkManager.requestData()
            var animResultsJson = resultData.getAnimData(animName)
            resultJsonData.postValue(animResultsJson)// updates the ui
            println(" resultData = ${animResultsJson}")

        }
    }


}