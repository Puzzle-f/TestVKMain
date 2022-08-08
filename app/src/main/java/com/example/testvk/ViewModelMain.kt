package com.example.testvk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testvk.Schedulers.DefaultSchedulers
import com.example.testvk.data.*
import com.example.testvk.repository.apiVK
import com.example.testvk.repository.apiVK2
import com.example.testvk.view.FollowersAdapter
import com.example.testvkmain.BuildConfig
import com.example.testvkmain.R

class ViewModelMain() : ViewModel() {

    private val _liveData= MutableLiveData<List<Frend>>()
     var liveData: LiveData<List<Frend>> = _liveData

    fun getFollowers(){
        apiVK2.getFollowers(
            user_id, offset, count, name_case, fields, access_token, version
        )
            .observeOn(DefaultSchedulers.main())
            .subscribe(
                {
                    _liveData.setValue(it.response.items)
                }, { error ->
                }
            )
    }

}