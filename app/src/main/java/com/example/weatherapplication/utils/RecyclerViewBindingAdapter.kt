package com.example.weatherapplication.utils

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("data")
        fun <T : Any> bindDataList(recyclerView: RecyclerView, liveData: LiveData<List<T>>) {
            val adapter = recyclerView.adapter as BindableAdapter<T>
            liveData.getValue()?.let { list ->
                adapter.setData(list)
            }
        }

        @JvmStatic
        @BindingAdapter("itemDecorator")
        fun addItemDecorator(
            recyclerView: RecyclerView,
            drawable: Drawable
        ) {
            recyclerView.addItemDecoration(DividerItemDecorator(drawable))
        }
    }
}
