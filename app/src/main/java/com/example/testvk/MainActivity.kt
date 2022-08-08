package com.example.testvk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testvk.Schedulers.DefaultSchedulers
import com.example.testvk.data.*
import com.example.testvk.repository.apiUsers
import com.example.testvk.repository.apiVK
import com.example.testvk.repository.apiVK2
import com.example.testvk.view.FollowersAdapter
import com.example.testvkmain.R
import com.example.testvkmain.databinding.ActivityMainBinding
import io.reactivex.rxjava3.disposables.Disposable
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var _vb: ActivityMainBinding? = null
    private val vb get() = _vb ?: throw RuntimeException("ViewBindingMain access error!")
    val vm: ViewModelMain by viewModel()
    var listFrend = mutableListOf<Frend>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
//        initStartUsers()
        initButtonClear()
        initStart2()
        val recyclerView: RecyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FollowersAdapter(listFrend)
    }

    fun getLiveData() {
        vm.liveData.observe(this) {
            println(it)
//            listFrend.addAll(it)
        }
    }

    fun initStart2(){
        vb.button.setOnClickListener {
            apiVK2.getFollowers(
                user_id, offset, count, name_case, fields, access_token, version
            )
                .observeOn(DefaultSchedulers.main())
                .subscribe(
                    {
                        listFrend.clear()
                        listFrend.addAll(it.response.items)
                        val recyclerView: RecyclerView = findViewById(R.id.rv)
                        recyclerView.layoutManager = LinearLayoutManager(this)
                        recyclerView.adapter = FollowersAdapter(listFrend)
                        println("ResponseVK count: "+it.response.count)

                    }, { error ->
                        vb.container.setBackgroundColor(R.color.red)
                    }
                )
        }
    }

    fun initButtonClear(){
        vb.clear.setOnClickListener { listFrend.clear() }
    }
}