package fr.zzi.androidarchitecture.feature.teams.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.zzi.androidarchitecture.R
import fr.zzi.androidarchitecture.feature.players.ui.PlayersActivity
import fr.zzi.androidarchitecture.feature.teams.domain.Team


class SearchTeamFragment : Fragment(), TeamListAdapter.Listener {

    private val recyclerView: RecyclerView by lazy { view?.findViewById(R.id.fragment_search_team_recycler) as RecyclerView }
    private val loader: View by lazy { view?.findViewById(R.id.fragment_search_team_loader) as View }
    private val editText: EditText by lazy { view?.findViewById(R.id.fragment_search_team_edit_text) as EditText }

    private lateinit var adapter: TeamListAdapter

    lateinit var presenter: SearchTeamPresenter

    companion object {
        const val TAG = "SearchTeamFragment"

        fun newInstance(): SearchTeamFragment {
            return SearchTeamFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initEditText()
    }

    private fun initEditText() {
        val minimumLenghForRequest = 3

        editText.doAfterTextChanged {
            val newInput = it.toString()
            if (newInput.length >= minimumLenghForRequest) {
                presenter.onTextSearched(newInput)
                loader.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }
        }
    }

    private fun initRecyclerView() {
        context?.let { ctxt ->
            adapter = TeamListAdapter(ctxt)
            adapter.listener = this

            recyclerView.adapter = adapter
        }
    }

    fun displayTeams(teamList: List<Team>) {
        recyclerView.visibility = View.VISIBLE
        loader.visibility = View.GONE

        adapter.data = teamList
        adapter.notifyDataSetChanged()
    }

    override fun onItemClick(teamName: String) {
        context?.let {
            val intent = Intent(it, PlayersActivity::class.java)
            intent.putExtra(PlayersActivity.EXTRA_TEAM_NAME, teamName)
            startActivity(intent)
        }
    }

}