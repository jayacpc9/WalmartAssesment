package com.test.apps.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.apps.myapplication.model.ResponseJsonData
import com.test.apps.myapplication.repo.AnimRepository

class AnimMainViewModel : ViewModel() {
    val animResponseJsonData: MutableLiveData<MutableList<ResponseJsonData.resultJsonData>> by lazy { MutableLiveData<MutableList<ResponseJsonData.resultJsonData>>() }

    var animRepository: AnimRepository = AnimRepository()
    val animViewModel = animRepository.animLiveData

    fun fetchAnimDataFor(animName: String) {
        animRepository.fetchDataFromRepository(animName)
    }


}