package fr.zzi.androidarchitecture.feature.players.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.zzi.androidarchitecture.R
import fr.zzi.androidarchitecture.feature.players.domain.Player


class PlayersFragment : Fragment() {

    private val recyclerView: RecyclerView by lazy { view?.findViewById(R.id.fragment_search_team_recycler) as RecyclerView }

    private lateinit var adapter: PlayersAdapter
    lateinit var presenter: PlayersPresenter

    private val teamName by lazy { arguments?.getString(EXTRA_TEAM) }

    companion object {
        const val TAG = "PlayersFragment"
        private const val EXTRA_TEAM = "team"

        fun newInstance(team: String): PlayersFragment {
            return PlayersFragment().apply {
                arguments = bundleOf(EXTRA_TEAM to team)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        presenter.start(teamName ?: "")
    }

    private fun initRecyclerView() {
        context?.let { ctxt ->
            adapter = PlayersAdapter(ctxt)
            recyclerView.adapter = adapter
        }
    }

    fun displayPlayers(playerList: List<Player>) {
        adapter.data = playerList
        adapter.notifyDataSetChanged()
    }

}