package com.quantum.nytimes.ui.articles.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.quantum.nytimes.databinding.RowArticleBinding
import com.quantum.nytimes.model.Article
import javax.inject.Inject


class ArticleAdapter @Inject constructor(
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private lateinit var onItemClickListener : ((Article) -> Unit)
    private lateinit var loadMoreListener : (() -> Unit)
    private val LOAD_MORE_THRESHOLD = 5

    inner class ArticleViewHolder(private val binding: RowArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            binding.viewModel = ArticleItemViewModel(articles[position])
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                if (this@ArticleAdapter::onItemClickListener.isInitialized)
                    onItemClickListener.invoke(articles[position])
            }
        }
    }

    private val diffUtil = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    var articles: List<Article>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val rowArticleBinding: RowArticleBinding =
            RowArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(rowArticleBinding)
    }


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.onBind(position)
        if(position+LOAD_MORE_THRESHOLD == itemCount){
            loadMoreListener.invoke()
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun setOnItemClickListener(listener : (Article) -> Unit) {
        onItemClickListener = listener
    }
    fun setLoadMoreListener(listener : () -> Unit) {
        loadMoreListener = listener
    }

}