package com.quantum.nytimes.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.quantum.nytimes.R
import com.quantum.nytimes.model.Article
import com.quantum.nytimes.ui.articles.adapter.ArticleAdapter

object BindingUtil {

    @JvmStatic
    @BindingAdapter("articleAdapter")
    fun setAdapter(recyclerView: RecyclerView, articles:List<Article>?){
        if(recyclerView.adapter != null && articles != null){
            val adapter = recyclerView.adapter as ArticleAdapter
            adapter.addArticles(articles)
        }
    }

    @JvmStatic
    @BindingAdapter("loadCircleImage")
    fun loadCircleImage(imageView: ImageView, url : String?){
        if(!url.isNullOrEmpty()){
            Glide.with(imageView.context)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .transform(CircleCrop())
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(imageView: ImageView, url : String?){
        if(!url.isNullOrEmpty()){
            Glide.with(imageView.context)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView)
        }
    }
}