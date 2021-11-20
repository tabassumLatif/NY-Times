package com.quantum.nytimes.ui.articles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quantum.nytimes.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticleActivity : AppCompatActivity() {
    @Inject
    lateinit var fragmentFactory: ArticleFragmentFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = fragmentFactory
        setContentView(R.layout.activity_artical)
    }
}