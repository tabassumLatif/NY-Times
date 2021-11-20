package com.quantum.nytimes.ui.articles.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.quantum.nytimes.R
import com.quantum.nytimes.databinding.FragmentArticleDetailBinding
import com.quantum.nytimes.databinding.FragmentArticleListBinding
import com.quantum.nytimes.model.Article
import com.quantum.nytimes.ui.articles.viewModel.ArticleDetailViewModel
import com.quantum.nytimes.ui.articles.viewModel.ArticlesViewModel
import javax.inject.Inject

class ArticleDetailFragment @Inject constructor() :
    Fragment(R.layout.fragment_article_detail) {

    private var binding: FragmentArticleDetailBinding? = null
    lateinit var viewModel: ArticleDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ArticleDetailViewModel::class.java)
        if (arguments?.getSerializable(ArticleListFragment.KEY_ARTICLE) != null) {
            viewModel.setArticle(arguments?.getSerializable(ArticleListFragment.KEY_ARTICLE) as Article)
        }
        val binding = FragmentArticleDetailBinding.bind(view)
        this.binding = binding.also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }
    }
}