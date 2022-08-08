package com.example.testvk.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.testvk.data.Frend
import com.example.testvk.data.User
import com.example.testvkmain.R
import com.example.testvkmain.databinding.ItemBinding

class FollowersAdapter(val list: List<Frend>) :
    RecyclerView.Adapter<FollowersAdapter.MyViewHolder>() {

    class MyViewHolder(val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemBinding>(inflater, R.layout.item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemBinding.itemData = list[position]
    }

    override fun getItemCount() = list.size

}