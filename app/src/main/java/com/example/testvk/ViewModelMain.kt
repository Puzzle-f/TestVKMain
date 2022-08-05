package com.example.testvk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testvk.data.*
import com.example.testvk.repository.apiVK
import com.example.testvkmain.BuildConfig

class ViewModelMain() : ViewModel() {

    private val _liveData= MutableLiveData<List<Frend>>()
     var liveData: LiveData<List<Frend>> = _liveData

    fun getFollowers(){
//        _liveData.postValue(apiVK.getFollowers(user_id, offset, count, name_case, fields, access_token, version))
//        liveData = apiVK.getFollowers(user_id, offset, count, name_case, fields, access_token, version)
    }

}