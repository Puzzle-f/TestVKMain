package com.example.testvk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testvk.data.Frend
import com.example.testvk.view.FollowersAdapter
import com.example.testvkmain.R
import com.example.testvkmain.databinding.ActivityMainBinding
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
        initButtonClear()
        initButtonStart()
    }

    fun getLiveData() {
        vm.liveData.observe(this) {
            listFrend.addAll(it)
            val recyclerView: RecyclerView = findViewById(R.id.rv)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = FollowersAdapter(listFrend)
        }
    }

    fun initButtonStart() {
        vb.button.setOnClickListener {
            vm.getFollowers()
            getLiveData()
        }
    }

    fun initButtonClear() {
        vb.clear.setOnClickListener { listFrend.clear() }
    }
}