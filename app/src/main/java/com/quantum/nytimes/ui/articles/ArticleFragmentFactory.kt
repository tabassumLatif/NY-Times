package com.quantum.nytimes.ui.articles

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.quantum.nytimes.ui.articles.adapter.ArticleAdapter
import com.quantum.nytimes.ui.articles.fragments.ArticleDetailFragment
import com.quantum.nytimes.ui.articles.fragments.ArticleListFragment
import javax.inject.Inject

class ArticleFragmentFactory @Inject constructor(
    private val imageRecyclerAdapter: ArticleAdapter
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ArticleListFragment::class.java.name -> ArticleListFragment(imageRecyclerAdapter)
            ArticleDetailFragment::class.java.name -> ArticleDetailFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}