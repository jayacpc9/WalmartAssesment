package com.test.apps.myapplication.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.anim_adapter_layout.view.*

class AnimViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val animImage = view.anim_image_view
    val animTitle = view.anim_title_text_view
    val animRated = view.anim_rated_text_view
    val animDescription = view.anim_description_text_view
}