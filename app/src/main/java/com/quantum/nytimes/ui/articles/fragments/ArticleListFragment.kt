package com.quantum.nytimes.ui.articles.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.quantum.nytimes.R
import com.quantum.nytimes.databinding.FragmentArticleListBinding
import com.quantum.nytimes.ui.articles.adapter.ArticleAdapter
import com.quantum.nytimes.ui.articles.viewModel.ArticlesViewModel
import javax.inject.Inject

import androidx.appcompat.app.AppCompatActivity


class ArticleListFragment @Inject constructor(private val articleAdapter: ArticleAdapter) :
    Fragment(R.layout.fragment_article_list) {

    private var binding: FragmentArticleListBinding? = null
    lateinit var viewModel: ArticlesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ArticlesViewModel::class.java)
        val binding = FragmentArticleListBinding.bind(view)
        changeTitle()
        this.binding = binding.also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
            it.rvArticle.adapter = articleAdapter
        }
        addItemClickListener()
        addLoadMoreListener()
        viewModel.fetchArticle()
    }

    private fun addLoadMoreListener() {
        articleAdapter.setLoadMoreListener {
            viewModel.fetchArticle()
        }
    }

    private fun addItemClickListener() {
        articleAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putSerializable(KEY_ARTICLE, it)
            val action = ArticleListFragmentDirections.actionArticleListFragmentToArticleDetailFragment()
            findNavController().navigate(
                action.actionId, bundle
            )
        }
    }

    private fun changeTitle(){
        (requireActivity() as AppCompatActivity?)?.supportActionBar?.title = "Articles"
    }

    companion object{
        const val KEY_ARTICLE = "article"
    }


}


