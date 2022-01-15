package com.test.apps.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.apps.myapplication.R
import com.test.apps.myapplication.model.ResponseJsonData


class AnimAdapter(private val animList: List<ResponseJsonData.results>) :
    RecyclerView.Adapter<AnimViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimViewHolder {
        return AnimViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.anim_adapter_layout, parent, false)
        )
    }

    override fun getItemCount() = animList.size

    override fun onBindViewHolder(holder: AnimViewHolder, position: Int) {
        var aResults = animList.get(position)
        Picasso.with(holder.itemView.context).load(aResults.image_url).into(holder.animImage);
        holder.animTitle.text = aResults.title
        holder.animRated.text = aResults.rated
        holder.animDescription.text = aResults.synopsis
        println("Title = ${aResults.title}")

    }


}