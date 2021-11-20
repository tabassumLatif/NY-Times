package com.quantum.nytimes.ui.articles.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.quantum.nytimes.R
import javax.inject.Inject

class ArticleDetailFragment @Inject constructor() :
    Fragment(R.layout.fragment_article_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments?.getSerializable(ArticleListFragment.KEY_ARTICLE) != null){
            Log.d("tabi", "onViewCreated: date receive")
        }
    }
}