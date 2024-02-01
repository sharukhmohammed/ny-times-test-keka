package com.sharukh.sampletest.searchlist

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.sharukh.sampletest.databinding.ItemArticleBinding
import com.sharukh.sampletest.models.Doc

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {
    private var languageList: MutableList<Doc> = mutableListOf()


    inner class ViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(languageList[position]) {
                binding.textAbstract.text = this.abstract
                binding.textSource.text = this.source
                this.image?.url?.let { binding.image.load(it) }
            }
        }
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return languageList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Doc>) {
        languageList.clear()
        languageList.addAll(list)
        notifyDataSetChanged()
        // todo optimise with Diff util
    }
}
