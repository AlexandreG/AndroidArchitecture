package fr.zzi.androidarchitecture.feature.daylist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.zzi.androidarchitecture.R


class DayListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DayListAdapter

    private lateinit var viewModel: DayListViewModel

    companion object {
        const val TAG = "DayListFragment"

        fun newInstance(): DayListFragment {
            return DayListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_day_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DayListViewModel::class.java)

        initViewIds(view)
        initRecyclerView()
        fetchData()
    }

    private fun initViewIds(view: View) {
        recyclerView = view.findViewById(R.id.fragment_day_list_recycler)
    }

    private fun initRecyclerView() {
        context?.let { ctxt ->
            adapter = DayListAdapter(ctxt)

            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
    }

    private fun fetchData() {
        viewModel.getForecast().observe(this, Observer { dayItemList ->
            adapter.setData(dayItemList)
            adapter.notifyDataSetChanged()
        })

    }

}