package fr.zzi.androidarchitecture.feature.articlelist.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import fr.zzi.androidarchitecture.R
import fr.zzi.androidarchitecture.feature.articlelist.domain.Article


class ArticleListFragment : Fragment(R.layout.fragment_article_list), ArticleListAdapter.Listener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ArticleListAdapter

    private val viewModel: ArticleListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewIds(view)
        initRecyclerView()

        fetchData()
    }

    private fun initViewIds(view: View) {
        recyclerView = view.findViewById(R.id.fragment_article_list_recycler)
    }

    private fun initRecyclerView() {
        context?.let { ctxt ->
            adapter = ArticleListAdapter(ctxt)
            adapter.listener = this

            recyclerView.adapter = adapter
        }
    }

    private fun fetchData() {
        viewModel.articleLiveData.observe(viewLifecycleOwner, Observer { articleList ->
            adapter.data = articleList
            adapter.notifyDataSetChanged()
        })

        viewModel.fetchArticles()
    }

    override fun onItemClick(article: Article) {
        article.link?.let {
            context?.let {
                val builderCustomTabs = CustomTabsIntent.Builder()
                val intentCustomTabs = builderCustomTabs.build()
                intentCustomTabs.intent.setPackage("com.android.chrome")
                intentCustomTabs.intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intentCustomTabs.launchUrl(it, Uri.parse(article.link))
            }
        }
    }

}