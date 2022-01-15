package com.test.apps.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.apps.myapplication.R
import com.test.apps.myapplication.model.ResponseJsonData
import com.test.apps.myapplication.ui.adapter.AnimAdapter
import kotlinx.android.synthetic.main.anim_main_fragment.*

class AnimMainFragment : Fragment() {

    companion object {
        fun newInstance() = AnimMainFragment()
        val NARUTO: String = "naruto"
        val SHINGEKI: String = "Shingeki"
    }

    private lateinit var viewModelAnim: AnimMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.anim_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelAnim = ViewModelProvider(this).get(AnimMainViewModel::class.java)
        // TODO: Use the ViewModel

        search_button.setOnClickListener {
            search_edit_text?.text?.toString()?.let {
                if(it.isNotEmpty()) {
                    initViews(it)//search for new anim character.
                    showBusyProgress(true)
                    rv_anim_list?.apply {
                        this.visibility = View.INVISIBLE
                    }
                }
            }
        }

        initViews()//default value is naruto
        viewModelObserver()
    }

    private fun initViews(animName: String = "naruto") {
        showBusyProgress(true)
        viewModelAnim.fetchAnimDataFor(animName)
    }

    private fun viewModelObserver() {
        viewModelAnim.animViewModel.observe(this, { response ->
            response?.let {
                showBusyProgress(false)
                showRecyclerView(response)
            }
        })
    }

    private fun showBusyProgress(state: Boolean) {
        pb_busy?.visibility = if (state) View.VISIBLE else View.GONE
    }

    private fun showRecyclerView(responseJsonData: ResponseJsonData.resultJsonData) {
        rv_anim_list?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = AnimAdapter(responseJsonData.results)
            this.visibility=View.VISIBLE
        }
    }

}